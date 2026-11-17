package co.edu.udea.certificacion.parabank.models;

import co.edu.udea.certificacion.parabank.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;

public enum RegistrationField {

    FIRST_NAME("first name", RegisterPage.FIRST_NAME),
    LAST_NAME("last name", RegisterPage.LAST_NAME),
    ADDRESS("address", RegisterPage.STREET),
    CITY("city", RegisterPage.CITY),
    STATE("state", RegisterPage.STATE),
    ZIP_CODE("zip code", RegisterPage.ZIP_CODE),
    SSN("ssn", RegisterPage.SSN),
    USERNAME("username", RegisterPage.USERNAME),
    PASSWORD("password", RegisterPage.PASSWORD),
    PASSWORD_CONFIRMATION("password confirmation", RegisterPage.CONFIRM_PASSWORD);
    private final String label;
    private final Target target;

    RegistrationField(String label, Target target) {
        this.label = label;
        this.target = target;
    }

    public Target target() {
        return target;
    }

    public static RegistrationField fromLabel(String label) {
        return Arrays.stream(values())
                .filter(field -> field.label.equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown registration field: " + label));
    }
}