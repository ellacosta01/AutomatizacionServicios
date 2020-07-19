package io.swagger.petstore.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import java.util.List;

public class AgregarMascotaStepDefinitions {

    @Cuando("^el usuario agrega una mascota$")
    public void elUsuarioAgregaUnaMascota(List<String> listaPeticion) {
        SerenityRest.given().header("accept", "application/json").
                header("Content-Type", "application/json").body("{\n" +
                "  \"id\": 3,\n" +
                "  \"category\": {\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"" + listaPeticion.get(0) + "\"\n" +
                "  },\n" +
                "  \"name\": \"" + listaPeticion.get(1) + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + listaPeticion.get(2) + ",\n" +
                "      \"name\": \"" + listaPeticion.get(3) + "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + listaPeticion.get(4) + "\"\n" +
                "}").post("https://petstore.swagger.io/v2/pet");
    }


    @Entonces("^valida que se haya agregado correctamente$")
    public void validaQueSeHayaAgregadoCorrectamente(List<Integer> listaResultado) {
        SerenityRest.lastResponse().then().statusCode(Matchers.is(listaResultado.get(0)));
    }
}
