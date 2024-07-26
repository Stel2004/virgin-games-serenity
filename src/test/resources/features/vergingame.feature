Feature: Testing different request on the virgin games application

  @regression
  Scenario: Verify the jackpots bingo as per the selected currency
    When User sends a GET request to jackpots bingo endpoint
    Then Verify the status code of request

  @regression
  Scenario Outline: Verify the jackpots bingo as per the selected currency: <currency>
    When User sends a GET request to jackpots bingo endpoint
    Then User must get back a valid status code 200 as per the currency: "<currency>"
    Examples:
      | currency |
      | GBP    |
      | EUR    |
      | SEK    |