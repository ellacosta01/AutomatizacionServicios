package io.swagger.petstore.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\buscar_la_orden_de_compra.feature",
        glue = "io.swagger.petstore.stepdefinitions", snippets = SnippetType.CAMELCASE)


public class BuscarLaOrdenDeCompraRunner {
}
