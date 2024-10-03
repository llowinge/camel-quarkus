package org.apache.camel.quarkus.component.aws.secrets.manager.it;

import java.util.HashMap;
import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class ContextReloadTestProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        Map<String, String> props = new HashMap<>();
        props.put("camel.vault.aws.refreshEnabled", "true");
        props.put("camel.vault.aws.refreshPeriod", "5000");
        props.put("camel.vault.aws.secrets", "CQTestSecretContextReload" + System.currentTimeMillis());
        props.put("camel.main.context-reload-enabled", "true");
        return props;
    }
}
