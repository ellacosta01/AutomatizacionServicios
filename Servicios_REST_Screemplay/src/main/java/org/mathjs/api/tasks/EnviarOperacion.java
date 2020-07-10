package org.mathjs.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

public class EnviarOperacion implements Task {

    private Map<String, String> cuerpo;

    public EnviarOperacion(Map<String, String> cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("").with(request -> request.body(cuerpo)));
    }

    public static EnviarOperacion conCuerpo(Map<String, String> cuerpo) {
        return Tasks.instrumented(EnviarOperacion.class, cuerpo);
    }

}
