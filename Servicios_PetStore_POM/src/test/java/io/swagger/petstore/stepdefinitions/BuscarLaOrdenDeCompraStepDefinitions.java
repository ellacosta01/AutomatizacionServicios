package io.swagger.petstore.stepdefinitions;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class BuscarLaOrdenDeCompraStepDefinitions {

    @Cuando("^el usuario realiza una busqueda del pedido por id$")
    public void elUsuarioRealizaUnaBusquedaDelPedidoPorId(List<String> listaPeticion) {
        SerenityRest.given().header("accept", "application/json").
                get("https://petstore.swagger.io/v2/store/order/" + listaPeticion.get(1));
        System.out.println("https://petstore.swagger.io/v2/store/order/" + listaPeticion.get(1));
    }

    @Entonces("^valido que que la busqueda del pedido este correctamente$")
    public void validoQueQueLaBusquedaDelPedidoEsteCorrectamente(List<String> listaPeticion) {
        SerenityRest.lastResponse().then().statusCode(Matchers.is(Integer.parseInt(listaPeticion.get(1))));
    }

    @Entonces("^valido el contenido de la respuesta$")
    public void validoElContenidoDeLaRespuesta(Map<String, String> cuerpo) {
        Assert.assertThat(cuerpo.get("id"), Matchers.is(SerenityRest.lastResponse().body().jsonPath().getString("id")));
        Assert.assertThat(cuerpo.get("petId"), Matchers.is(SerenityRest.lastResponse().body().jsonPath().getString("petId")));
        Assert.assertThat(cuerpo.get("status"), Matchers.is(SerenityRest.lastResponse().body().jsonPath().getString("status")));
        Assert.assertThat(cuerpo.get("quantity"), Matchers.is(SerenityRest.lastResponse().body().jsonPath().getString("quantity")));
        Assert.assertThat(cuerpo.get("shipDate"), Matchers.is(SerenityRest.lastResponse().body().jsonPath().getString("shipDate")));
        Assert.assertThat(cuerpo.get("complete"), Matchers.is(SerenityRest.lastResponse().body().jsonPath().getString("complete")));


    }
}
