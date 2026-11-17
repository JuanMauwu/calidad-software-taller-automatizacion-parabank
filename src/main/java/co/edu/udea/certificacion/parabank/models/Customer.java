package co.edu.udea.certificacion.parabank.models;

public record Customer(String firstName, String lastName, String street, String city,
                       String state, String zipCode, String phone, String ssn,
                       String username, String password) {

    public static Customer random() {
        long stamp = System.currentTimeMillis();
        return new Customer(
                "Test",
                "Customer",
                "Calle 10 # 20-30",
                "Medellin",
                "Antioquia",
                "050001",
                "3001234567",
                String.format("%09d", stamp % 1_000_000_000L),
                "user" + stamp,
                "Test1234");
    }
}