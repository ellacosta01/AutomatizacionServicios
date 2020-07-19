#language:es
Característica: Agregar una mascota a la tienda

  Escenario: Agregar mascota exitoso
    Cuando el usuario agrega una mascota
      | poodle | Luki | 4 | Luki/poodle | available |
    Entonces valida que se haya agregado correctamente
      | 200 |