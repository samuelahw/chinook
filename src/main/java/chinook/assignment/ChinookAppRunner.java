package chinook.assignment;

import chinook.assignment.repositories.CustomerRepositoryImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ChinookAppRunner implements ApplicationRunner {

    private final CustomerRepositoryImpl customerRepository;

    public ChinookAppRunner(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(customerRepository.findCountryWithMostCustomers());
        System.out.println(customerRepository.findHighestSpendingCustomer());
        System.out.println(customerRepository.findMostPopularGenres(11));
    }
}
