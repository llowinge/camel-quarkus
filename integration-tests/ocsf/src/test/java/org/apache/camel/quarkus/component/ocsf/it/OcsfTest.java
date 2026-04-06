/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.quarkus.component.ocsf.it;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class OcsfTest {

    @Test
    void marshalOcsfEvent() {
        RestAssured.given()
                .queryParam("message", "Test security event")
                .post("/ocsf/marshal/event")
                .then()
                .statusCode(200)
                .body(containsString("\"class_uid\":2004"))
                .body(containsString("\"severity_id\":4"))
                .body(containsString("\"message\":\"Test security event\""));
    }

    @Test
    void unmarshalOcsfEvent() {
        RestAssured.given()
                .contentType("application/json")
                .body("""
                        {
                            "class_uid": 2004,
                            "class_name": "Detection Finding",
                            "category_uid": 2,
                            "category_name": "Findings",
                            "activity_id": 1,
                            "severity_id": 4,
                            "time": 1706000000,
                            "message": "Suspicious activity detected"
                        }
                        """)
                .post("/ocsf/unmarshal/event")
                .then()
                .statusCode(200)
                .body("classUid", equalTo(2004))
                .body("severityId", equalTo(4))
                .body("message", equalTo("Suspicious activity detected"));
    }

    @Test
    void marshalDetectionFinding() {
        RestAssured.given()
                .queryParam("title", "Malware Detected")
                .queryParam("riskLevel", "High")
                .post("/ocsf/marshal/finding")
                .then()
                .statusCode(200)
                .body(containsString("\"class_uid\":2004"))
                .body(containsString("\"is_alert\":true"))
                .body(containsString("\"title\":\"Malware Detected\""))
                .body(containsString("\"risk_level\":\"High\""));
    }

    @Test
    void unmarshalDetectionFinding() {
        RestAssured.given()
                .contentType("application/json")
                .body("""
                        {
                            "class_uid": 2004,
                            "class_name": "Detection Finding",
                            "category_uid": 2,
                            "category_name": "Findings",
                            "activity_id": 1,
                            "severity_id": 5,
                            "time": 1706000000,
                            "is_alert": true,
                            "risk_level": "Critical",
                            "risk_level_id": 5,
                            "finding_info": {
                                "uid": "finding-456",
                                "title": "Data Exfiltration Attempt",
                                "desc": "Unusual outbound data transfer detected"
                            }
                        }
                        """)
                .post("/ocsf/unmarshal/finding")
                .then()
                .statusCode(200)
                .body(equalTo("2004|5|true|Critical|Data Exfiltration Attempt"));
    }

    @Test
    void unmarshalWithUnknownProperties() {
        RestAssured.given()
                .contentType("application/json")
                .body("""
                        {
                            "class_uid": 2004,
                            "severity_id": 3,
                            "time": 1706000000,
                            "unknown_property": "should be captured",
                            "another_unknown": 123
                        }
                        """)
                .post("/ocsf/unmarshal/unknown-properties")
                .then()
                .statusCode(200)
                .body(equalTo("should be captured|123"));
    }
}
