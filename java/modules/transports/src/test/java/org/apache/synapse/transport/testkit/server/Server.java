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

package org.apache.synapse.transport.testkit.server;

import org.apache.synapse.transport.testkit.TestEnvironment;
import org.apache.synapse.transport.testkit.listener.Channel;

public abstract class Server<T extends TestEnvironment> {
    private final T setup;
    
    public Server(T setup) {
        this.setup = setup;
    }

//    public void addErrorListener(TransportErrorListener listener) {
//        if (listener instanceof TransportErrorSource) {
//            ((TransportErrorSource)listener).addErrorListener(listener);
//        }
//    }
//    
//    public void removeErrorListener(TransportErrorListener listener) {
//        if (listener instanceof TransportErrorSource) {
//            ((TransportErrorSource)listener).removeErrorListener(listener);
//        }
//    }

    public T getSetup() {
        return setup;
    }

    public abstract void start(T env, Channel<?> channel) throws Exception;
    public abstract void stop() throws Exception;
}
