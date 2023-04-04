package lt.tomas.SpringDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // localhost:8080 -> 127.0.0.1:8080
@RequestMapping(path = "/customer") // localhost:8080/customer
public class CustomerController  {

    // http://localhost:8080/customer/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage(){
        return "This is some text from SPRING";
    }
}
