package org.apache.camel.quarkus.component.aws.secrets.manager.it;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class AwsSecretsManagerRouteBuilder extends RouteBuilder {

    public static final String MSG_FIRST = "We have received the top secret message.";
    public static final String MSG_SECOND = "We have received the updated top secret message.";

    @Override
    public void configure() throws Exception {
        from("direct:loadFirst")
                .setBody(simple(MSG_FIRST));
        from("direct:loadSecond")
                .setBody(simple(MSG_SECOND));
    }
}
