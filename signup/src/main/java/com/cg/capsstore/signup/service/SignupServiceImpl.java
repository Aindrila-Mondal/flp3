package com.cg.capsstore.signup.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capsstore.signup.entites.Customer;
import com.cg.capsstore.signup.repo.ISignupCustomerRepo;

@Service
@Transactional
public class SignupServiceImpl implements ISignupService {

	@Autowired
	ISignupCustomerRepo signupRepo;

	public ISignupCustomerRepo getSignupRepo() {
		return signupRepo;
	}

	public void setSignupRepo(ISignupCustomerRepo signupRepo) {
		this.signupRepo = signupRepo;
	}

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		signupRepo.save(customer);
		return customer.getCustomerId();
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return signupRepo.getOne(id);
	}

	@Override
	public boolean updateCustomer(int id, String name) {
		// TODO Auto-generated method stub
		Customer studentOptional = signupRepo.getOne(id);

		if (studentOptional == null)
			return false;

		studentOptional.setCustomerName(name);

		signupRepo.save(studentOptional);

		return true;
	}

}
