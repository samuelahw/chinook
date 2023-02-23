package chinook.assignment.repository;

import chinook.assignment.models.Customer;
import chinook.assignment.models.CustomerCountry;
import chinook.assignment.models.CustomerGenre;
import chinook.assignment.models.CustomerSpender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an implementation of CustomerRepository.
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final String url;
    private final String username;
    private final String password;

    /**
     * Constructor for database connection details.
     *
     * @param url      String, database URL
     * @param username String, database username
     * @param password String, database password
     */
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

        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer";
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(Integer id) {
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE customer_id = ?";
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public int insert(Customer object) {
        String sql = "INSERT INTO customer (first_name, last_name, country, postal_code, phone, email) VALUES (?,?,?,?,?,?)";
        int result = 0;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, object.firstName());
            statement.setString(2, object.lastName());
            statement.setString(3, object.country());
            statement.setString(4, object.postalCode());
            statement.setString(5, object.phone());
            statement.setString(6, object.email());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Customer object) {

        int result = 0;

        String sql = "UPDATE customer SET first_name=?, last_name=?, country=?, postal_code=?, phone=?, email=? WHERE customer_id=?";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, object.firstName());
            statement.setString(2, object.lastName());
            statement.setString(3, object.country());
            statement.setString(4, object.postalCode());
            statement.setString(5, object.phone());
            statement.setString(6, object.email());
            statement.setInt(7, object.customerId());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Customer findCustomerByName(String name) {
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE first_name || ' ' || last_name LIKE ?";
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomersByPage(int limit, int offset) {

        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer ORDER BY customer_id LIMIT ? OFFSET ?";
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public CustomerCountry findCountryWithMostCustomers() {
        String sql = "SELECT country, COUNT(country) " +
                "FROM customer " +
                "GROUP BY country " +
                "ORDER BY COUNT(country) DESC " +
                "LIMIT 1;";
        CustomerCountry customerCountry = new CustomerCountry("", 0);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
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
        String sql = "SELECT customer.customer_id, first_name, last_name, COUNT(total) AS transactions, SUM(total) AS total " +
                "FROM customer " +
                "INNER JOIN invoice " +
                "ON customer.customer_id = invoice.customer_id " +
                "GROUP BY customer.customer_id " +
                "ORDER BY total DESC " +
                "LIMIT 1";
        CustomerSpender customerSpender = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                customerSpender = new CustomerSpender(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getInt("transactions"),
                        result.getDouble("total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerSpender;
    }

    /**
     * Finds the most popular genres for a specific customer. Includes the most
     * popular genre and in a tie includes a second genre (maximum number of genres: 2).
     *
     * @param customerIdParam the id for a customer
     * @return an instance of CustomerGenre
     */
    @Override
    public CustomerGenre findMostPopularGenres(Integer customerIdParam) {
        String sql = "SELECT COUNT(track.genre_id) track_count, genre.name genre_name, customer.customer_id, first_name, last_name " +
                "FROM track " +
                "INNER JOIN genre ON track.genre_id = genre.genre_id " +
                "INNER JOIN invoice_line ON track.track_id = invoice_line.track_id " +
                "INNER JOIN invoice ON invoice_line.invoice_id = invoice.invoice_id " +
                "INNER JOIN customer ON invoice.customer_id = customer.customer_id " +
                "WHERE customer.customer_id = ? " +
                "GROUP BY customer.customer_id, genre.name " +
                "ORDER BY COUNT(track.genre_id) DESC " +
                "LIMIT 2";

        Integer trackCount = null;
        List<String> genreNames = new ArrayList<>();
        int customerId = 0;
        String firstName = "";
        String lastName = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customerIdParam);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                if (trackCount == null) {
                    customerId = result.getInt("customer_id");
                    firstName = result.getString("first_name");
                    lastName = result.getString("last_name");
                    trackCount = result.getInt("track_count");
                    genreNames.add(result.getString("genre_name"));
                } else if (result.getInt("track_count") == trackCount) {
                    genreNames.add(result.getString("genre_name"));
                } else break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new CustomerGenre(customerId, firstName, lastName, genreNames);
    }
}
