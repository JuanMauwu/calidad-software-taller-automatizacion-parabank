package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import co.edu.udea.certificacion.parabank.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.actions.Click;

public class OpenThe {

    private OpenThe() {
    }

    public static Performable browser() {
        return Task.where("{0} opens the ParaBank home page",
                Open.browserOn().thePageNamed("pages.parabankUrl"),
                Wait.seconds(2));
    }

    public static Performable registrationForm() {
        return Task.where("{0} opens the registration form",
                Open.browserOn().thePageNamed("pages.parabankUrl"),
                Wait.seconds(2),
                Click.on(RegisterPage.REGISTER_LINK),
                Wait.seconds(1));
    }

}