package org.mathjs.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElResultado implements Question<String> {

    String llave;

    public ElResultado(String llave) {
        this.llave = llave;
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().jsonPath().getString(llave);
    }

    public static ElResultado deLaOperacion(String llave) {
        return new ElResultado(llave);
    }
}
