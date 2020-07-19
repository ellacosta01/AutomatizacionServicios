#language: es
Característica: Suma Soap

  Escenario: Envio operacion exitosa
    Cuando envio la siguiente suma a la calculadora
      | 8 | 4 |
    Entonces deberia ver el siguiente resultado
      | 12 |