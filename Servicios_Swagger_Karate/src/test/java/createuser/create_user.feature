Feature: Crear usuario
  Background:
* def urlPath = 'https://petstore.swagger.io/v2/user'
* def responseExpected = read('create_user_response.json')
    * def accept = 'application/json'

  Scenario: Crear usuario Exitoso
    Given url urlPath
    * header accept = accept
    * def requestSend = read('create_user_response.json')
    And request requestSend
    When method POST
    * def responsecrearUsuario = response
    Then status 200
    And match response contains responseExpected
