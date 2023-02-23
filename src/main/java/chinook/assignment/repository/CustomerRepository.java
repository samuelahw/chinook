package chinook.assignment.repository;

import chinook.assignment.models.Customer;
import chinook.assignment.models.CustomerCountry;
import chinook.assignment.models.CustomerGenre;
import chinook.assignment.models.CustomerSpender;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    /**
     * Returns the country with the most customers and the numbers of customers located in that country.
     *
     * @return record containing the country and the number of customers
     */
    CustomerCountry findCountryWithMostCustomers();

    /**
     * Returns information of the highest spending customer.
     *
     * @return record containing the id, first and last name of the customer, transaction count and the amount spent
     */
    CustomerSpender findHighestSpendingCustomer();
    CustomerGenre findMostPopularGenres(Integer customerId);
}
