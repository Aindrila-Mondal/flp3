package com.cg.capsstore.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.rating.entities.Customer;


public interface IRatingCustomerRepo extends JpaRepository<Customer, Integer>{

}
