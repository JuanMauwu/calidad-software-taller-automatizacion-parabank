package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage {

    private RegisterPage() {
    }

    public static final Target REGISTER_LINK =
            Target.the("register link").located(By.linkText("Register"));
    public static final Target FIRST_NAME =
            Target.the("first name field").located(By.id("customer.firstName"));
    public static final Target LAST_NAME =
            Target.the("last name field").located(By.id("customer.lastName"));
    public static final Target STREET =
            Target.the("address field").located(By.id("customer.address.street"));
    public static final Target CITY =
            Target.the("city field").located(By.id("customer.address.city"));
    public static final Target STATE =
            Target.the("state field").located(By.id("customer.address.state"));
    public static final Target ZIP_CODE =
            Target.the("zip code field").located(By.id("customer.address.zipCode"));
    public static final Target PHONE =
            Target.the("phone field").located(By.id("customer.phoneNumber"));
    public static final Target SSN =
            Target.the("SSN field").located(By.id("customer.ssn"));
    public static final Target USERNAME =
            Target.the("username field").located(By.id("customer.username"));
    public static final Target PASSWORD =
            Target.the("password field").located(By.id("customer.password"));
    public static final Target CONFIRM_PASSWORD =
            Target.the("confirm password field").located(By.id("repeatedPassword"));
    public static final Target REGISTER_BUTTON =
            Target.the("register button").located(By.cssSelector("#customerForm input[type='submit']"));
}