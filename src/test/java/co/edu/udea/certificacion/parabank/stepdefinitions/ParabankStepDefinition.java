package co.edu.udea.certificacion.parabank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.edu.udea.certificacion.parabank.tasks.OpenThe;
import co.edu.udea.certificacion.parabank.tasks.RegisterAs;

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
        OnStage.theActorCalled(actorName);
        throw new PendingException();
    }

    @Given("^(.*) is registered and logged in to ParaBank$")
    public void isRegisteredAndLoggedIn(String actorName) {
        OnStage.theActorCalled(actorName);
        throw new PendingException();
    }

    @When("^(?:she|he) registers with valid personal data$")
    public void registersWithValidData() {
        OnStage.theActorInTheSpotlight().attemptsTo(RegisterAs.newCustomer());
    }

    @When("^(?:she|he) opens a new savings account$")
    public void opensANewSavingsAccount() {
        throw new PendingException();
    }

    @When("^(?:she|he) transfers (\\d+) dollars between (?:her|his) accounts$")
    public void transfersDollars(int amount) {
        throw new PendingException();
    }

    @When("^(?:she|he) updates (?:her|his) contact information$")
    public void updatesContactInformation() {
        throw new PendingException();
    }

    @When("^(?:she|he) logs in with an unknown user$")
    public void logsInWithUnknownUser() {
        throw new PendingException();
    }

    @When("^(?:she|he) registers leaving \"(.*)\" empty$")
    public void registersLeavingFieldEmpty(String field) {
        throw new PendingException();
    }

    @Then("^(?:she|he) should see the message \"(.*)\"$")
    public void shouldSeeTheMessage(String message) {
        throw new PendingException();
    }

    @Then("^(?:she|he) should see the error \"(.*)\"$")
    public void shouldSeeTheError(String error) {
        throw new PendingException();
    }
}