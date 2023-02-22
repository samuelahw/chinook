package chinook.assignment.repository;

import chinook.assignment.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    /**
     * Returns customer which contains full name from parameter or null if there is no customer with parameter name.
     * @param fullName is String parameter for customer full name
     * @return Customer object containing customer with parameter full name or null if there is no customer with parameter name
     */
    public Customer findCustomerByName(String fullName);

    /**
     * Returns list of customers limited by parameters
     * @param limit is Int parameter for number of customers in list
     * @param offset is Int parameter for customer from customer_id offset
     * @return List containing Customer objects
     */
    public List<Customer> getCustomersByPage(int limit, int offset);
}
