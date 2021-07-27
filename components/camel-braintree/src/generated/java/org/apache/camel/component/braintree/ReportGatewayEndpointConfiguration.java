
/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.braintree;

import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link com.braintreegateway.ReportGateway}.
 */
@ApiParams(apiName = "report", 
           description = "Provides methods to interact with reports",
           apiMethods = {@ApiMethod(methodName = "transactionLevelFees", description="Retrieves a Transaction-Level Fee Report", signatures={"com.braintreegateway.Result<com.braintreegateway.TransactionLevelFeeReport> transactionLevelFees(com.braintreegateway.TransactionLevelFeeReportRequest request)"})}, aliases = {})
@UriParams
@Configurer(extended = true)
public final class ReportGatewayEndpointConfiguration extends BraintreeConfiguration {
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "transactionLevelFees", description="The request")})
    private com.braintreegateway.TransactionLevelFeeReportRequest request;

    public com.braintreegateway.TransactionLevelFeeReportRequest getRequest() {
        return request;
    }

    public void setRequest(com.braintreegateway.TransactionLevelFeeReportRequest request) {
        this.request = request;
    }
}