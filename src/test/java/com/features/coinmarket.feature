Feature: CoinMarket cap application functionality
@SmokeTest
Scenario Outline: CoinMarket cap application login with valid username and valid password
When user launch the Coin cap application
When user enters the valid "<username>" and valid "<password>"
When user clicks on login button
When user selecting the coins values
Then user collects the coins before and after the filters and comparing the results using assert

Examples:
|username|password|
|samik351993@gmail.com|sami.123|

