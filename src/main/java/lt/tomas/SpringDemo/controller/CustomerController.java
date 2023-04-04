package lt.tomas.SpringDemo.controller;

import lt.tomas.SpringDemo.repository.customers.Customer;
import lt.tomas.SpringDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // localhost:8080 -> 127.0.0.1:8080
@RequestMapping(path = "/customer") // localhost:8080/customer
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // http://localhost:8080/customer/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage() {
        return "This is some text from SPRING";
    }

    //http://localhost:8080/customer/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Customer> getAllCustomers() {
        return customerService.getallcustomers();
    }
}
