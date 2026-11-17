package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.parabank.userinterfaces.LoginPage.*;

public class LogIn implements Task {

    private final String username;
    private final String password;

    private LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LogIn as(String username, String password) {
        return new LogIn(username, password);
    }

    @Override
    @Step("{0} logs in to ParaBank")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME),
                Enter.theValue(password).into(PASSWORD),
                Wait.seconds(1),
                Click.on(LOGIN_BUTTON),
                Wait.seconds(2));
    }
}