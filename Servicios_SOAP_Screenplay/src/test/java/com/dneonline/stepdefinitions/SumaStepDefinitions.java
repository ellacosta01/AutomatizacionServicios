package com.dneonline.stepdefinitions;


import com.dneonline.questions.ElResultado;
import com.dneonline.tasks.EnviarSuma;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SumaStepDefinitions {
    private static final String Ella = "Ella";

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(Ella).whoCan(CallAnApi.at("http://www.dneonline.com/calculator.asmx?op=Add"));
    }

    @Cuando("^envio la siguiente suma a la calculadora$")
    public void envioLaSiguienteSumaALaCalculadora(List <String> listaNumero) throws Exception {
theActorInTheSpotlight().attemptsTo(EnviarSuma.conCuerpo(listaNumero));
    }


    @Entonces("^deberia ver el siguiente resultado$")
    public void deberiaVerElSiguienteResultado(List <String> listaResultado) throws Exception {
theActorInTheSpotlight().should(seeThat(ElResultado.deLaSuma("AddResult"), Matchers.equalTo(listaResultado.get(0))));
    }
}
