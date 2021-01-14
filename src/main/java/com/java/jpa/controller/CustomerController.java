package com.java.jpa.controller;

import com.java.jpa.dto.OrderRequest;
import com.java.jpa.dto.OrderResponse;
import com.java.jpa.entity.Customer;
import com.java.jpa.repository.CustomerRepository;
import com.java.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder1")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders1")
    public List<Customer> findAllOrder(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo1")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
}
