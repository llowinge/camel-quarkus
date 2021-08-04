/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.flink;

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
public class FlinkEndpointConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        FlinkEndpoint target = (FlinkEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "collect": target.setCollect(property(camelContext, boolean.class, value)); return true;
        case "dataset":
        case "dataSet": target.setDataSet(property(camelContext, org.apache.flink.api.java.DataSet.class, value)); return true;
        case "datasetcallback":
        case "dataSetCallback": target.setDataSetCallback(property(camelContext, org.apache.camel.component.flink.DataSetCallback.class, value)); return true;
        case "datastream":
        case "dataStream": target.setDataStream(property(camelContext, org.apache.flink.streaming.api.datastream.DataStream.class, value)); return true;
        case "datastreamcallback":
        case "dataStreamCallback": target.setDataStreamCallback(property(camelContext, org.apache.camel.component.flink.DataStreamCallback.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "collect": return boolean.class;
        case "dataset":
        case "dataSet": return org.apache.flink.api.java.DataSet.class;
        case "datasetcallback":
        case "dataSetCallback": return org.apache.camel.component.flink.DataSetCallback.class;
        case "datastream":
        case "dataStream": return org.apache.flink.streaming.api.datastream.DataStream.class;
        case "datastreamcallback":
        case "dataStreamCallback": return org.apache.camel.component.flink.DataStreamCallback.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        FlinkEndpoint target = (FlinkEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "collect": return target.isCollect();
        case "dataset":
        case "dataSet": return target.getDataSet();
        case "datasetcallback":
        case "dataSetCallback": return target.getDataSetCallback();
        case "datastream":
        case "dataStream": return target.getDataStream();
        case "datastreamcallback":
        case "dataStreamCallback": return target.getDataStreamCallback();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        default: return null;
        }
    }
}
