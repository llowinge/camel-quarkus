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
package org.apache.camel.opentelemetry2;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.telemetry.Op;
import org.apache.camel.telemetry.SpanDecorator;
import org.apache.camel.telemetry.SpanDecoratorManager;
import org.apache.camel.telemetry.SpanDecoratorManagerImpl;
import org.apache.camel.telemetry.decorators.PlatformHttpSpanDecorator;
import org.apache.camel.telemetry.decorators.ServletSpanDecorator;
import org.jboss.logging.Logger;

/**
 * Custom {@link OpenTelemetryTracer} to integrate better with the existing Vert.x tracing configured by the
 * Quarkus OpenTelemetry extension
 */
public class CamelQuarkusOpenTelemetry2Tracer extends OpenTelemetryTracer {

    private static final Logger LOG = Logger.getLogger(CamelQuarkusOpenTelemetry2Tracer.class);
    private final SpanDecoratorManager spanDecoratorManager = new SpanDecoratorManagerImpl();

    @Override
    protected void beginEventSpan(Exchange exchange, Endpoint endpoint, Op op) throws Exception {
        SpanDecorator sd = spanDecoratorManager.get(endpoint);
        LOG.info("I'm here with " + sd.getComponentClassName());
        if (!(sd instanceof PlatformHttpSpanDecorator) && !(sd instanceof ServletSpanDecorator)) {
            super.beginEventSpan(exchange, endpoint, op);
        }
    }
}
