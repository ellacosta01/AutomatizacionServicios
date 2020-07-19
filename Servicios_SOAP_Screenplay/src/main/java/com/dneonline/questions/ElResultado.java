package com.dneonline.questions;

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
        return SerenityRest.lastResponse().body().xmlPath().getString(llave);



    }
    public static ElResultado deLaSuma(String llave) {
        return new ElResultado(llave);
    }
}
