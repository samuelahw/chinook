package chinook.assignment.repository;

import chinook.assignment.models.Customer;
import chinook.assignment.models.CustomerCountry;
import chinook.assignment.models.CustomerGenre;
import chinook.assignment.models.CustomerSpender;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
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
