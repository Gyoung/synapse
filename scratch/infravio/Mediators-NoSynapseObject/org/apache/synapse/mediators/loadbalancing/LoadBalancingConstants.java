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

package org.apache.synapse.mediators.loadbalancing;

public interface LoadBalancingConstants {

    public static final String CFG_LOADBALANCING_SERVICE = "loadBalancingService";
    public static final String CFG_LOADBALANCING_STRATEGY = "strategy";
    public static final String CFG_LOADBALANCING_PERF_COUNT = "count";
    public static final String CFG_LOADBALANCING_LAST_SERVICE = "lastService";
    public static final String CFG_PARAM_SERVICE = "service";
    public static final String CFG_PARAM_ACTIVE = "active";
    public static final String CFG_PARAM_AVG_TIME = "averageResponseTime";
    public static final String CFG_PARAM_LAST_TIME = "lastResponseTime";
    public static final String CFG_PARAM_REQ_COUNT = "requestCount";
    public static final String CFG_LOADBALANCING_RESULT = "synapse.loadBalancing.result";
    public static final String CFG_LOADBALANCING_XML = "loadbalancing.xml";
    public static final String CFG_XML_FOLDER = "META-INF";
    public static final String CFG_PARAMSET = "parameterSet";
    public static final String STRATEGY_PERF = "performance";
    public static final String STRATEGY_RR = "roundRobin";
}