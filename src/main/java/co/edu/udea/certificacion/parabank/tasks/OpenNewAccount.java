package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import co.edu.udea.certificacion.parabank.models.AccountType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.parabank.userinterfaces.AccountServicesMenu.OPEN_NEW_ACCOUNT;
import static co.edu.udea.certificacion.parabank.userinterfaces.OpenAccountPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenNewAccount implements Task {

    public static final String NEW_ACCOUNT_KEY = "newAccountId";

    private final AccountType type;

    private OpenNewAccount(AccountType type) {
        this.type = type;
    }

    public static OpenNewAccount ofType(AccountType type) {
        return new OpenNewAccount(type);
    }

    @Override
    @Step("{0} opens a new #type account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPEN_NEW_ACCOUNT),
                // The list of existing accounts is loaded by AJAX
                WaitUntil.the(FROM_ACCOUNT_OPTIONS, isPresent()).forNoMoreThan(10).seconds(),
                Wait.seconds(1),
                SelectFromOptions.byVisibleText(type.name()).from(ACCOUNT_TYPE),
                SelectFromOptions.byIndex(0).from(FROM_ACCOUNT),
                Wait.seconds(1),
                Click.on(OPEN_ACCOUNT_BUTTON),
                WaitUntil.the(NEW_ACCOUNT_ID, isVisible()).forNoMoreThan(10).seconds(),
                Wait.seconds(2));

        actor.remember(NEW_ACCOUNT_KEY, NEW_ACCOUNT_ID.resolveFor(actor).getText().trim());
    }
}
