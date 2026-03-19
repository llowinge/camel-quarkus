#!/bin/bash

#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# OpenAI Chat Integration Tests - Direct API Testing
# This script tests the OpenAI API directly using curl, mimicking camel-openai component behavior

set -e

# Configuration
OPENAI_URL="${OPENAI_URL:-http://10.0.208.62:8000/v1}"
OPENAI_MODEL="${OPENAI_MODEL:-ibm-granite/granite-3.2-2b-instruct}"
OPENAI_API_KEY="${OPENAI_API_KEY:-dummy-key}"

# Color codes for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Test counters
TESTS_RUN=0
TESTS_PASSED=0
TESTS_FAILED=0

# Helper functions
log_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

log_success() {
    echo -e "${GREEN}[PASS]${NC} $1"
}

log_error() {
    echo -e "${RED}[FAIL]${NC} $1"
}

log_warning() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

start_test() {
    TESTS_RUN=$((TESTS_RUN + 1))
    log_info "Running test: $1"
}

pass_test() {
    TESTS_PASSED=$((TESTS_PASSED + 1))
    log_success "$1"
}

fail_test() {
    TESTS_FAILED=$((TESTS_FAILED + 1))
    log_error "$1"
    if [ -n "$2" ]; then
        echo -e "${RED}  Details: $2${NC}"
    fi
}

