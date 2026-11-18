package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.parabank.userinterfaces.AccountServicesMenu.TRANSFER_FUNDS;
import static co.edu.udea.certificacion.parabank.userinterfaces.TransferFundsPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class TransferFunds implements Task {

    private final int amount;

    private TransferFunds(int amount) {
        this.amount = amount;
    }

    /** Transfers from the first account to the account opened in this scenario (or the second one). */
    public static TransferFunds ofDollars(int amount) {
        return new TransferFunds(amount);
    }

    @Override
    @Step("{0} transfers #amount dollars between own accounts")
    public <T extends Actor> void performAs(T actor) {
        String newAccountId = actor.recall(OpenNewAccount.NEW_ACCOUNT_KEY);

        actor.attemptsTo(
                Click.on(TRANSFER_FUNDS),
                // Both account lists are loaded by AJAX
                WaitUntil.the(SECOND_TO_ACCOUNT_OPTION, isPresent()).forNoMoreThan(10).seconds(),
                Wait.seconds(1),
                Enter.theValue(String.valueOf(amount)).into(AMOUNT),
                SelectFromOptions.byIndex(0).from(FROM_ACCOUNT),
                selectDestination(newAccountId),
                Wait.seconds(1),
                Click.on(TRANSFER_BUTTON),
                Wait.seconds(3));
    }

    private Performable selectDestination(String newAccountId) {
        if (newAccountId == null || newAccountId.isEmpty()) {
            return SelectFromOptions.byIndex(1).from(TO_ACCOUNT);
        }
        return Task.where("{0} chooses the new account as destination",
                WaitUntil.the(toAccountOption(newAccountId), isPresent()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byValue(newAccountId).from(TO_ACCOUNT));
    }
}
