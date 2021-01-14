package com.java.jpa.repository;

import com.java.jpa.dto.OrderResponse;
import com.java.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // here query is returning two field so return type either string array or a class . here we are going to create class
    @Query("SELECT new com.java.jpa.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();

}
