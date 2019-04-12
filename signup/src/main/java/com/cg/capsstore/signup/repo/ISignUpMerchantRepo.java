package com.cg.capsstore.signup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capsstore.signup.entites.Merchant;

public interface ISignUpMerchantRepo extends JpaRepository<Merchant, Integer> {

}
