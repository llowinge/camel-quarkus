package org.apache.camel.quarkus.component.aws.secrets.manager.it;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.apache.camel.quarkus.test.support.aws2.Aws2TestResource;
import org.apache.camel.spi.CamelEvent;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(Aws2TestResource.class)
@TestProfile(ContextReloadEnabled.class)
public class CamelContextRefreshOnSecretRefreshTest extends AwsSecretsManagerAbstractTest {
    @Inject
    EventHandler handler;

    @Test
    public void testCamelContextReloadOnSecretRefresh() {
        String secretArn = null;
        try {
            final String myUniqueSecretValue = "Uniqueee1234";
            secretArn = createSecret(ConfigProvider.getConfig().getValue("camel.vault.aws.secrets", String.class),
                    myUniqueSecretValue);
            Assertions.assertEquals(1, handler.reloads.size());
        } finally {
            deleteSecretImmediately(secretArn);
        }
    }

    @ApplicationScoped
    public static class EventHandler {
        private final List<CamelEvent.CamelContextReloadedEvent> reloads = new CopyOnWriteArrayList<>();

        public void onCamelContextReloaded(@Observes CamelEvent.CamelContextReloadedEvent event) {
            reloads.add(event);
            System.out.println("Reloaded" + event);
        }
    }
}
