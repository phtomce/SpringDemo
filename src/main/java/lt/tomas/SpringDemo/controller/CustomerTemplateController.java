package lt.tomas.SpringDemo.controller;

import lt.tomas.SpringDemo.repository.customers.Customer;
import lt.tomas.SpringDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "/customertemplate")
public class CustomerTemplateController {
    @Autowired
    CustomerService customerService;
    // http://localhost:8080/customertemplate/test
    @GetMapping(path = "/test")
    public String getTestPage() {
        return "test_page";
    }
    // http://localhost:8080/customertemplate/home
    @GetMapping(path = "/home")
    public String getHomePage() {
        return "home_page";
    }
    // http://localhost:8080/customertemplate/firstpage/141
    @GetMapping(path = "/firstpage/{id}")
    public String getCustomerDetailsToFirstpage(Model model, @PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("company_name", customer.getCustomerName());
        model.addAttribute("contact_last_name", customer.getContactLastName());
        model.addAttribute("contact_first_name", customer.getContactFirstName());
        model.addAttribute("country", customer.getCountry());
        return "/test/firstpage";
    }
    // http://localhost:8080/customertemplate/firstpage/all
    @GetMapping(path = "/firstpage/all")
    public String getAllCustomersToFirstpageList(Model model) {
        List<Customer> customers = customerService.getallcustomers();
        model.addAttribute("key_customers_list", customers);
        return "/test/firstpage_customers_list";
    }
    /***
     * jQuery set up
     ***/
    // http://localhost:8080/customertemplate/jquery
    @GetMapping(path = "/jquery")
    public String getJqueryPage() {
        return "/test/jquerypage";
    }
    // http://localhost:8080/customertemplate/jquery/like/auto
    @GetMapping(path = "/jquery/like/{name}")
    public @ResponseBody List<Customer> getCustomersForJQuery(@PathVariable String name) {
        return customerService.getCustomersByNameLike("%" + name + "%");
    }
    /***
     * HTML CSS styles implementation
     **/

    // http://localhost:8080/customertemplate/customer/141
    @GetMapping(path = "/customer/{id}")
    public String getCustomer(Model model, @PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("key_customer", customer);
        return "/customer/customer_th";
    }

    // http://localhost:8080/customertemplate/customer/all
    @GetMapping(path = "/customer/all")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getallcustomers();
        model.addAttribute("key_customers_list", customers);
        return "/customer/customers_th";
    }

    // http://localhost:8080/customertemplate/customers/getandpost
    // /customertemplate/customers/getandpost
    @RequestMapping(value = "/customers/getandpost", method = RequestMethod.GET)
    public String getCustomerByNameLike(Model model) {
        model.addAttribute("key_customer", new Customer());
        model.addAttribute("key_customer_listas", Collections.emptyList());
        return "/customer/post_get_customers_th";
    }

    @RequestMapping(value = "/customers/getandpost", method = RequestMethod.POST)
    public String postCustomerByNameLike(Model model, @ModelAttribute(value = "key_customer") Customer customer) {

        List<Customer> customers =
                customerService.getCustomersQueryByNameLike("%" + customer.getCustomerName() + "%");

        model.addAttribute("key_customer_listas", customers);

        return "/customer/post_get_customers_th";
    }
}