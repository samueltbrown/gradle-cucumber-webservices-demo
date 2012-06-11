package com.excella.javacoe.demo.ws.endpoint;

import com.excella.javacoe.demo.jaxb.StockCurrentInfoRequest;
import com.excella.javacoe.demo.jaxb.StockCurrentInfoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * @author Sam Brown
 * @version 1.0
 * @since 6/10/12
 */
@Endpoint
public class StockEndpoint {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StockEndpoint.class);

    protected static final String NAMESPACE_URI = "http://www.excella.com/stock";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "stockCurrentInfoRequest")
    public StockCurrentInfoResponse gotStockQuote(StockCurrentInfoRequest request)
    {
        log.info("STOCK SYMBOL REQUESTED: " + request.getRequestedSymbol());
        StockCurrentInfoResponse response = new StockCurrentInfoResponse();
        response.setStockSymbol(request.getRequestedSymbol());
        response.setStockPrice(10.00d);
        response.setStockPercentChange(-10.0d);

        return response;

    }
}
