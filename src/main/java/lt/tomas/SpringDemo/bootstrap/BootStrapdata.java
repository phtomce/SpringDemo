package lt.tomas.SpringDemo.bootstrap;

import lt.tomas.SpringDemo.repository.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapdata implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {

        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\n===================================");
        System.out.println(customerRepository.findById(114).get() + "\n");
        System.out.println(customerRepository.findById(141).get() + "\n");
        System.out.println(customerRepository.findById(333).get() + "\n");
        System.out.println("\n===================================");
        System.out.println(customerRepository.count());
    }
}