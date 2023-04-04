package lt.tomas.SpringDemo.bootstrap;

import lt.tomas.SpringDemo.repository.customers.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapdata implements CommandLineRunner {

    private CustomerRepository customerRepository;

    public BootStrapdata(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\n===================================");
        System.out.println(customerRepository.findById(114) + "\n");
        System.out.println(customerRepository.findById(141) + "\n");
        System.out.println(customerRepository.findById(333) + "\n");
        System.out.println("\n===================================");
        System.out.println(customerRepository.count());
    }
}
