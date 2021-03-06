/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.synapse;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.addressing.RelatesTo;
import org.apache.axis2.soap.SOAPEnvelope;

/**
 *
 * 
 * <p> The core definition of a message flowing thru Axis.
 *
 */
public interface SynapseMessage {

	public EndpointReference getFaultTo();

	public void setFaultTo(EndpointReference reference);

	public EndpointReference getFrom();

	public void setFrom(EndpointReference reference);

	public SOAPEnvelope getEnvelope();

	public void setEnvelope(SOAPEnvelope envelope) throws AxisFault;

	public String getMessageID();

	public void setMessageID(String string);

	public RelatesTo getRelatesTo();

	public void setRelatesTo(RelatesTo reference);

	public EndpointReference getReplyTo();

	public void setReplyTo(EndpointReference reference);

	public EndpointReference getTo();

	public void setTo(EndpointReference reference);

	public void setWSAAction(String actionURI);

	public String getWSAAction();

	public void setWSAMessageId(String messageID);

	public String getWSAMessageId();

	public Object getProperty(String key);

	public void setProperty(String key, Object value);

	public String getSoapAction();

	public void setSoapAction(String string);

	public boolean isDoingMTOM();

	public void setDoingMTOM(boolean b);

	public boolean isDoingREST();

	public void setDoingREST(boolean b);

	public boolean isSOAP11();

	public void setResponse(boolean b);

	public boolean isResponse();
}
