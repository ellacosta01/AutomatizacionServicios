Feature: Crear usuario
  Background:
    * def urlPath = 'https://petstore.swagger.io/v2/user/login?username=ella123%40hotmail.com&password=12345_E'
    * def responseExpected = read('login_response.json')
    * def accept = 'application/json'

  Scenario: Crear usuario Exitoso
    Given url urlPath
    * header accept = accept
    * def requestSend = read('login_request.json')
    And request requestSend
    When method GET
    * def responsecrearUsuario = response
    Then status 200
    And match response contains responseExpected