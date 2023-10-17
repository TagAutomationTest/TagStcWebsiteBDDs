Feature: Stc subscriptipn packages validaions

  Background:As an un-registered user on StcTv website ,I should be able to browse site without login
    Given Initializing environment and open website on "Chrome"browser
    And StcTv website is loaded correctly

@Validation
  @subscriptionCountries
  Scenario:As an un-registered user on StcTv website i should be able to browse all countries that have subscription plans
    Given validate that StcTv will show 3 countries names in countries section
    Then the chrome driver is closed

  @Validation
  @subscriptionTypes
  Scenario:As an un-registered user on StcTv website i should be able to browse subscription packages plan types for all countries
    Given validate that StcTv will show 3 packages types for for all countries
    Then the chrome driver is closed

  @Validation
  @subscriptionTypes3333
  Scenario: Ass an un-registered user on StcTv website i should be able to know the subscription packages plan prices and currencies per my country
    Given validate the subscription packages plan prices and currency per country "KSA"
    And  validate the subscription packages plan prices and currency per country "Bahrain"
    And  validate the subscription packages plan prices and currency per country "Kuwait"
    Then the chrome driver is closed

