package co.edu.udea.certificacion.parabank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.edu.udea.certificacion.parabank.tasks.OpenThe;
import co.edu.udea.certificacion.parabank.tasks.RegisterAs;
import co.edu.udea.certificacion.parabank.questions.ValidationThe;
import co.edu.udea.certificacion.parabank.tasks.RegisterLeaving;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import co.edu.udea.certificacion.parabank.tasks.LogIn;
import co.edu.udea.certificacion.parabank.tasks.OpenNewAccount;
import co.edu.udea.certificacion.parabank.tasks.TransferFunds;
import co.edu.udea.certificacion.parabank.tasks.UpdateContactInfo;
import co.edu.udea.certificacion.parabank.models.AccountType;

public class ParabankStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the ParaBank home page$")
    public void isOnTheParabankHomePage(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(OpenThe.browser());
    }

    @Given("^(.*) is on the ParaBank registration page$")
    public void isOnTheRegistrationPage(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(OpenThe.registrationForm());
    }

    @Given("^(.*) is registered and logged in to ParaBank$")
    public void isRegisteredAndLoggedIn(String actorName) {
        // ParaBank logs the customer in automatically after a successful registration
        OnStage.theActorCalled(actorName).attemptsTo(
                OpenThe.browser(),
                RegisterAs.newCustomer());
    }

    @When("^(?:she|he) registers with valid personal data$")
    public void registersWithValidData() {
        OnStage.theActorInTheSpotlight().attemptsTo(RegisterAs.newCustomer());
    }

    @When("^(?:she|he) opens a new savings account$")
    public void opensANewSavingsAccount() {
        OnStage.theActorInTheSpotlight().attemptsTo(OpenNewAccount.ofType(AccountType.SAVINGS));
    }

    @When("^(?:she|he) transfers (\\d+) dollars between (?:her|his) accounts$")
    public void transfersDollars(int amount) {
        OnStage.theActorInTheSpotlight().attemptsTo(TransferFunds.ofDollars(amount));
    }

    @When("^(?:she|he) updates (?:her|his) contact information$")
    public void updatesContactInformation() {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateContactInfo.withNewData());
    }

    @When("^(?:she|he) logs in with an unknown user$")
    public void logsInWithUnknownUser() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(LogIn.as("unknown" + System.currentTimeMillis(), "wrongPass123"));
    }
    @When("^(?:she|he) registers leaving \"(.*)\" empty$")
    public void registersLeavingFieldEmpty(String field) {
        OnStage.theActorInTheSpotlight().attemptsTo(RegisterLeaving.empty(field));
    }

    @Then("^(?:she|he) should see the message \"(.*)\"$")
    public void shouldSeeTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the page messages", ValidationThe.pageMessages(), hasItem(message)));
    }

    @Then("^(?:she|he) should see the error \"(.*)\"$")
    public void shouldSeeTheError(String error) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the error messages", ValidationThe.errorMessages(), hasItem(error)));
    }
}