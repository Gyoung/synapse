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

package org.apache.synapse.config.xml;

import javax.xml.namespace.QName;

import org.apache.synapse.SynapseException;
import org.apache.synapse.api.Mediator;
import org.apache.synapse.mediators.builtin.LogMediator;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jaxen.JaxenException;

import java.util.Iterator;
import java.util.List;

/**
 * Created a Log mediator that logs messages using commons-logging.
 *
 * <log [level="simple|headers|full|custom"]>
 *      <property> *
 * </log>
 */
public class LogMediatorFactory extends AbstractMediatorFactory {

    private static final Log log = LogFactory.getLog(LogMediatorFactory.class);

    private static final QName LOG_Q    = new QName(Constants.SYNAPSE_NAMESPACE, "log");
    private static final String SIMPLE  = "simple";
    private static final String HEADERS = "headers";
    private static final String FULL    = "full";
    private static final String CUSTOM  = "custom";

    public QName getTagQName() {
        return LOG_Q;
    }

    public Mediator createMediator(OMElement elem) {

        LogMediator logMediator = new LogMediator();

        // Set the high level set of properties to be logged (i.e. log level)
        OMAttribute level = elem.getAttribute(new QName(Constants.NULL_NAMESPACE, "level"));
        if (level != null) {
            if (SIMPLE.equals(level)) {
                logMediator.setLogLevel(LogMediator.SIMPLE);
            } else if (HEADERS.equals(level)) {
                logMediator.setLogLevel(LogMediator.HEADERS);
            } else if (FULL.equals(level)) {
                logMediator.setLogLevel(LogMediator.FULL);
            } else if (CUSTOM.equals(level)) {
                logMediator.setLogLevel(LogMediator.CUSTOM);
            }
        }

        // check if a custom seperator has been supplied, if so use it
        OMAttribute seperator = elem.getAttribute(new QName(Constants.NULL_NAMESPACE, "seperator"));
        if (seperator != null) {
            logMediator.setSeperator(seperator.getAttributeValue());
        }

        logMediator.addAllProperties(MediatorPropertyFactory.getMediatorProperties(elem));

        return logMediator;
    }

}
