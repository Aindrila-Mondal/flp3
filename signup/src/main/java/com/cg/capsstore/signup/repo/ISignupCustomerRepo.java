package com.cg.capsstore.signup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.signup.entites.Customer;

public interface ISignupCustomerRepo extends JpaRepository<Customer, Integer> {

}
