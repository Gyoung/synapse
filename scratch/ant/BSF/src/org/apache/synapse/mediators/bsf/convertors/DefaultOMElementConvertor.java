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
package org.apache.synapse.mediators.bsf.convertors;

import java.io.ByteArrayInputStream;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.bsf.BSFEngine;
import org.apache.synapse.SynapseException;

/**
 * The DefaultOMElementConvertor converts between Synapse OMElements and Strings
 */
public class DefaultOMElementConvertor implements OMElementConvertor {

    public OMElement fromScript(Object o) {
        try {

            byte[] xmlBytes = o.toString().getBytes();
            StAXOMBuilder builder = new StAXOMBuilder(new ByteArrayInputStream(xmlBytes));
            OMElement omElement = builder.getDocumentElement();
            return omElement;

        } catch (XMLStreamException e) {
            throw new SynapseException(e);
        }
    }

    public Object toScript(OMElement omElement) {
        return omElement.toString();
    }

    public void setEngine(BSFEngine e) {
    }

}
