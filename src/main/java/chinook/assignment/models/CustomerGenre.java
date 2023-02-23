package chinook.assignment.models;

import java.util.List;

/**
 * A model of a customer's information and their most popular genres.
 *
 * @param customerId
 * @param firstName
 * @param lastName
 * @param genreNames the names of the most popular genres
 */
public record CustomerGenre(int customerId, String firstName, String lastName, List<String> genreNames) {
}
