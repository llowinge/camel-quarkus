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
package org.apache.camel.quarkus.component.ocsf.it;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.ocsf.OcsfConstants;
import org.apache.camel.dataformat.ocsf.model.DetectionFinding;
import org.apache.camel.dataformat.ocsf.model.FindingInfo;
import org.apache.camel.dataformat.ocsf.model.OcsfEvent;

@ApplicationScoped
public class OcsfRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:marshal-event")
                .process(exchange -> {
                    String message = exchange.getIn().getBody(String.class);

                    OcsfEvent event = new OcsfEvent();
                    event.setClassUid(OcsfConstants.CLASS_DETECTION_FINDING);
                    event.setClassName("Detection Finding");
                    event.setCategoryUid(OcsfConstants.CATEGORY_FINDINGS);
                    event.setCategoryName("Findings");
                    event.setActivityId(OcsfConstants.ACTIVITY_CREATE);
                    event.setSeverityId(OcsfConstants.SEVERITY_HIGH);
                    event.setTime(1706000000L);
                    event.setMessage(message);

                    exchange.getIn().setBody(event);
                })
                .marshal().ocsf();

        from("direct:unmarshal-event")
                .unmarshal().ocsf()
                .process(exchange -> {
                    OcsfEvent event = exchange.getIn().getBody(OcsfEvent.class);
                    exchange.getIn().setBody(
                            "{\"classUid\":" + event.getClassUid()
                                    + ",\"severityId\":" + event.getSeverityId()
                                    + ",\"message\":\"" + event.getMessage() + "\"}");
                });

        from("direct:marshal-finding")
                .process(exchange -> {
                    DetectionFinding finding = new DetectionFinding();
                    finding.setIsAlert(true);
                    finding.setRiskLevelId(4);
                    finding.setRiskLevel(exchange.getIn().getHeader("riskLevel", String.class));

                    FindingInfo info = new FindingInfo();
                    info.setUid("finding-123");
                    info.setTitle(exchange.getIn().getHeader("title", String.class));
                    info.setDesc("Potential ransomware detected on endpoint");
                    finding.setFindingInfo(info);

                    finding.setAdditionalProperty("class_uid", OcsfConstants.CLASS_DETECTION_FINDING);
                    finding.setAdditionalProperty("class_name", "Detection Finding");
                    finding.setAdditionalProperty("category_uid", OcsfConstants.CATEGORY_FINDINGS);
                    finding.setAdditionalProperty("category_name", "Findings");
                    finding.setAdditionalProperty("activity_id", OcsfConstants.ACTIVITY_CREATE);
                    finding.setAdditionalProperty("severity_id", OcsfConstants.SEVERITY_CRITICAL);
                    finding.setAdditionalProperty("time", 1706000000L);

                    exchange.getIn().setBody(finding);
                })
                .marshal().ocsf();

        from("direct:unmarshal-finding")
                .unmarshal().ocsf(DetectionFinding.class)
                .process(exchange -> {
                    DetectionFinding finding = exchange.getIn().getBody(DetectionFinding.class);
                    exchange.getIn().setBody(
                            finding.getAdditionalProperties().get("class_uid") + "|"
                                    + finding.getAdditionalProperties().get("severity_id") + "|"
                                    + finding.getIsAlert() + "|" + finding.getRiskLevel() + "|"
                                    + finding.getFindingInfo().getTitle());
                });

        from("direct:unmarshal-unknown")
                .unmarshal().ocsf()
                .process(exchange -> {
                    OcsfEvent event = exchange.getIn().getBody(OcsfEvent.class);
                    exchange.getIn().setBody(
                            event.getAdditionalProperties().get("unknown_property") + "|"
                                    + event.getAdditionalProperties().get("another_unknown"));
                });
    }
}
