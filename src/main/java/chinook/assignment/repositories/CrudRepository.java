package chinook.assignment.repositories;

import java.util.List;

/**
 * This is CrudRepository Interface which has basic CRUD design. Contains only abstract methods.
 *
 * @param <T> Object
 * @param <U> Identifier data type
 */
public interface CrudRepository<T, U> {
    /**
     * This method is used for finding all objects from database
     *
     * @return List of objects
     */
    List<T> findAll();

    /**
     * This method is used for finding object with id parameter
     *
     * @param id type depends on implementation(usually int), parameter used for finding object with this id
     * @return Object which depends on implementation
     */
    T findById(U id);

    /**
     * This method is used for inserting data into database
     *
     * @param object type depends on implementation, object for database
     * @return int type, returns 0 if nothing changed, return greater than 1 if inserted
     */
    int insert(T object);

    /**
     * This method is used for updating data in database
     *
     * @param object type depends on implementation, object for database
     * @return int type, returns 0 if nothing changed, return greater than 1 if updated
     */
    int update(T object);

    /**
     * This method is used for deleting data from database
     *
     * @param object type depends on implementation, object for database
     * @return int type, returns 0 if nothing changed, return greater than 1 if deleted
     */
    int delete(T object);

    /**
     * This method is used for deleting data from database with id
     *
     * @param id type depends on implementation(usually int), used deleting data with this id.
     * @return int type, returns 0 if nothing changed, return greater than 1 if deleted
     */
    int deleteById(U id);
}
