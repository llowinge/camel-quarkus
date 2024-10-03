package org.apache.camel.quarkus.component.aws.secrets.manager.it;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.camel.component.aws.secretsmanager.SecretsManagerConstants;
import org.apache.camel.component.aws.secretsmanager.SecretsManagerOperations;
import org.apache.camel.quarkus.test.EnabledIf;
import org.apache.camel.quarkus.test.mock.backend.MockBackendDisabled;
import org.apache.camel.quarkus.test.support.aws2.Aws2TestResource;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.org.awaitility.Awaitility;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(Aws2TestResource.class)
@TestProfile(ContextReloadTestProfile.class)
// disabled on Localstack due to https://docs.localstack.cloud/references/coverage/coverage_cloudtrail/#lookupevents
@EnabledIf(MockBackendDisabled.class)
@Disabled("https://issues.apache.org/jira/browse/CAMEL-21324")
public class CamelContextRefreshOnSecretRefreshTest extends AwsSecretsManagerAbstractTest {
    @Test
    public void testCamelContextReloadOnSecretRefresh() {
        String secretArn = null;
        try {
            final String myUniqueSecretValue = "Uniqueee1234";
            secretArn = createSecret(ConfigProvider.getConfig().getValue("camel.vault.aws.secrets", String.class),
                    myUniqueSecretValue);
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(Collections.singletonMap(SecretsManagerConstants.SECRET_ID, secretArn))
                    .queryParam("body", myUniqueSecretValue + "-diff")
                    .post("/aws-secrets-manager/operation/" + SecretsManagerOperations.updateSecret)
                    .then()
                    .statusCode(201)
                    .body(is("true"));
            Awaitility.await().pollInterval(5, TimeUnit.SECONDS).atMost(5, TimeUnit.MINUTES).untilAsserted(
                    () -> {
                        RestAssured.get("/aws-secrets-manager/context/reload")
                                .then()
                                .statusCode(200)
                                .body(is("true"));
                    });
        } finally {
            deleteSecretImmediately(secretArn);
        }
    }
}
