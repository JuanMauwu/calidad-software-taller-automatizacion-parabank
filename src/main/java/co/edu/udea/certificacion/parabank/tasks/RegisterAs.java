package co.edu.udea.certificacion.parabank.tasks;

import co.edu.udea.certificacion.parabank.interactions.Wait;
import co.edu.udea.certificacion.parabank.models.Customer;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.parabank.userinterfaces.RegisterPage.*;

public class RegisterAs implements Task {

    private final Customer customer;

    private RegisterAs(Customer customer) {
        this.customer = customer;
    }

    public static RegisterAs newCustomer() {
        return new RegisterAs(Customer.random());
    }

    @Override
    @Step("{0} registers as a new customer")
    public <T extends Actor> void performAs(T actor) {
        actor.remember("customer", customer);
        actor.attemptsTo(
                Click.on(REGISTER_LINK),
                Wait.seconds(1),
                Enter.theValue(customer.firstName()).into(FIRST_NAME),
                Enter.theValue(customer.lastName()).into(LAST_NAME),
                Enter.theValue(customer.street()).into(STREET),
                Enter.theValue(customer.city()).into(CITY),
                Enter.theValue(customer.state()).into(STATE),
                Enter.theValue(customer.zipCode()).into(ZIP_CODE),
                Enter.theValue(customer.phone()).into(PHONE),
                Enter.theValue(customer.ssn()).into(SSN),
                Enter.theValue(customer.username()).into(USERNAME),
                Enter.theValue(customer.password()).into(PASSWORD),
                Enter.theValue(customer.password()).into(CONFIRM_PASSWORD),
                Wait.seconds(1),
                Click.on(REGISTER_BUTTON),
                Wait.seconds(2));
    }
}