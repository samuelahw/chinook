package chinook.assignment.models;

/**
 * A model for transaction total of a user.
 *
 * @param customerId
 * @param firstName
 * @param lastName
 * @param transactions number of transactions
 * @param sum          sum of all transaction of the user
 */
public record CustomerSpender(int customerId, String firstName, String lastName, int transactions, double sum) {
}
