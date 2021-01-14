package com.java.jpa.controller;

import com.java.jpa.entity.Product;
import com.java.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * https://medium.com/@ragunathrajasekaran/getting-started-with-spring-data-jpa-hibernate-orm-repository-part-4-95a6ef2af513
 */
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        Product response = productRepository.save(product);
        return response;

    }
    @GetMapping("/allProduct")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


}
