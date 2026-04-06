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
package org.apache.camel.quarkus.component.ocsf.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourceDirectoryBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveHierarchyBuildItem;
import org.apache.camel.dataformat.ocsf.model.DetectionFinding;
import org.apache.camel.dataformat.ocsf.model.OcsfEvent;
import org.jboss.jandex.Type;

class OcsfProcessor {

    private static final String FEATURE = "camel-ocsf";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    NativeImageResourceDirectoryBuildItem nativeImageResources() {
        return new NativeImageResourceDirectoryBuildItem("schema");
    }

    @BuildStep
    ReflectiveHierarchyBuildItem ocsfEventHierarchy() {
        return ReflectiveHierarchyBuildItem.builder(Type.create(OcsfEvent.class)).ignoreNested(false).build();
    }

    @BuildStep
    ReflectiveHierarchyBuildItem detectionFindingHierarchy() {
        return ReflectiveHierarchyBuildItem.builder(Type.create(DetectionFinding.class)).ignoreNested(false).build();
    }

    @BuildStep
    ReflectiveClassBuildItem jacksonSupport() {
        return ReflectiveClassBuildItem.builder("com.fasterxml.jackson.datatype.jsr310.JavaTimeModule")
                .constructors()
                .methods()
                .build();
    }
}
