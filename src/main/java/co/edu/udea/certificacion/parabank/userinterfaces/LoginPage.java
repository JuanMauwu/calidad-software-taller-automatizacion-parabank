package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    private LoginPage() {
    }

    public static final Target USERNAME =
            Target.the("login username field").located(By.name("username"));
    public static final Target PASSWORD =
            Target.the("login password field").located(By.name("password"));
    public static final Target LOGIN_BUTTON =
            Target.the("log in button").located(By.cssSelector("input[value='Log In']"));
}