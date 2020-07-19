package com.dneonline.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.List;

public class EnviarSuma implements Task {
    List<String> cuerpo;

    public EnviarSuma(List<String> cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T Ella) {
        Ella.attemptsTo(Post.to("").with(request ->request.body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <Add xmlns=\"http://tempuri.org/\">\n" +
                "      <intA>"+cuerpo.get(0)+"</intA>\n" +
                "      <intB>"+cuerpo.get(1)+"</intB>\n" +
                "    </Add>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>").header("Content-Type","text/xml; " +
                "charset=utf-8").header("Host","www.dneonline.com").
                header("SOAPAction","\"http://tempuri.org/Add\"")));

    }


    public static EnviarSuma conCuerpo(List<String> cuerpo) {
        return Tasks.instrumented(EnviarSuma.class, cuerpo);


    }
}