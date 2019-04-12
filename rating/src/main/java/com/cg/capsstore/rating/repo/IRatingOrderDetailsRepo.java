package com.cg.capsstore.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.rating.entities.OrderDetails;


public interface IRatingOrderDetailsRepo extends JpaRepository<OrderDetails, Integer>{

}
