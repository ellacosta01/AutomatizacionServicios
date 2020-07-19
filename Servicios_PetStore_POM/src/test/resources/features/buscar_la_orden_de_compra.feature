#language:es
Característica: Buscar pedido por id

  Escenario: Buscar pedido exitoso
    Cuando el usuario realiza una busqueda del pedido por id
      | id |
      | 4  |
    Entonces valido que que la busqueda del pedido este correctamente
      | status |
      | 200    |
    Entonces valido el contenido de la respuesta
      | id       | 4                            |
      | petId    | 2                            |
      | quantity | 2                            |
      | shipDate | 2020-07-19T00:00:26.139+0000 |
      | status   | delivered                    |
      | complete | false                        |