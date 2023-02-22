package chinook.assignment.repository;

import java.util.List;

/**
 * This is CrudRepository Interface which has basic CRUD design. Contains only abstract methods.
 * @param <T> Object
 * @param <U> Identifier data type
 */
public interface CrudRepository<T, U> {
    /**
     * This method is used for finding all objects from database
     * @return List of objects
     * Default SQLException if connection fails
     */
    List<T> findAll();

    /**
     * This method is used for finding object with id parameter
     * @param id type depends on implementation(usually int), parameter used for finding object with this id
     * @return Object which depends on implementation
     * Default SQLException if connection fails
     */
    T findById(U id);

    /**
     * This method is used for inserting data into database
     * @param object type depends on implementation, object for database
     * @return int type, returns 0 if nothing changed, return greater than 1 if inserted
     * Default SQLException if connection fails
     */
    int insert(T object);

    /**
     * This method is used for updating data in database
     * @param object type depends on implementation, object for database
     * @return int type, returns 0 if nothing changed, return greater than 1 if updated
     * Default SQLException if connection fails
     */
    int update(T object);

    /**
     * This method is used for deleting data from database
     * @param object type depends on implementation, object for database
     * @return int type, returns 0 if nothing changed, return greater than 1 if deleted
     * Default SQLException if connection fails
     */
    int delete(T object);
    /**
     * This method is used for deleting data from database with id
     * @param id type depends on implementation(usually int), used deleting data with this id.
     * @return int type, returns 0 if nothing changed, return greater than 1 if deleted
     * Default SQLException if connection fails
     */
    int deleteById(U id);
}
