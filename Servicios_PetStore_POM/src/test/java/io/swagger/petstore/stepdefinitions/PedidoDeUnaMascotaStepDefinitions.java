package io.swagger.petstore.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class PedidoDeUnaMascotaStepDefinitions {


    @Cuando("^el usuario realiza el pedido de una mascota$")
    public void elUsuarioRealizaElPedidoDeUnaMascota(Map<String, String> cuerpo) {
        SerenityRest.given().header("accept", "application/json").
                header("Content-Type", "application/json").body(cuerpo).post("https://petstore.swagger.io/v2/store/order\n");
    }


    @Entonces("^valido que se haya pedido correctamente$")
    public void validoQueSeHayaPedidoCorrectamente(List<Integer> listaRespuesta) {
        SerenityRest.lastResponse().then().statusCode(Matchers.is(listaRespuesta.get(0)));
    }


}
