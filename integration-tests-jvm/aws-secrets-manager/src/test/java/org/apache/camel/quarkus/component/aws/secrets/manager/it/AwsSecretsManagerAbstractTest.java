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
package org.apache.camel.quarkus.component.aws.secrets.manager.it;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.quarkus.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.camel.component.aws.secretsmanager.SecretsManagerConstants;
import org.apache.camel.component.aws.secretsmanager.SecretsManagerOperations;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.testcontainers.shaded.org.awaitility.Awaitility;

import static org.hamcrest.CoreMatchers.is;

class AwsSecretsManagerAbstractTest {

    protected List<String> regions() {
        return List.of("us-east-1", "us-west-1");
    }

    protected String region() {
        Config config = ConfigProvider.getConfig();
        return config.getValue("camel.component.aws-secrets-manager.region", String.class);
    }

    protected String createSecret(String secretName, String secretValue) {
        String[] createdArnHolder = new String[1];

        Awaitility.await().pollInterval(5, TimeUnit.SECONDS).atMost(1, TimeUnit.MINUTES).until(
                () -> {
                    try {
                        createdArnHolder[0] = RestAssured.given()
                                .contentType(ContentType.JSON)
                                .body(Collections.singletonMap(SecretsManagerConstants.SECRET_NAME, secretName))
                                .queryParam("body", secretValue)
                                .post("/aws-secrets-manager/operation/" + SecretsManagerOperations.createSecret)
                                .then()
                                .statusCode(201)
                                .extract().asString();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
        return createdArnHolder[0];
    }

    protected Map<String, Boolean> listSecrets() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(Collections.emptyMap())
                .post("/aws-secrets-manager/operation/" + SecretsManagerOperations.listSecrets)
                .then()
                .statusCode(201)
                .extract().as(Map.class);
    }

    protected void deleteSecretImmediately(String arn) {
        if (arn != null) {
            Log.info("Deleting secret: " + arn);
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(Collections.singletonMap(SecretsManagerConstants.SECRET_ID, arn))
                    .post("/aws-secrets-manager/operation/forceDeleteSecret")
                    .then()
                    .statusCode(201)
                    .body(is("true"));
        }
    }
}
