package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import co.edu.udea.certificacion.parabank.models.Customer;
import co.edu.udea.certificacion.parabank.models.RegistrationField;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

import static co.edu.udea.certificacion.parabank.userinterfaces.RegisterPage.*;

public class RegisterLeaving implements Task {

    private final RegistrationField emptyField;

    private RegisterLeaving(RegistrationField emptyField) {
        this.emptyField = emptyField;
    }

    public static RegisterLeaving empty(String fieldLabel) {
        return new RegisterLeaving(RegistrationField.fromLabel(fieldLabel));
    }

    @Override
    @Step("{0} submits the registration form leaving one required field empty")
    public <T extends Actor> void performAs(T actor) {
        Customer customer = Customer.random();
        List<Performable> steps = new ArrayList<>();

        fill(steps, FIRST_NAME, customer.firstName());
        fill(steps, LAST_NAME, customer.lastName());
        fill(steps, STREET, customer.street());
        fill(steps, CITY, customer.city());
        fill(steps, STATE, customer.state());
        fill(steps, ZIP_CODE, customer.zipCode());
        fill(steps, PHONE, customer.phone());
        fill(steps, SSN, customer.ssn());
        fill(steps, USERNAME, customer.username());
        fill(steps, PASSWORD, customer.password());
        fill(steps, CONFIRM_PASSWORD, customer.password());

        steps.add(Wait.seconds(1));
        steps.add(Click.on(REGISTER_BUTTON));
        steps.add(Wait.seconds(2));

        actor.attemptsTo(steps.toArray(new Performable[0]));
    }

    private void fill(List<Performable> steps, Target target, String value) {
        if (!target.equals(emptyField.target())) {
            steps.add(Enter.theValue(value).into(target));
        }
    }
}