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
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.apache.camel.ProducerTemplate;

@Path("/ocsf")
@ApplicationScoped
public class OcsfResource {

    @Inject
    ProducerTemplate producerTemplate;

    @POST
    @Path("/marshal/event")
    @Produces(MediaType.APPLICATION_JSON)
    public String marshalEvent(@QueryParam("message") String message) {
        return producerTemplate.requestBody("direct:marshal-event", message, String.class);
    }

    @POST
    @Path("/unmarshal/event")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String unmarshalEvent(String body) {
        return producerTemplate.requestBody("direct:unmarshal-event", body, String.class);
    }

    @POST
    @Path("/marshal/finding")
    @Produces(MediaType.APPLICATION_JSON)
    public String marshalFinding(@QueryParam("title") String title, @QueryParam("riskLevel") String riskLevel) {
        return producerTemplate.requestBodyAndHeaders(
                "direct:marshal-finding",
                "",
                java.util.Map.of(
                        "title", title,
                        "riskLevel", riskLevel),
                String.class);
    }

    @POST
    @Path("/unmarshal/finding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String unmarshalFinding(String body) {
        return producerTemplate.requestBody("direct:unmarshal-finding", body, String.class);
    }

    @POST
    @Path("/unmarshal/unknown-properties")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String unmarshalUnknownProperties(String body) {
        return producerTemplate.requestBody("direct:unmarshal-unknown", body, String.class);
    }
}
