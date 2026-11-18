package co.edu.udea.certificacion.parabank.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UpdateProfilePage {

    private UpdateProfilePage() {
    }

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
    public static final Target UPDATE_PROFILE_BUTTON =
            Target.the("update profile button")
                    .located(By.cssSelector("#updateProfileForm input[value='Update Profile']"));
}
