package com.cg.capsstore.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capsstore.signup.entites.Customer;
import com.cg.capsstore.signup.entites.Merchant;
import com.cg.capsstore.signup.service.ISignUpMerchantService;
import com.cg.capsstore.signup.service.ISignupService;

@RestController
public class SignupRest {

	@Autowired
	ISignupService signupService;
	
	@Autowired
	ISignUpMerchantService signupmerchantservice;

	public ISignupService getSignupService() {
		return signupService;
	}

	public void setSignupService(ISignupService signupService) {
		this.signupService = signupService;
	}
	

	public ISignUpMerchantService getSignupmerchantservice() {
		return signupmerchantservice;
	}

	public void setSignupmerchantservice(ISignUpMerchantService signupmerchantservice) {
		this.signupmerchantservice = signupmerchantservice;
	}

	@PostMapping("/addCustomer")
	public int addCustomer(@RequestBody Customer customer) {
		// Address address = new Address(10001, "shalukpara", "naul", "tample",
		// "kolkata", "711312", "wb", "India");
		// List<OrderDetails> customerOrders = new ArrayList<>();
		// OrderDetails o = new OrderDetails(100011, null, "card",
		// Timestamp.valueOf(LocalDateTime.now()), 1000012, address, "delivered", null,
		// Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), customer);
		// customerOrders.add(o);
		// Customer customer = new Customer(1001, "arifk", "a@g.com", "9876543210",
		// "password", address, null, null, null);

		return signupService.addCustomer(customer);
	}

	@GetMapping("/customer/{id}")
	public String findCustomer(@PathVariable("id") int id) {
		System.out.println(signupService.getCustomer(id).toString());
		return signupService.getCustomer(id).toString();
	}

	@PutMapping("/update/{id}/{name}")
	public boolean updateCustomer(@PathVariable("id") int id, @PathVariable("name") String name) {
		return signupService.updateCustomer(id, name);
	}
	
	
	@PostMapping("/merchant")
	public int addMerchant(@RequestBody Merchant merchant)
	{
		return signupmerchantservice.addMerchant(merchant) ;
		
	}
}
