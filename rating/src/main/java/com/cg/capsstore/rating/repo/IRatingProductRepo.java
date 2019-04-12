package com.cg.capsstore.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.rating.entities.Product;


public interface IRatingProductRepo extends JpaRepository<Product, Integer>{

}
