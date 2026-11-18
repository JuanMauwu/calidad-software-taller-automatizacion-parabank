package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ParabankMessages {

    private ParabankMessages() {
    }

    public static final Target ERROR_MESSAGES =
            Target.the("error messages").located(By.cssSelector(".error"));
    public static final Target PAGE_TITLES =
            Target.the("page titles").located(By.cssSelector("#rightPanel h1.title"));
}
