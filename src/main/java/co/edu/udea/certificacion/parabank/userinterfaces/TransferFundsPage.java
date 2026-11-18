package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferFundsPage {

    private TransferFundsPage() {
    }

    public static final Target AMOUNT =
            Target.the("amount field").located(By.id("amount"));
    public static final Target FROM_ACCOUNT =
            Target.the("from account list").located(By.id("fromAccountId"));
    public static final Target TO_ACCOUNT =
            Target.the("to account list").located(By.id("toAccountId"));
    public static final Target SECOND_TO_ACCOUNT_OPTION =
            Target.the("second destination account")
                    .located(By.cssSelector("#toAccountId option:nth-of-type(2)"));
    public static final Target TRANSFER_BUTTON =
            Target.the("transfer button").located(By.cssSelector("#transferForm input[type='submit']"));

    public static Target toAccountOption(String accountId) {
        return Target.the("destination account " + accountId)
                .located(By.cssSelector("#toAccountId option[value='" + accountId + "']"));
    }
}
