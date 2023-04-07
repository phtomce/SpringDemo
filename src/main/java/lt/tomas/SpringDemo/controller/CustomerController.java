package lt.tomas.SpringDemo.controller;

import lt.tomas.SpringDemo.repository.customers.Customer;
import lt.tomas.SpringDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    //http://localhost:8080/customer/141
@GetMapping(path = "/{id}")
    public @ResponseBody Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
}
//http://localhost:8080/customer/141
    @GetMapping(path = "/customised/{id}")
    public @ResponseBody Customer getCustomerByIdCustomised(@PathVariable int id){
        return customerService.getCustomerByIdCustomised(id);
    }
    //http://localhost:8080/customer/name/double
    @GetMapping (path = "/name/{name}")
    public @ResponseBody List<Customer> getCustomersByNameLike(@PathVariable String name){
        return customerService.getCustomersByNameLike("%" + name + "%");
    }

    //http://localhost:8080/customer/name/query/double
    @GetMapping(path ="/name/query/{name}")
    public @ResponseBody List<Customer>getCustomersQueryByNameLike(@PathVariable String name){
        return customerService.getCustomersQueryByNameLike(name);
    }

    //http://localhost:8080/customer/customised/param?id=141
    @GetMapping(path = "/customised/param")
    public @ResponseBody Customer getCustomerByIdParam(@RequestParam int id){
        return customerService.getCustomerByIdCustomised(id);
    }

}