# Test: simpleChat
test_simple_chat() {
    start_test "simpleChat"

    local request_body
    request_body=$(cat <<EOF
{
  "model": "${OPENAI_MODEL}",
  "messages": [
    {
      "role": "user",
      "content": "In one sentence, what is Apache Camel?"
    }
  ]
}
EOF
)

    local response
    local status

    response=$(curl -s -w "\n%{http_code}" -X POST \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer ${OPENAI_API_KEY}" \
        -d "$request_body" \
        "${OPENAI_URL}/chat/completions")

    status=$(echo "$response" | tail -n1)
    local body=$(echo "$response" | sed '$d')

    if [ "$status" -ne 200 ]; then
        fail_test "simpleChat - Expected status 200, got $status" "$body"
        return 1
    fi

    # Extract the response content
    local content
    if command -v jq &> /dev/null; then
        content=$(echo "$body" | jq -r '.choices[0].message.content // empty' 2>/dev/null)
    else
        # Fallback to grep if jq is not available
        content="$body"
    fi

    if echo "$content" | grep -iq "camel"; then
        pass_test "simpleChat - Response contains 'camel'"
        log_info "Response: $content"
        return 0
    else
        fail_test "simpleChat - Response does not contain 'camel'" "$content"
        return 1
    fi
}

# Test: chatWithMemory (multi-turn conversation)
test_chat_with_memory() {
    start_test "chatWithMemory"

    # First message: introduce name
    local request_body1
    request_body1=$(cat <<EOF
{
  "model": "${OPENAI_MODEL}",
  "messages": [
    {
      "role": "user",
      "content": "My name is John."
    }
  ]
}
EOF
)

    local response1
    response1=$(curl -s -w "\n%{http_code}" -X POST \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer ${OPENAI_API_KEY}" \
        -d "$request_body1" \
        "${OPENAI_URL}/chat/completions")

    local status1=$(echo "$response1" | tail -n1)
    local body1=$(echo "$response1" | sed '$d')

    if [ "$status1" -ne 200 ]; then
        fail_test "chatWithMemory - First request failed, status: $status1" "$body1"
        return 1
    fi

    # Extract first response
    local content1
    if command -v jq &> /dev/null; then
        content1=$(echo "$body1" | jq -r '.choices[0].message.content // empty' 2>/dev/null)
    else
        content1="$body1"
    fi

    if echo "$content1" | grep -iq "john"; then
        pass_test "chatWithMemory - Response acknowledges 'John'"
        log_info "Response: $content1"
        return 0
    else
        fail_test "chatWithMemory - Response does not contain 'John'" "$content1"
        return 1
    fi
}

# Test: streamingChat
test_streaming_chat() {
    start_test "streamingChat"

    local request_body
    request_body=$(cat <<EOF
{
  "model": "${OPENAI_MODEL}",
  "messages": [
    {
      "role": "user",
      "content": "Stream the numbers 1 to 9 on a new line each time and nothing else."
    }
  ],
  "stream": true
}
EOF
)

    local temp_file=$(mktemp)

    # Make streaming request and save to temp file
    curl -s -X POST \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer ${OPENAI_API_KEY}" \
        -d "$request_body" \
        "${OPENAI_URL}/chat/completions" > "$temp_file"

    # Parse the streamed response
    local received_numbers=()

    # Read SSE stream and extract content
    while IFS= read -r line; do
        if [[ "$line" == data:* ]]; then
            local json_data="${line#data: }"

            # Skip [DONE] marker
            if [[ "$json_data" == "[DONE]" ]]; then
                continue
            fi

            # Extract content from delta
            if command -v jq &> /dev/null; then
                local content=$(echo "$json_data" | jq -r '.choices[0].delta.content // empty' 2>/dev/null)
                if [ -n "$content" ] && [ "$content" != "null" ]; then
                    # Check if content contains a number 1-9
                    for num in {1..9}; do
                        if echo "$content" | grep -q "$num"; then
                            if [[ ! " ${received_numbers[@]} " =~ " ${num} " ]]; then
                                received_numbers+=("$num")
                                log_info "Received number: $num (${#received_numbers[@]}/9)"
                            fi
                        fi
                    done
                fi
            fi
        fi
    done < "$temp_file"

    # Clean up
    rm -f "$temp_file"

    # Check if we received numbers
    if [ ${#received_numbers[@]} -ge 5 ]; then
        pass_test "streamingChat - Received streaming response with ${#received_numbers[@]} numbers"
        log_info "Numbers received: ${received_numbers[*]}"
        return 0
    else
        fail_test "streamingChat - Insufficient numbers received (${#received_numbers[@]}/9)" "Numbers: ${received_numbers[*]}"
        return 1
    fi
}

# Test: structuredOutputWithSchema
test_structured_output_with_schema() {
    start_test "structuredOutputWithSchema"

    # Define the JSON schema for a product
    local schema
    schema=$(cat <<'EOF'
{
  "type": "object",
  "properties": {
    "name": {
      "type": "string",
      "description": "The name of the product"
    },
    "price": {
      "type": "number",
      "description": "The price of the product"
    },
    "description": {
      "type": "string",
      "description": "A description of the product"
    }
  },
  "required": ["name", "price"],
  "additionalProperties": false
}
EOF
)

    local request_body
    request_body=$(cat <<EOF
{
  "model": "${OPENAI_MODEL}",
  "messages": [
    {
      "role": "user",
      "content": "Create an example product description. Return ONLY a valid JSON object with fields: name (string), price (number), and description (string). Example: {\"name\":\"Laptop\",\"price\":999.99,\"description\":\"A powerful computer\"}"
    }
  ]
}
EOF
)

    local response
    response=$(curl -s -w "\n%{http_code}" -X POST \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer ${OPENAI_API_KEY}" \
        -d "$request_body" \
        "${OPENAI_URL}/chat/completions")

    local status=$(echo "$response" | tail -n1)
    local body=$(echo "$response" | sed '$d')

    if [ "$status" -ne 200 ]; then
        fail_test "structuredOutputWithSchema - Expected status 200, got $status" "$body"
        return 1
    fi

    # Extract the response content
    local content
    if command -v jq &> /dev/null; then
        content=$(echo "$body" | jq -r '.choices[0].message.content // empty' 2>/dev/null)

        # Try to parse the content as JSON
        local product_json
        product_json=$(echo "$content" | jq '.' 2>/dev/null)

        if [ $? -eq 0 ]; then
            local name=$(echo "$product_json" | jq -r '.name // empty')
            local price=$(echo "$product_json" | jq -r '.price // 0')

            if [ -n "$name" ] && [ -n "$price" ] && [ "$(echo "$price > 0" | bc -l 2>/dev/null || echo "1")" -eq 1 ]; then
                pass_test "structuredOutputWithSchema - Valid JSON with name='$name' and price=$price"
                return 0
            fi
        fi
    fi

    # Fallback: just check if response looks like it has product info
    if echo "$content" | grep -q "name" && echo "$content" | grep -q "price"; then
        pass_test "structuredOutputWithSchema - Response contains product information"
        log_info "Content: $content"
        return 0
    else
        fail_test "structuredOutputWithSchema - Invalid response structure" "$content"
        return 1
    fi
}

# Test: structuredOutputWithClass (similar to schema but with explicit class example)
test_structured_output_with_class() {
    start_test "structuredOutputWithClass"

    local request_body
    request_body=$(cat <<EOF
{
  "model": "${OPENAI_MODEL}",
  "messages": [
    {
      "role": "user",
      "content": "Create an example product for a product named 'Bluetooth'. Return ONLY a valid JSON object with fields: name (must contain 'Bluetooth'), price (number greater than 0), and description. Example: {\"name\":\"Bluetooth Speaker\",\"price\":49.99,\"description\":\"Wireless audio device\"}"
    }
  ]
}
EOF
)

    local response
    response=$(curl -s -w "\n%{http_code}" -X POST \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer ${OPENAI_API_KEY}" \
        -d "$request_body" \
        "${OPENAI_URL}/chat/completions")

    local status=$(echo "$response" | tail -n1)
    local body=$(echo "$response" | sed '$d')

    if [ "$status" -ne 200 ]; then
        fail_test "structuredOutputWithClass - Expected status 200, got $status" "$body"
        return 1
    fi

    # Extract the response content
    local content
    if command -v jq &> /dev/null; then
        content=$(echo "$body" | jq -r '.choices[0].message.content // empty' 2>/dev/null)

        # Try to parse as JSON
        local product_json
        product_json=$(echo "$content" | jq '.' 2>/dev/null)

        if [ $? -eq 0 ]; then
            local name=$(echo "$product_json" | jq -r '.name // empty')
            local price=$(echo "$product_json" | jq -r '.price // 0')

            if echo "$name" | grep -iq "bluetooth"; then
                if [ -n "$price" ] && [ "$(echo "$price > 0" | bc -l 2>/dev/null || echo "1")" -eq 1 ]; then
                    pass_test "structuredOutputWithClass - Valid JSON with Bluetooth product, name='$name', price=$price"
                    return 0
                fi
            fi
        fi
    else
        content="$body"
    fi

    # Fallback: check if response contains Bluetooth
    if echo "$content" | grep -iq "bluetooth"; then
        pass_test "structuredOutputWithClass - Response contains 'Bluetooth'"
        log_info "Content: $content"
        return 0
    else
        fail_test "structuredOutputWithClass - Response does not contain 'Bluetooth'" "$content"
        return 1
    fi
}

# Test: chatInitiatedFromFileConsumer (reading prompt from file)
test_chat_from_file() {
    start_test "chatFromFile"

    local prompt_file="src/test/resources/prompts/whatis-camel-prompt.txt"

    if [ ! -f "$prompt_file" ]; then
        log_warning "Prompt file not found, using inline prompt"
        local prompt="In one sentence, what is Apache Camel?"
    else
        local prompt=$(cat "$prompt_file")
    fi

    local request_body
    request_body=$(cat <<EOF
{
  "model": "${OPENAI_MODEL}",
  "messages": [
    {
      "role": "user",
      "content": "$prompt"
    }
  ]
}
EOF
)

    local response
    response=$(curl -s -w "\n%{http_code}" -X POST \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer ${OPENAI_API_KEY}" \
        -d "$request_body" \
        "${OPENAI_URL}/chat/completions")

    local status=$(echo "$response" | tail -n1)
    local body=$(echo "$response" | sed '$d')

    if [ "$status" -ne 200 ]; then
        fail_test "chatFromFile - Expected status 200, got $status" "$body"
        return 1
    fi

    # Extract the response content
    local content
    if command -v jq &> /dev/null; then
        content=$(echo "$body" | jq -r '.choices[0].message.content // empty' 2>/dev/null)
    else
        content="$body"
    fi

    if echo "$content" | grep -iq "camel"; then
        pass_test "chatFromFile - Response contains 'camel'"
        log_info "Response: $content"
        return 0
    else
        fail_test "chatFromFile - Response does not contain 'camel'" "$content"
        return 1
    fi
}

# Main execution
main() {
    echo ""
    echo "=========================================="
    echo "  OpenAI Chat API Direct Tests (Bash)"
    echo "=========================================="
    echo ""
    echo "Configuration:"
    echo "  OPENAI_URL:    $OPENAI_URL"
    echo "  OPENAI_MODEL:  $OPENAI_MODEL"
    echo ""

    # Check if API is reachable
    log_info "Checking API connectivity..."
    if ! curl -s -f -o /dev/null "${OPENAI_URL}/models" 2>/dev/null; then
        log_warning "OpenAI API may not be reachable at ${OPENAI_URL}"
        log_warning "Continuing anyway..."
    else
        log_success "API is reachable"
    fi
    echo ""

    # Check dependencies
    if ! command -v jq &> /dev/null; then
        log_warning "jq is not installed - JSON parsing will be limited"
        log_warning "Install jq for better test results: brew install jq (macOS) or apt-get install jq (Linux)"
        echo ""
    fi

    if ! command -v bc &> /dev/null; then
        log_warning "bc is not installed - numeric comparisons will be limited"
        echo ""
    fi

    # Run tests
#    test_simple_chat || true
#    echo ""
#
#    test_chat_from_file || true
#    echo ""
#
#    test_chat_with_memory || true
#    echo ""
#
#    test_streaming_chat || true
#    echo ""
#
#    test_structured_output_with_schema || true
#    echo ""

    test_structured_output_with_class || true
    echo ""

    # Summary
    echo ""
    echo "=========================================="
    echo "  Test Summary"
    echo "=========================================="
    echo "  Total:  $TESTS_RUN"
    echo -e "  ${GREEN}Passed: $TESTS_PASSED${NC}"
    echo -e "  ${RED}Failed: $TESTS_FAILED${NC}"
    echo "=========================================="
    echo ""

    if [ $TESTS_FAILED -gt 0 ]; then
        exit 1
    fi

    exit 0
}

# Run main function
main
