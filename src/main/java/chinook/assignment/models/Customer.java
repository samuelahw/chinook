package chinook.assignment.models;

/**
 * A model for customer, contains data of customer.
 *
 * @param customerId int, id of customer
 * @param firstName  String, first name
 * @param lastName   String, last name
 * @param country    String, country name
 * @param postalCode String, postal code
 * @param phone      String, phone number
 * @param email      String, email
 */
public record Customer(int customerId, String firstName, String lastName, String country, String postalCode,
                       String phone, String email) {
}
