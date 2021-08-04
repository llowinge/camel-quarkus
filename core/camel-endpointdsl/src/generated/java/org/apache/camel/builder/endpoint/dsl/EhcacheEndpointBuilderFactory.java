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
package org.apache.camel.builder.endpoint.dsl;

import java.util.Map;
import javax.annotation.Generated;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;
import org.apache.camel.spi.ExceptionHandler;

/**
 * Perform caching operations using Ehcache.
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface EhcacheEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the Ehcache component.
     */
    public interface EhcacheEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedEhcacheEndpointConsumerBuilder advanced() {
            return (AdvancedEhcacheEndpointConsumerBuilder) this;
        }
        /**
         * The cache manager.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheManager&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManager the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder cacheManager(Object cacheManager) {
            doSetProperty("cacheManager", cacheManager);
            return this;
        }
        /**
         * The cache manager.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheManager&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManager the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder cacheManager(String cacheManager) {
            doSetProperty("cacheManager", cacheManager);
            return this;
        }
        /**
         * The cache manager configuration.
         * 
         * The option is a:
         * &lt;code&gt;org.ehcache.config.Configuration&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManagerConfiguration the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder cacheManagerConfiguration(
                Object cacheManagerConfiguration) {
            doSetProperty("cacheManagerConfiguration", cacheManagerConfiguration);
            return this;
        }
        /**
         * The cache manager configuration.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.ehcache.config.Configuration&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManagerConfiguration the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder cacheManagerConfiguration(
                String cacheManagerConfiguration) {
            doSetProperty("cacheManagerConfiguration", cacheManagerConfiguration);
            return this;
        }
        /**
         * URI pointing to the Ehcache XML configuration file's location.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param configurationUri the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder configurationUri(
                String configurationUri) {
            doSetProperty("configurationUri", configurationUri);
            return this;
        }
        /**
         * Configure if a cache need to be created if it does exist or can't be
         * pre-configured.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: common
         * 
         * @param createCacheIfNotExist the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder createCacheIfNotExist(
                boolean createCacheIfNotExist) {
            doSetProperty("createCacheIfNotExist", createCacheIfNotExist);
            return this;
        }
        /**
         * Configure if a cache need to be created if it does exist or can't be
         * pre-configured.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: true
         * Group: common
         * 
         * @param createCacheIfNotExist the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder createCacheIfNotExist(
                String createCacheIfNotExist) {
            doSetProperty("createCacheIfNotExist", createCacheIfNotExist);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Set the delivery mode (synchronous, asynchronous).
         * 
         * The option is a:
         * &lt;code&gt;org.ehcache.event.EventFiring&lt;/code&gt; type.
         * 
         * Default: ASYNCHRONOUS
         * Group: consumer
         * 
         * @param eventFiring the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder eventFiring(
                EventFiring eventFiring) {
            doSetProperty("eventFiring", eventFiring);
            return this;
        }
        /**
         * Set the delivery mode (synchronous, asynchronous).
         * 
         * The option will be converted to a
         * &lt;code&gt;org.ehcache.event.EventFiring&lt;/code&gt; type.
         * 
         * Default: ASYNCHRONOUS
         * Group: consumer
         * 
         * @param eventFiring the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder eventFiring(String eventFiring) {
            doSetProperty("eventFiring", eventFiring);
            return this;
        }
        /**
         * Set the delivery mode (ordered, unordered).
         * 
         * The option is a:
         * &lt;code&gt;org.ehcache.event.EventOrdering&lt;/code&gt; type.
         * 
         * Default: ORDERED
         * Group: consumer
         * 
         * @param eventOrdering the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder eventOrdering(
                EventOrdering eventOrdering) {
            doSetProperty("eventOrdering", eventOrdering);
            return this;
        }
        /**
         * Set the delivery mode (ordered, unordered).
         * 
         * The option will be converted to a
         * &lt;code&gt;org.ehcache.event.EventOrdering&lt;/code&gt; type.
         * 
         * Default: ORDERED
         * Group: consumer
         * 
         * @param eventOrdering the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder eventOrdering(
                String eventOrdering) {
            doSetProperty("eventOrdering", eventOrdering);
            return this;
        }
        /**
         * Set the type of events to listen for
         * (EVICTED,EXPIRED,REMOVED,CREATED,UPDATED). You can specify multiple
         * entries separated by comma.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param eventTypes the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointConsumerBuilder eventTypes(String eventTypes) {
            doSetProperty("eventTypes", eventTypes);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the Ehcache component.
     */
    public interface AdvancedEhcacheEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default EhcacheEndpointConsumerBuilder basic() {
            return (EhcacheEndpointConsumerBuilder) this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder exceptionHandler(
                ExceptionHandler exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder exchangePattern(
                ExchangePattern exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * The default cache configuration to be used to create caches.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder configuration(
                Object configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * The default cache configuration to be used to create caches.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder configuration(
                String configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * A map of cache configuration to be used to create caches.
         * 
         * The option is a: &lt;code&gt;java.util.Map&amp;lt;java.lang.String,
         * org.ehcache.config.CacheConfiguration&amp;gt;&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configurations the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder configurations(
                Map<String, Object> configurations) {
            doSetProperty("configurations", configurations);
            return this;
        }
        /**
         * A map of cache configuration to be used to create caches.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.util.Map&amp;lt;java.lang.String,
         * org.ehcache.config.CacheConfiguration&amp;gt;&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configurations the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder configurations(
                String configurations) {
            doSetProperty("configurations", configurations);
            return this;
        }
        /**
         * The cache key type, default java.lang.Object.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param keyType the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder keyType(String keyType) {
            doSetProperty("keyType", keyType);
            return this;
        }
        /**
         * The cache value type, default java.lang.Object.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param valueType the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointConsumerBuilder valueType(
                String valueType) {
            doSetProperty("valueType", valueType);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the Ehcache component.
     */
    public interface EhcacheEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedEhcacheEndpointProducerBuilder advanced() {
            return (AdvancedEhcacheEndpointProducerBuilder) this;
        }
        /**
         * The cache manager.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheManager&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManager the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder cacheManager(Object cacheManager) {
            doSetProperty("cacheManager", cacheManager);
            return this;
        }
        /**
         * The cache manager.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheManager&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManager the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder cacheManager(String cacheManager) {
            doSetProperty("cacheManager", cacheManager);
            return this;
        }
        /**
         * The cache manager configuration.
         * 
         * The option is a:
         * &lt;code&gt;org.ehcache.config.Configuration&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManagerConfiguration the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder cacheManagerConfiguration(
                Object cacheManagerConfiguration) {
            doSetProperty("cacheManagerConfiguration", cacheManagerConfiguration);
            return this;
        }
        /**
         * The cache manager configuration.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.ehcache.config.Configuration&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManagerConfiguration the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder cacheManagerConfiguration(
                String cacheManagerConfiguration) {
            doSetProperty("cacheManagerConfiguration", cacheManagerConfiguration);
            return this;
        }
        /**
         * URI pointing to the Ehcache XML configuration file's location.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param configurationUri the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder configurationUri(
                String configurationUri) {
            doSetProperty("configurationUri", configurationUri);
            return this;
        }
        /**
         * Configure if a cache need to be created if it does exist or can't be
         * pre-configured.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: common
         * 
         * @param createCacheIfNotExist the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder createCacheIfNotExist(
                boolean createCacheIfNotExist) {
            doSetProperty("createCacheIfNotExist", createCacheIfNotExist);
            return this;
        }
        /**
         * Configure if a cache need to be created if it does exist or can't be
         * pre-configured.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: true
         * Group: common
         * 
         * @param createCacheIfNotExist the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder createCacheIfNotExist(
                String createCacheIfNotExist) {
            doSetProperty("createCacheIfNotExist", createCacheIfNotExist);
            return this;
        }
        /**
         * To configure the default cache action. If an action is set in the
         * message header, then the operation from the header takes precedence.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param action the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder action(String action) {
            doSetProperty("action", action);
            return this;
        }
        /**
         * To configure the default action key. If a key is set in the message
         * header, then the key from the header takes precedence.
         * 
         * The option is a: &lt;code&gt;java.lang.Object&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param key the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder key(Object key) {
            doSetProperty("key", key);
            return this;
        }
        /**
         * To configure the default action key. If a key is set in the message
         * header, then the key from the header takes precedence.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Object&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param key the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder key(String key) {
            doSetProperty("key", key);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the Ehcache component.
     */
    public interface AdvancedEhcacheEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default EhcacheEndpointProducerBuilder basic() {
            return (EhcacheEndpointProducerBuilder) this;
        }
        /**
         * The default cache configuration to be used to create caches.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointProducerBuilder configuration(
                Object configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * The default cache configuration to be used to create caches.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointProducerBuilder configuration(
                String configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * A map of cache configuration to be used to create caches.
         * 
         * The option is a: &lt;code&gt;java.util.Map&amp;lt;java.lang.String,
         * org.ehcache.config.CacheConfiguration&amp;gt;&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configurations the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointProducerBuilder configurations(
                Map<String, Object> configurations) {
            doSetProperty("configurations", configurations);
            return this;
        }
        /**
         * A map of cache configuration to be used to create caches.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.util.Map&amp;lt;java.lang.String,
         * org.ehcache.config.CacheConfiguration&amp;gt;&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configurations the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointProducerBuilder configurations(
                String configurations) {
            doSetProperty("configurations", configurations);
            return this;
        }
        /**
         * The cache key type, default java.lang.Object.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param keyType the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointProducerBuilder keyType(String keyType) {
            doSetProperty("keyType", keyType);
            return this;
        }
        /**
         * The cache value type, default java.lang.Object.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param valueType the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointProducerBuilder valueType(
                String valueType) {
            doSetProperty("valueType", valueType);
            return this;
        }
    }

    /**
     * Builder for endpoint for the Ehcache component.
     */
    public interface EhcacheEndpointBuilder
            extends
                EhcacheEndpointConsumerBuilder,
                EhcacheEndpointProducerBuilder {
        default AdvancedEhcacheEndpointBuilder advanced() {
            return (AdvancedEhcacheEndpointBuilder) this;
        }
        /**
         * The cache manager.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheManager&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManager the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder cacheManager(Object cacheManager) {
            doSetProperty("cacheManager", cacheManager);
            return this;
        }
        /**
         * The cache manager.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheManager&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManager the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder cacheManager(String cacheManager) {
            doSetProperty("cacheManager", cacheManager);
            return this;
        }
        /**
         * The cache manager configuration.
         * 
         * The option is a:
         * &lt;code&gt;org.ehcache.config.Configuration&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManagerConfiguration the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder cacheManagerConfiguration(
                Object cacheManagerConfiguration) {
            doSetProperty("cacheManagerConfiguration", cacheManagerConfiguration);
            return this;
        }
        /**
         * The cache manager configuration.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.ehcache.config.Configuration&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param cacheManagerConfiguration the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder cacheManagerConfiguration(
                String cacheManagerConfiguration) {
            doSetProperty("cacheManagerConfiguration", cacheManagerConfiguration);
            return this;
        }
        /**
         * URI pointing to the Ehcache XML configuration file's location.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param configurationUri the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder configurationUri(String configurationUri) {
            doSetProperty("configurationUri", configurationUri);
            return this;
        }
        /**
         * Configure if a cache need to be created if it does exist or can't be
         * pre-configured.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: common
         * 
         * @param createCacheIfNotExist the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder createCacheIfNotExist(
                boolean createCacheIfNotExist) {
            doSetProperty("createCacheIfNotExist", createCacheIfNotExist);
            return this;
        }
        /**
         * Configure if a cache need to be created if it does exist or can't be
         * pre-configured.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: true
         * Group: common
         * 
         * @param createCacheIfNotExist the value to set
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder createCacheIfNotExist(
                String createCacheIfNotExist) {
            doSetProperty("createCacheIfNotExist", createCacheIfNotExist);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Ehcache component.
     */
    public interface AdvancedEhcacheEndpointBuilder
            extends
                AdvancedEhcacheEndpointConsumerBuilder,
                AdvancedEhcacheEndpointProducerBuilder {
        default EhcacheEndpointBuilder basic() {
            return (EhcacheEndpointBuilder) this;
        }
        /**
         * The default cache configuration to be used to create caches.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointBuilder configuration(
                Object configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * The default cache configuration to be used to create caches.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.ehcache.EhcacheConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointBuilder configuration(
                String configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * A map of cache configuration to be used to create caches.
         * 
         * The option is a: &lt;code&gt;java.util.Map&amp;lt;java.lang.String,
         * org.ehcache.config.CacheConfiguration&amp;gt;&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configurations the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointBuilder configurations(
                Map<String, Object> configurations) {
            doSetProperty("configurations", configurations);
            return this;
        }
        /**
         * A map of cache configuration to be used to create caches.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.util.Map&amp;lt;java.lang.String,
         * org.ehcache.config.CacheConfiguration&amp;gt;&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param configurations the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointBuilder configurations(
                String configurations) {
            doSetProperty("configurations", configurations);
            return this;
        }
        /**
         * The cache key type, default java.lang.Object.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param keyType the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointBuilder keyType(String keyType) {
            doSetProperty("keyType", keyType);
            return this;
        }
        /**
         * The cache value type, default java.lang.Object.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param valueType the value to set
         * @return the dsl builder
         */
        default AdvancedEhcacheEndpointBuilder valueType(String valueType) {
            doSetProperty("valueType", valueType);
            return this;
        }
    }

    /**
     * Proxy enum for <code>org.ehcache.event.EventFiring</code> enum.
     */
    enum EventFiring {
        ASYNCHRONOUS,
        SYNCHRONOUS;
    }

    /**
     * Proxy enum for <code>org.ehcache.event.EventOrdering</code> enum.
     */
    enum EventOrdering {
        UNORDERED,
        ORDERED;
    }

    public interface EhcacheBuilders {
        /**
         * Ehcache (camel-ehcache)
         * Perform caching operations using Ehcache.
         * 
         * Category: cache,datagrid,clustering
         * Since: 2.18
         * Maven coordinates: org.apache.camel:camel-ehcache
         * 
         * Syntax: <code>ehcache:cacheName</code>
         * 
         * Path parameter: cacheName (required)
         * the cache name
         * 
         * @param path cacheName
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder ehcache(String path) {
            return EhcacheEndpointBuilderFactory.endpointBuilder("ehcache", path);
        }
        /**
         * Ehcache (camel-ehcache)
         * Perform caching operations using Ehcache.
         * 
         * Category: cache,datagrid,clustering
         * Since: 2.18
         * Maven coordinates: org.apache.camel:camel-ehcache
         * 
         * Syntax: <code>ehcache:cacheName</code>
         * 
         * Path parameter: cacheName (required)
         * the cache name
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path cacheName
         * @return the dsl builder
         */
        default EhcacheEndpointBuilder ehcache(String componentName, String path) {
            return EhcacheEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }
    static EhcacheEndpointBuilder endpointBuilder(
            String componentName,
            String path) {
        class EhcacheEndpointBuilderImpl extends AbstractEndpointBuilder implements EhcacheEndpointBuilder, AdvancedEhcacheEndpointBuilder {
            public EhcacheEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new EhcacheEndpointBuilderImpl(path);
    }
}