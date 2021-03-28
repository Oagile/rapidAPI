Feature: As a user I should ....

  Background:
         * url baseURI

  @covidData
  Scenario: Get Country by name
          * header Content-Type = 'application/x-www-form-urlencoded'
          * header X-RapidAPI-Key = key;
          * header x-rapidapi-host = host;
          * param name = 'Italy'
    Given path '/country'
      When method GET
      Then status 200

