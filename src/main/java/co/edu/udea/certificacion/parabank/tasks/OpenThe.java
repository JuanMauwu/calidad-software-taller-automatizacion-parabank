package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenThe {

    private OpenThe() {
    }

    public static Performable browser() {
        return Task.where("{0} opens the ParaBank home page",
                Open.browserOn().thePageNamed("pages.parabankUrl"),
                Wait.seconds(2));
    }
}