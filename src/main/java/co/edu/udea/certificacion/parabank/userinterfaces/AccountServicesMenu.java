package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountServicesMenu {

    private AccountServicesMenu() {
    }

    public static final Target OPEN_NEW_ACCOUNT =
            Target.the("open new account link").located(By.linkText("Open New Account"));
    public static final Target TRANSFER_FUNDS =
            Target.the("transfer funds link").located(By.linkText("Transfer Funds"));
    public static final Target UPDATE_CONTACT_INFO =
            Target.the("update contact info link").located(By.linkText("Update Contact Info"));
}
