package chinook.assignment.models;

/**
 * A model for a country with the highest number of customers.
 *
 * @param country        country name
 * @param totalCustomers number of customers
 */
public record CustomerCountry(String country, int totalCustomers) {
}
