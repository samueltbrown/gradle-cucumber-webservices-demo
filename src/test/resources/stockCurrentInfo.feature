Feature: Get Stock Current Information
  In order to enable traders to make informed decisions
  Web service clients must be able to send a stock symbol and get back the correct current information

  Scenario: Request stock information
    Given a stock with "APPL" as the stock symbol
    When I call the stockCurrentInformation operation on the stock web service
    Then the returned stock symbol should be "APPL"
    And the returned current price should be a postive number
    And the returned percent change should be a a positive or negative number
