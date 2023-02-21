package chinook.assignment;

import chinook.assignment.repository.CustomerRepositoryImpl;
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

    }
}
