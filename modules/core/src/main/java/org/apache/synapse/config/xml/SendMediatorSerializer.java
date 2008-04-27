/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.config.xml;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.endpoints.EndpointSerializer;
import org.apache.synapse.config.xml.endpoints.EndpointAbstractSerializer;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.endpoints.Endpoint;

/**
 * Serializer for {@link SendMediator} instances.
 * 
 * @see SendMediatorFactory
 */
public class SendMediatorSerializer extends AbstractMediatorSerializer {

    public OMElement serializeMediator(OMElement parent, Mediator m) {

        if (!(m instanceof SendMediator)) {
            handleException("Unsupported mediator passed in for serialization : " + m.getType());
        }

        SendMediator mediator = (SendMediator) m;
        OMElement send = fac.createOMElement("send", synNS);
        saveTracingState(send, mediator);

        Endpoint activeEndpoint = mediator.getEndpoint();
        if (activeEndpoint != null) {
            EndpointSerializer serializer = EndpointAbstractSerializer.
                    getEndpointSerializer(activeEndpoint);

            OMElement endpointElement = serializer.serializeEndpoint(activeEndpoint);
            send.addChild(endpointElement);
        }

        if (parent != null) {
            parent.addChild(send);
        }
        return send;
    }

    public String getMediatorClassName() {
        return SendMediator.class.getName();
    }
}
