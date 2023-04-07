package lt.tomas.SpringDemo.service;

import lt.tomas.SpringDemo.repository.productline.ProductLine;
import lt.tomas.SpringDemo.repository.productline.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineService {
    @Autowired
    ProductLineRepository productLineRepository;

    public List<ProductLine>getallproducts(){
        return (List<ProductLine>) productLineRepository.findAll();
    }
}