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
package org.apache.camel.quarkus.component.cli.connector;

import io.quarkus.runtime.LaunchMode;
import org.apache.camel.cli.connector.LocalCliConnector;
import org.apache.camel.spi.CliConnectorFactory;

public class QuarkusLocalCliConnector extends LocalCliConnector {
    public QuarkusLocalCliConnector(CliConnectorFactory cliConnectorFactory) {
        super(cliConnectorFactory);
    }

    @Override
    public void sigterm() {
        if (LaunchMode.current().equals(LaunchMode.DEVELOPMENT)) {
            // If Camel JBang launched us in dev mode, then stopping the CamelContext is not enough as dev mode will remain running.
            // Therefore, init app shutdown which will still shut Camel down gracefully
            System.exit(0);
        } else {
            super.sigterm();
        }
    }
}
