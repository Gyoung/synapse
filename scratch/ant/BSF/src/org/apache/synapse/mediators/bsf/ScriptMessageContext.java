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
package org.apache.synapse.mediators.bsf;

import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.addressing.RelatesTo;
import org.apache.synapse.MessageContext;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.mediators.bsf.convertors.OMElementConvertor;

/**
 * ScriptMessageContext decorates the Synapse MessageContext adding methods to use the message payload XML in a way natural to the scripting language.
 */
public class ScriptMessageContext implements MessageContext {

    private MessageContext mc;

    private OMElementConvertor convertor;

    public ScriptMessageContext(MessageContext mc, OMElementConvertor convertor) {
        this.mc = mc;
        this.convertor = convertor;
    }

    /**
     * Get the XML representation of SOAP Body payload. 
     * The payload is the first element inside the SOAP <Body> tags
     * 
     * @return the XML SOAP Body
     */
    public Object getPayloadXML() {
        return convertor.toScript(mc.getEnvelope().getBody().getFirstElement());
    }

    /**
     * Set the SOAP body payload from XML
     * 
     * @param payload
     * @throws XMLStreamException
     */
    public void setPayloadXML(Object payload) {
        mc.getEnvelope().getBody().setFirstChild(convertor.fromScript(payload));
    }

    /**
     * Get the XML representation of the complete SOAP envelope
     */
    public Object getEnvelopeXML() {
        return convertor.toScript(mc.getEnvelope());
    }

    // helpers to set EPRs from a script string    
    
    public void setTo(String reference) {
        mc.setTo(new EndpointReference(reference));
    }
    public void setFaultTo(String reference) {
        mc.setFaultTo(new EndpointReference(reference));
    }
    public void setFrom(String reference) {
        mc.setFrom(new EndpointReference(reference));
    }
    public void setReplyTo(String reference) {
        mc.setReplyTo(new EndpointReference(reference));
    }

    // -- all the remainder just use the underlying MessageContext

    public SynapseConfiguration getConfiguration() {
        return mc.getConfiguration();
    }

    public void setConfiguration(SynapseConfiguration cfg) {
        mc.setConfiguration(cfg);
    }

    public SynapseEnvironment getEnvironment() {
        return mc.getEnvironment();
    }

    public void setEnvironment(SynapseEnvironment se) {
        mc.setEnvironment(se);
    }

    public Object getProperty(String key) {
        return mc.getConfiguration();
    }

    public void setProperty(String key, Object value) {
        mc.setProperty(key, value);
    }

    public Set getPropertyKeySet() {
        return mc.getPropertyKeySet();
    }

    public SOAPEnvelope getEnvelope() {
        return mc.getEnvelope();
    }

    public void setEnvelope(SOAPEnvelope envelope) throws AxisFault {
        mc.setEnvelope(envelope);
    }

    public EndpointReference getFaultTo() {
        return mc.getFaultTo();
    }

    public void setFaultTo(EndpointReference reference) {
        mc.setFaultTo(reference);
    }

    public EndpointReference getFrom() {
        return mc.getFrom();
    }

    public void setFrom(EndpointReference reference) {
        mc.setFrom(reference);
    }

    public String getMessageID() {
        return mc.getMessageID();
    }

    public void setMessageID(String string) {
        mc.setMessageID(string);
    }

    public RelatesTo getRelatesTo() {
        return mc.getRelatesTo();
    }

    public void setRelatesTo(RelatesTo[] reference) {
        mc.setRelatesTo(reference);
    }

    public EndpointReference getReplyTo() {
        return mc.getReplyTo();
    }

    public void setReplyTo(EndpointReference reference) {
        mc.setReplyTo(reference);
    }

    public EndpointReference getTo() {
        return mc.getTo();
    }

    public void setTo(EndpointReference reference) {
        mc.setTo(reference);
    }

    public void setWSAAction(String actionURI) {
        mc.setWSAAction(actionURI);
    }

    public String getWSAAction() {
        return mc.getWSAAction();
    }

    public String getSoapAction() {
        return mc.getSoapAction();
    }

    public void setSoapAction(String string) {
        mc.setSoapAction(string);
    }

    public void setMessageId(String messageID) {
        mc.setMessageId(messageID);
    }

    public String getMessageId() {
        return mc.getMessageId();
    }

    public boolean isDoingMTOM() {
        return mc.isDoingMTOM();
    }

    public void setDoingMTOM(boolean b) {
        mc.setDoingMTOM(b);
    }

    public boolean isDoingREST() {
        return mc.isDoingREST();
    }

    public void setDoingREST(boolean b) {
        mc.setDoingREST(b);
    }

    public boolean isSOAP11() {
        return mc.isSOAP11();
    }

    public void setResponse(boolean b) {
        mc.setResponse(b);
    }

    public boolean isResponse() {
        return mc.isResponse();
    }

    public void setFaultResponse(boolean b) {
        mc.setFaultResponse(b);
    }

    public boolean isFaultResponse() {
        return mc.isFaultResponse();
    }

}