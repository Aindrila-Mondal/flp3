package com.cg.capsstore.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.rating.entities.Merchant;

public interface IRatingMerchantRepo extends JpaRepository<Merchant, Integer>{

}
