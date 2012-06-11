import wslite.soap.*

this.metaClass.mixin(cucumber.runtime.groovy.Hooks)
this.metaClass.mixin(cucumber.runtime.groovy.EN)

/**
 * @author Sam Brown
 * @since 6/11/12
 * @version 1.0
 */

Before(){
    def host = System.getenv("TEST_HOST") ?: "localhost"
    def port = System.getenv("TEST_PORT") ?: "8080"
    client = new SOAPClient("http://$host:$port/stock-webservice/StockServiceWS")
}

Given(~'^a stock with "([^"]*)" as the stock symbol$') { String arg1 ->
    symbol = arg1
}

When(~'^I call the stockCurrentInformation operation on the stock web service$') { ->
    response = client.send(SOAPAction:"http://www.excella.com/stock/stockCurrentInfoRequest") {
        body {
            stockCurrentInfoRequest('xmlns':'http://www.excella.com/stock') {
                requestedSymbol(symbol)
            }
        }
    }
}

Then(~'^the returned stock symbol should be "([^"]*)"$') { String arg1 ->
    assert response.stockCurrentInfoResponse.stockSymbol == arg1
}

Then(~'^the returned current price should be a postive number$') { ->
    assert (response.stockCurrentInfoResponse.stockPrice.text() as Double) >= 0d
}

Then(~'^the returned percent change should be a a positive or negative number$') { ->
    assert ((response.stockCurrentInfoResponse.stockPercentChange.text() as Double) >= 0d ||
            (response.stockCurrentInfoResponse.stockPercentChange.text() as Double) <= 0d)
}





