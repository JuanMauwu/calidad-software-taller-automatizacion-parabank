package co.edu.udea.certificacion.parabank.models;

/** New contact data used when the customer updates the profile. */
public record ContactInfo(String street, String city, String state, String zipCode, String phone) {

    public static ContactInfo updated() {
        return new ContactInfo(
                "Carrera 43A # 1-50",
                "Envigado",
                "Antioquia",
                "055420",
                "3109876543");
    }
}
