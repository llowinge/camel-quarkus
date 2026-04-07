package org.apache.camel.quarkus.core.runtime;

import org.apache.camel.builder.RouteBuilder;

public class HotReloadRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("timer:hotReloadTest?repeatCount=1")
                .log("Original Route Message");
    }
}
