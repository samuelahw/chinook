package chinook.assignment.repository;

import chinook.assignment.models.Customer;
import chinook.assignment.models.CustomerCountry;
import chinook.assignment.models.CustomerGenre;
import chinook.assignment.models.CustomerSpender;

import java.util.List;

/**
 * This is an Interface for CustomerRepository. This interface extends functionality from CrudRepository.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    /**
     * Returns customer that contains full name from parameter or null if there is no customer with parameter name.
     *
     * @param fullName is String parameter for customer full name
     * @return Customer object containing customer with parameter full name or null if there is no customer with parameter name
     */
    public Customer findCustomerByName(String fullName);

    /**
     * Returns list of customers limited by parameters
     *
     * @param limit  is int parameter for number of customers in list
     * @param offset is int parameter for customer from customer_id offset
     * @return List containing Customer objects
     */
    public List<Customer> getCustomersByPage(int limit, int offset);

    /**
     * Not implemented
     */
    @Override
    public default int delete(Customer object) {
        return 0;
    }

    /**
     * Not implemented
     */
    @Override
    public default int deleteById(Integer id) {
        return 0;
    }
    /**
     * Returns the country with the most customers and the numbers of customers located in that country.
     *
     * @return an instance of CustomerCountry
     */
    CustomerCountry findCountryWithMostCustomers();

    /**
     * Returns information of the highest spending customer.
     *
     * @return an instance of CustomerSpender
     */
    CustomerSpender findHighestSpendingCustomer();

    /**
     * Gets the most popular genres for a specific customer.
     *
     * @param customerId the id for a customer
     * @return an instance of CustomerGenre
     */
    CustomerGenre findMostPopularGenres(Integer customerId);
}
