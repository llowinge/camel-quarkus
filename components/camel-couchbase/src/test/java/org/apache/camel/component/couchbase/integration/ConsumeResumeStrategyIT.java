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
package org.apache.camel.component.couchbase.integration;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.couchbase.client.java.Bucket;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.couchbase.CouchbaseResumeAdapter;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.processor.resume.TransientResumeStrategy;
import org.apache.camel.support.resume.Resumables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.awaitility.Awaitility.await;

public class ConsumeResumeStrategyIT extends CouchbaseIntegrationTestBase {
    static class TestCouchbaseResumeAdapter implements CouchbaseResumeAdapter {
        volatile boolean setBucketCalled;
        volatile boolean bucketNotNull;
        volatile boolean resumeCalled;

        @Override
        public void setBucket(Bucket bucket) {
            setBucketCalled = true;
            bucketNotNull = bucket != null;
        }

        @Override
        public void resume() {
            resumeCalled = true;
        }
    }

    TransientResumeStrategy resumeStrategy = new TransientResumeStrategy(new TestCouchbaseResumeAdapter());

    @Test
    public void testQueryForBeers() throws Exception {
        for (int i = 0; i < 15; i++) {
            cluster.bucket(bucketName).defaultCollection().upsert("DocumentID_" + i, "message" + i);
        }
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(10);

        assertMockEndpointsSatisfied(30, TimeUnit.SECONDS);

        TestCouchbaseResumeAdapter adapter = resumeStrategy.getAdapter(TestCouchbaseResumeAdapter.class);
        await().atMost(30, TimeUnit.SECONDS).until(() -> adapter != null);

        await().atMost(30, TimeUnit.SECONDS)
                .untilAsserted(() -> Assertions.assertTrue(adapter.setBucketCalled,
                        "The setBucket method should have been called"));
        await().atMost(3, TimeUnit.SECONDS)
                .untilAsserted(() -> Assertions.assertTrue(adapter.bucketNotNull,
                        "The input bucket should not have been null"));
        await().atMost(3, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> Assertions.assertTrue(adapter.resumeCalled, "The resume method should have been called"));
    }

    @AfterEach
    public void cleanBucket() {
        cluster.buckets().flushBucket(bucketName);
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(String.format("%s&designDocumentName=%s&viewName=%s&limit=10", getConnectionUri(), bucketName, bucketName))
                        .resumable().resumeStrategy(resumeStrategy)
                        .setHeader(Exchange.OFFSET,
                                constant(Resumables.of("key", ThreadLocalRandom.current().nextInt(1, 1000))))
                        .log("message received")
                        .to("mock:result");
            }
        };

    }
}