package chinook.assignment.repository;

import chinook.assignment.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private final String url;
    private final String username;
    private final String password;

    public CustomerRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public int insert(Customer object) {
        return 0;
    }

    @Override
    public int update(Customer object) {
        return 0;
    }

    @Override
    public int delete(Customer object) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
