/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.xmpp;

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
public class XmppEndpointConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        XmppEndpoint target = (XmppEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "connectionconfig":
        case "connectionConfig": target.setConnectionConfig(property(camelContext, org.jivesoftware.smack.ConnectionConfiguration.class, value)); return true;
        case "connectionpolldelay":
        case "connectionPollDelay": target.setConnectionPollDelay(property(camelContext, int.class, value)); return true;
        case "createaccount":
        case "createAccount": target.setCreateAccount(property(camelContext, boolean.class, value)); return true;
        case "doc": target.setDoc(property(camelContext, boolean.class, value)); return true;
        case "exceptionhandler":
        case "exceptionHandler": target.setExceptionHandler(property(camelContext, org.apache.camel.spi.ExceptionHandler.class, value)); return true;
        case "exchangepattern":
        case "exchangePattern": target.setExchangePattern(property(camelContext, org.apache.camel.ExchangePattern.class, value)); return true;
        case "headerfilterstrategy":
        case "headerFilterStrategy": target.setHeaderFilterStrategy(property(camelContext, org.apache.camel.spi.HeaderFilterStrategy.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "login": target.setLogin(property(camelContext, boolean.class, value)); return true;
        case "nickname": target.setNickname(property(camelContext, java.lang.String.class, value)); return true;
        case "password": target.setPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "pubsub": target.setPubsub(property(camelContext, boolean.class, value)); return true;
        case "resource": target.setResource(property(camelContext, java.lang.String.class, value)); return true;
        case "room": target.setRoom(property(camelContext, java.lang.String.class, value)); return true;
        case "roompassword":
        case "roomPassword": target.setRoomPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "servicename":
        case "serviceName": target.setServiceName(property(camelContext, java.lang.String.class, value)); return true;
        case "testconnectiononstartup":
        case "testConnectionOnStartup": target.setTestConnectionOnStartup(property(camelContext, boolean.class, value)); return true;
        case "user": target.setUser(property(camelContext, java.lang.String.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return boolean.class;
        case "connectionconfig":
        case "connectionConfig": return org.jivesoftware.smack.ConnectionConfiguration.class;
        case "connectionpolldelay":
        case "connectionPollDelay": return int.class;
        case "createaccount":
        case "createAccount": return boolean.class;
        case "doc": return boolean.class;
        case "exceptionhandler":
        case "exceptionHandler": return org.apache.camel.spi.ExceptionHandler.class;
        case "exchangepattern":
        case "exchangePattern": return org.apache.camel.ExchangePattern.class;
        case "headerfilterstrategy":
        case "headerFilterStrategy": return org.apache.camel.spi.HeaderFilterStrategy.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "login": return boolean.class;
        case "nickname": return java.lang.String.class;
        case "password": return java.lang.String.class;
        case "pubsub": return boolean.class;
        case "resource": return java.lang.String.class;
        case "room": return java.lang.String.class;
        case "roompassword":
        case "roomPassword": return java.lang.String.class;
        case "servicename":
        case "serviceName": return java.lang.String.class;
        case "testconnectiononstartup":
        case "testConnectionOnStartup": return boolean.class;
        case "user": return java.lang.String.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        XmppEndpoint target = (XmppEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return target.isBridgeErrorHandler();
        case "connectionconfig":
        case "connectionConfig": return target.getConnectionConfig();
        case "connectionpolldelay":
        case "connectionPollDelay": return target.getConnectionPollDelay();
        case "createaccount":
        case "createAccount": return target.isCreateAccount();
        case "doc": return target.isDoc();
        case "exceptionhandler":
        case "exceptionHandler": return target.getExceptionHandler();
        case "exchangepattern":
        case "exchangePattern": return target.getExchangePattern();
        case "headerfilterstrategy":
        case "headerFilterStrategy": return target.getHeaderFilterStrategy();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "login": return target.isLogin();
        case "nickname": return target.getNickname();
        case "password": return target.getPassword();
        case "pubsub": return target.isPubsub();
        case "resource": return target.getResource();
        case "room": return target.getRoom();
        case "roompassword":
        case "roomPassword": return target.getRoomPassword();
        case "servicename":
        case "serviceName": return target.getServiceName();
        case "testconnectiononstartup":
        case "testConnectionOnStartup": return target.isTestConnectionOnStartup();
        case "user": return target.getUser();
        default: return null;
        }
    }
}
