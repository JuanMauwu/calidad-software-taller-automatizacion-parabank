package co.edu.udea.certificacion.parabank.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

import static co.edu.udea.certificacion.parabank.userinterfaces.ParabankMessages.ERROR_MESSAGES;

public class ValidationThe implements Question<List<String>> {

    private ValidationThe() {
    }

    public static ValidationThe errorMessages() {
        return new ValidationThe();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return ERROR_MESSAGES.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }
}