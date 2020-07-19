#language:es
Característica: Agregar una mascota a la tienda

  Antecedentes:
    Cuando el usuario agrega una mascota
      | poodle | Luki | 4 | Luki/poodle | available |

  Escenario: pedido de una mascota exitoso
    Cuando el usuario realiza el pedido de una mascota
      | id       | 4          |
      | petId    | 12         |
      | quantity | 1          |
      | shipDate | 2020-07-15 |
      | status   | placed     |
      | complete | true       |
    Entonces valido que se haya pedido correctamente
      | 200 |