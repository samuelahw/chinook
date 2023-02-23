package chinook.assignment.models;

import java.util.List;

public record CustomerGenre (int customerId, String firstName, String lastName, int genreTrackCount, List<String> genreNames){
}
