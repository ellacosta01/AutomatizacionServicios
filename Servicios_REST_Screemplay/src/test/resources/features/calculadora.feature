#language: es
Característica: Calculadora Rest

  Escenario: Envio operacion exitosa
    Cuando envio la siguiente operacion a la calculadora
      | expr      | 2*3 |
      | precision | 14  |
    Entonces deberia ver el siguiente resultado
      | result |
      | 6      |