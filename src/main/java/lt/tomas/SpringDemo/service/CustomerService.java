package lt.tomas.SpringDemo.service;

import lt.tomas.SpringDemo.repository.customers.Customer;
import lt.tomas.SpringDemo.repository.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer>getallcustomers(){
        return (List<Customer>) customerRepository.findAll();
    }
}
