package org.mathjs.api.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.hamcrest.Matchers;
import org.mathjs.api.questions.ElResultado;
import org.mathjs.api.tasks.EnviarOperacion;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CalculadoraStepDefinitions {


    private static final String Ella = "Ella";

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(Ella).whoCan(CallAnApi.at("http://api.mathjs.org/v4/"));
    }

    @Cuando("^envio la siguiente operacion a la calculadora$")
    public void envioLaSiguienteOperacionALaCalculadora(Map<String, String> cuerpo) throws Exception {
        theActorInTheSpotlight().attemptsTo(EnviarOperacion.conCuerpo(cuerpo));
    }


    @Entonces("^deberia ver el siguiente resultado$")
    public void deberiaVerElSiguienteResultado(List<String> listaRespuesta) throws Exception {
        theActorInTheSpotlight().should(seeThat(ElResultado.deLaOperacion(listaRespuesta.get(0)), Matchers.equalTo(listaRespuesta.get(1))));
    }

}
