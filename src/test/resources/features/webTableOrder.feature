Feature: Web table user arder feature

  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in an order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zip "50505"
    And user enters credit card type "MasterCard"
    And user enters credit card number "1111222233334444"
    And user enters expire date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the table


  @wip
  Scenario Outline: User should be able to place orders and orders seen in web table
    Given user is already logged in an order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user enters credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expire date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the table


    @femaleScientist
    Examples: Famous female scientist

      | productType | quantity | customerName       | street     | city   | state   | zip   | cardType | cardNumber      | expDate | expectedName       |
      | MoneyCog    | 2        | Marie Curie        | London st. | London | England | 50505 | Visa     | 111122233344455 | 12/24   | Marie Curie        |
      | Familybea   | 3        | Rosalind Franklin  | London st. | London | England | 50505 | Visa     | 111122233344455 | 12/24   | Rosalind Franklin  |
      | Screenable  | 4        | List Meitner       | London st. | London | England | 50505 | Visa     | 111122233344455 | 12/24   | List Meitner       |
      | MoneyCog    | 5        | Chien-Shiung Wu    | London st. | London | England | 50505 | Visa     | 111122233344455 | 12/24   | Chien-Shiung Wu    |
      | MoneyCog    | 6        | Barbara McClintock | London st. | London | England | 50505 | Visa     | 111122233344455 | 12/24   | Barbara McClintock |

    @maleScientist
    Examples: Famous male scientists
      | productType | quantity | customerName          | street    | city   | state   | zip   | cardType | cardNumber       | expDate | expectedName          |
      | MoneyCog    | 2        | Charles Darwin        | London st | London | England | 50505 | Visa     | 1111222233334444 | 12/24   | Charles Darwin        |
      | Familybea   | 3        | Albert Einstein       | London st | London | England | 50505 | Visa     | 1111222233334444 | 12/24   | Albert Einstein       |
      | Screenable  | 4        | CV Raman              | London st | London | England | 50505 | Visa     | 1111222233334444 | 12/24   | CV Raman              |
      | MoneyCog    | 5        | Galileo               | London st | London | England | 50505 | Visa     | 1111222233334444 | 12/24   | Galileo               |
      | MoneyCog    | 6        | Isaac Newton          | London st | London | England | 50505 | Visa     | 1111222233334444 | 12/24   | Isaac Newton          |
      | MoneyCog    | 6        | Arnold Schwarzenegger | London st | London | England | 50505 | Visa     | 1111222233334444 | 12/24   | Arnold Schwarzenegger |