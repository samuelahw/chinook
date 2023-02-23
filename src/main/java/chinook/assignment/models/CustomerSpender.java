package chinook.assignment.models;

public record CustomerSpender(int customerId, String firstName, String lastName, int transactions, double sum) {
}
