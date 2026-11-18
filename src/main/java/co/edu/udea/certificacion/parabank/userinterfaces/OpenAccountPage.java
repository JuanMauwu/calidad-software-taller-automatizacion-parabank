package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OpenAccountPage {

    private OpenAccountPage() {
    }

    public static final Target ACCOUNT_TYPE =
            Target.the("account type list").located(By.id("type"));
    public static final Target FROM_ACCOUNT =
            Target.the("account to fund the new one").located(By.id("fromAccountId"));
    public static final Target FROM_ACCOUNT_OPTIONS =
            Target.the("accounts available to fund the new one")
                    .located(By.cssSelector("#fromAccountId option"));
    public static final Target OPEN_ACCOUNT_BUTTON =
            Target.the("open new account button")
                    .located(By.cssSelector("#openAccountForm input[value='Open New Account']"));
    public static final Target NEW_ACCOUNT_ID =
            Target.the("new account number").located(By.id("newAccountId"));
}
