package com.cg.capsstore.signup.service;


import com.cg.capsstore.signup.entites.Customer;

public interface ISignupService {
	public int addCustomer(Customer customer);

	public Customer getCustomer(int id);
  
	public boolean updateCustomer(int id, String name);
}
