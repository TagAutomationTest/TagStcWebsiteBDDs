Feature: Stctest subscriptipn packages validaions

  Background:s an un-registered user on StcTv website ,I should be able to browse site without login
    Given Initializing environment1 and open website on "Chrome"browser
    And StcTv website is loaded correctly


  @test
  Scenario:As an un-registered user on StcTv website i should be able to browse all countries that have subscription plans
    Given validate that StcTv will show 3 countries names in countries section
    Then the chrome driver is closed