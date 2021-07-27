/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.xslt;

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
public class XsltComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        XsltComponent target = (XsltComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": target.setAutowiredEnabled(property(camelContext, boolean.class, value)); return true;
        case "contentcache":
        case "contentCache": target.setContentCache(property(camelContext, boolean.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "transformerfactoryclass":
        case "transformerFactoryClass": target.setTransformerFactoryClass(property(camelContext, java.lang.String.class, value)); return true;
        case "transformerfactoryconfigurationstrategy":
        case "transformerFactoryConfigurationStrategy": target.setTransformerFactoryConfigurationStrategy(property(camelContext, org.apache.camel.component.xslt.TransformerFactoryConfigurationStrategy.class, value)); return true;
        case "uriresolver":
        case "uriResolver": target.setUriResolver(property(camelContext, javax.xml.transform.URIResolver.class, value)); return true;
        case "uriresolverfactory":
        case "uriResolverFactory": target.setUriResolverFactory(property(camelContext, org.apache.camel.component.xslt.XsltUriResolverFactory.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return boolean.class;
        case "contentcache":
        case "contentCache": return boolean.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "transformerfactoryclass":
        case "transformerFactoryClass": return java.lang.String.class;
        case "transformerfactoryconfigurationstrategy":
        case "transformerFactoryConfigurationStrategy": return org.apache.camel.component.xslt.TransformerFactoryConfigurationStrategy.class;
        case "uriresolver":
        case "uriResolver": return javax.xml.transform.URIResolver.class;
        case "uriresolverfactory":
        case "uriResolverFactory": return org.apache.camel.component.xslt.XsltUriResolverFactory.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        XsltComponent target = (XsltComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return target.isAutowiredEnabled();
        case "contentcache":
        case "contentCache": return target.isContentCache();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "transformerfactoryclass":
        case "transformerFactoryClass": return target.getTransformerFactoryClass();
        case "transformerfactoryconfigurationstrategy":
        case "transformerFactoryConfigurationStrategy": return target.getTransformerFactoryConfigurationStrategy();
        case "uriresolver":
        case "uriResolver": return target.getUriResolver();
        case "uriresolverfactory":
        case "uriResolverFactory": return target.getUriResolverFactory();
        default: return null;
        }
    }
}
