package chinook.assignment.repository;

import chinook.assignment.models.Customer;
import chinook.assignment.models.CustomerCountry;
import chinook.assignment.models.CustomerGenre;
import chinook.assignment.models.CustomerSpender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
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

    @Override
    public CustomerCountry findCountryWithMostCustomers() {
        String sql = "SELECT country, COUNT(country) \n" +
                "FROM customer  GROUP BY country \n" +
                    "HAVING COUNT (country)=( \n" +
                    "SELECT MAX(mycount) \n" +
                    "FROM ( \n" +
                    "SELECT country, COUNT(country) mycount \n" +
                    "FROM customer \n" +
                    "GROUP BY country) as der)";
        CustomerCountry customerCountry=new CustomerCountry("",0);

        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            if(result.next()) {
                customerCountry = new CustomerCountry(
                        result.getString("country"),
                        result.getInt("count")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerCountry;
    }

    @Override
    public CustomerSpender findHighestSpendingCustomer() {
        String sql = "SELECT customer_id, SUM(total)\n" +
                "FROM invoice  GROUP BY customer_id\n" +
                "HAVING SUM (total)=( \n" +
                "SELECT MAX(mysum) \n" +
                "FROM ( \n" +
                "SELECT customer_id, SUM(total) mysum\n" +
                "FROM invoice \n" +
                "GROUP BY customer_id) as der)";
        CustomerSpender customerSpender = new CustomerSpender(0,0);

        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            if(result.next()) {
                customerSpender = new CustomerSpender(
                        result.getInt("customer_id"),
                        result.getDouble("sum")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerSpender;
    }
}
