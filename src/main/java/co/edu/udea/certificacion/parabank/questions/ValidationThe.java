package co.edu.udea.certificacion.parabank.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

import static co.edu.udea.certificacion.parabank.userinterfaces.ParabankMessages.ERROR_MESSAGES;
import static co.edu.udea.certificacion.parabank.userinterfaces.ParabankMessages.PAGE_TITLES;

/**
 * Reads the visible texts of a group of elements. Hidden elements return an empty
 * text in Selenium, so they are filtered out and only what the user sees is compared.
 */
public class ValidationThe implements Question<List<String>> {

    private final Target target;

    private ValidationThe(Target target) {
        this.target = target;
    }

    public static ValidationThe errorMessages() {
        return new ValidationThe(ERROR_MESSAGES);
    }

    public static ValidationThe pageMessages() {
        return new ValidationThe(PAGE_TITLES);
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return target.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }
}
