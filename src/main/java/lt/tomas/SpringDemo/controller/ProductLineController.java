package lt.tomas.SpringDemo.controller;


import lt.tomas.SpringDemo.repository.productline.ProductLine;
import lt.tomas.SpringDemo.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/productline")
public class ProductLineController {

    @Autowired
    ProductLineService productLineService;

    //http://localhost:8080/productline/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage() {
        return "This is some text from Easter";
    }

    //http://localhost:8080/productline/all
    @GetMapping(path = "/all")
    public @ResponseBody List<ProductLine>getAllProducts(){
        return productLineService.getallproducts();
    }
}