package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import co.edu.udea.certificacion.parabank.models.ContactInfo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.parabank.userinterfaces.AccountServicesMenu.UPDATE_CONTACT_INFO;
import static co.edu.udea.certificacion.parabank.userinterfaces.UpdateProfilePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UpdateContactInfo implements Task {

    private final ContactInfo info;

    private UpdateContactInfo(ContactInfo info) {
        this.info = info;
    }

    public static UpdateContactInfo withNewData() {
        return new UpdateContactInfo(ContactInfo.updated());
    }

    @Override
    @Step("{0} updates the contact information")
    public <T extends Actor> void performAs(T actor) {
        actor.remember("contactInfo", info);
        actor.attemptsTo(
                Click.on(UPDATE_CONTACT_INFO),
                WaitUntil.the(STREET, isVisible()).forNoMoreThan(10).seconds(),
                // The current customer data is loaded by AJAX; wait so it doesn't overwrite our values
                Wait.seconds(2),
                Enter.theValue(info.street()).into(STREET),
                Enter.theValue(info.city()).into(CITY),
                Enter.theValue(info.state()).into(STATE),
                Enter.theValue(info.zipCode()).into(ZIP_CODE),
                Enter.theValue(info.phone()).into(PHONE),
                Wait.seconds(1),
                Click.on(UPDATE_PROFILE_BUTTON),
                Wait.seconds(3));
    }
}
