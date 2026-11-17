package co.edu.udea.certificacion.parabank.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Wait implements Interaction {

    private final long millis;

    private Wait(long millis) {
        this.millis = millis;
    }

    public static Wait seconds(int seconds) {
        return new Wait(seconds * 1000L);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}