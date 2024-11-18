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
package org.apache.camel.quarkus.component.jdbc.mysql;

import com.mysql.cj.protocol.a.authentication.CachingSha2PasswordPlugin;
import com.mysql.cj.protocol.a.authentication.Sha256PasswordPlugin;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Sha256FIPSPasswordPlugin extends CachingSha2PasswordPlugin {

    public Sha256FIPSPasswordPlugin() {
        super();
    }

    @Override
    public String getProtocolPluginName() {
        return "cq";
    }

    @Override
    protected byte[] encryptPassword() {
        return encryptPassword("RSA/ECB/PKCS1Padding");
    }
}
