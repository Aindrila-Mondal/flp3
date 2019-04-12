package com.cg.capsstore.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.rating.entities.OrderedProduct;



public interface IRatingOrderedProductRepo extends JpaRepository<OrderedProduct, Integer> {

}
