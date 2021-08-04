/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.mongodb;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.ExtendedPropertyConfigurerGetter;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.spi.ConfigurerStrategy;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class MongoDbEndpointConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        MongoDbEndpoint target = (MongoDbEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "collection": target.setCollection(property(camelContext, java.lang.String.class, value)); return true;
        case "collectionindex":
        case "collectionIndex": target.setCollectionIndex(property(camelContext, java.lang.String.class, value)); return true;
        case "consumertype":
        case "consumerType": target.setConsumerType(property(camelContext, java.lang.String.class, value)); return true;
        case "createcollection":
        case "createCollection": target.setCreateCollection(property(camelContext, boolean.class, value)); return true;
        case "cursorregenerationdelay":
        case "cursorRegenerationDelay": target.setCursorRegenerationDelay(property(camelContext, java.time.Duration.class, value).toMillis()); return true;
        case "database": target.setDatabase(property(camelContext, java.lang.String.class, value)); return true;
        case "dynamicity": target.setDynamicity(property(camelContext, boolean.class, value)); return true;
        case "exceptionhandler":
        case "exceptionHandler": target.setExceptionHandler(property(camelContext, org.apache.camel.spi.ExceptionHandler.class, value)); return true;
        case "exchangepattern":
        case "exchangePattern": target.setExchangePattern(property(camelContext, org.apache.camel.ExchangePattern.class, value)); return true;
        case "hosts": target.setHosts(property(camelContext, java.lang.String.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "mongoconnection":
        case "mongoConnection": target.setMongoConnection(property(camelContext, com.mongodb.client.MongoClient.class, value)); return true;
        case "operation": target.setOperation(property(camelContext, org.apache.camel.component.mongodb.MongoDbOperation.class, value)); return true;
        case "outputtype":
        case "outputType": target.setOutputType(property(camelContext, org.apache.camel.component.mongodb.MongoDbOutputType.class, value)); return true;
        case "password": target.setPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "persistentid":
        case "persistentId": target.setPersistentId(property(camelContext, java.lang.String.class, value)); return true;
        case "persistenttailtracking":
        case "persistentTailTracking": target.setPersistentTailTracking(property(camelContext, boolean.class, value)); return true;
        case "readpreference":
        case "readPreference": target.setReadPreference(property(camelContext, java.lang.String.class, value)); return true;
        case "streamfilter":
        case "streamFilter": target.setStreamFilter(property(camelContext, java.lang.String.class, value)); return true;
        case "tailtrackcollection":
        case "tailTrackCollection": target.setTailTrackCollection(property(camelContext, java.lang.String.class, value)); return true;
        case "tailtrackdb":
        case "tailTrackDb": target.setTailTrackDb(property(camelContext, java.lang.String.class, value)); return true;
        case "tailtrackfield":
        case "tailTrackField": target.setTailTrackField(property(camelContext, java.lang.String.class, value)); return true;
        case "tailtrackincreasingfield":
        case "tailTrackIncreasingField": target.setTailTrackIncreasingField(property(camelContext, java.lang.String.class, value)); return true;
        case "username": target.setUsername(property(camelContext, java.lang.String.class, value)); return true;
        case "writeconcern":
        case "writeConcern": target.setWriteConcern(property(camelContext, java.lang.String.class, value)); return true;
        case "writeresultasheader":
        case "writeResultAsHeader": target.setWriteResultAsHeader(property(camelContext, boolean.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return boolean.class;
        case "collection": return java.lang.String.class;
        case "collectionindex":
        case "collectionIndex": return java.lang.String.class;
        case "consumertype":
        case "consumerType": return java.lang.String.class;
        case "createcollection":
        case "createCollection": return boolean.class;
        case "cursorregenerationdelay":
        case "cursorRegenerationDelay": return long.class;
        case "database": return java.lang.String.class;
        case "dynamicity": return boolean.class;
        case "exceptionhandler":
        case "exceptionHandler": return org.apache.camel.spi.ExceptionHandler.class;
        case "exchangepattern":
        case "exchangePattern": return org.apache.camel.ExchangePattern.class;
        case "hosts": return java.lang.String.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "mongoconnection":
        case "mongoConnection": return com.mongodb.client.MongoClient.class;
        case "operation": return org.apache.camel.component.mongodb.MongoDbOperation.class;
        case "outputtype":
        case "outputType": return org.apache.camel.component.mongodb.MongoDbOutputType.class;
        case "password": return java.lang.String.class;
        case "persistentid":
        case "persistentId": return java.lang.String.class;
        case "persistenttailtracking":
        case "persistentTailTracking": return boolean.class;
        case "readpreference":
        case "readPreference": return java.lang.String.class;
        case "streamfilter":
        case "streamFilter": return java.lang.String.class;
        case "tailtrackcollection":
        case "tailTrackCollection": return java.lang.String.class;
        case "tailtrackdb":
        case "tailTrackDb": return java.lang.String.class;
        case "tailtrackfield":
        case "tailTrackField": return java.lang.String.class;
        case "tailtrackincreasingfield":
        case "tailTrackIncreasingField": return java.lang.String.class;
        case "username": return java.lang.String.class;
        case "writeconcern":
        case "writeConcern": return java.lang.String.class;
        case "writeresultasheader":
        case "writeResultAsHeader": return boolean.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        MongoDbEndpoint target = (MongoDbEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return target.isBridgeErrorHandler();
        case "collection": return target.getCollection();
        case "collectionindex":
        case "collectionIndex": return target.getCollectionIndex();
        case "consumertype":
        case "consumerType": return target.getConsumerType();
        case "createcollection":
        case "createCollection": return target.isCreateCollection();
        case "cursorregenerationdelay":
        case "cursorRegenerationDelay": return target.getCursorRegenerationDelay();
        case "database": return target.getDatabase();
        case "dynamicity": return target.isDynamicity();
        case "exceptionhandler":
        case "exceptionHandler": return target.getExceptionHandler();
        case "exchangepattern":
        case "exchangePattern": return target.getExchangePattern();
        case "hosts": return target.getHosts();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "mongoconnection":
        case "mongoConnection": return target.getMongoConnection();
        case "operation": return target.getOperation();
        case "outputtype":
        case "outputType": return target.getOutputType();
        case "password": return target.getPassword();
        case "persistentid":
        case "persistentId": return target.getPersistentId();
        case "persistenttailtracking":
        case "persistentTailTracking": return target.isPersistentTailTracking();
        case "readpreference":
        case "readPreference": return target.getReadPreference();
        case "streamfilter":
        case "streamFilter": return target.getStreamFilter();
        case "tailtrackcollection":
        case "tailTrackCollection": return target.getTailTrackCollection();
        case "tailtrackdb":
        case "tailTrackDb": return target.getTailTrackDb();
        case "tailtrackfield":
        case "tailTrackField": return target.getTailTrackField();
        case "tailtrackincreasingfield":
        case "tailTrackIncreasingField": return target.getTailTrackIncreasingField();
        case "username": return target.getUsername();
        case "writeconcern":
        case "writeConcern": return target.getWriteConcern();
        case "writeresultasheader":
        case "writeResultAsHeader": return target.isWriteResultAsHeader();
        default: return null;
        }
    }
}
