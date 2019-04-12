package com.cg.capsstore.signup.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capsstore.signup.entites.Merchant;
import com.cg.capsstore.signup.repo.ISignUpMerchantRepo;

@Service
@Transactional
public class SignupMerchantServiceImpl implements ISignUpMerchantService {

	@Autowired
	ISignUpMerchantRepo signupmerchantrepo;

	public ISignUpMerchantRepo getSignupmerchantrepo() {
		return signupmerchantrepo;
	}

	public void setSignupmerchantrepo(ISignUpMerchantRepo signupmerchantrepo) {
		this.signupmerchantrepo = signupmerchantrepo;
	}

	@Override
	public int addMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		signupmerchantrepo.save(merchant);
		return merchant.getMerchantId();
	}
	
}
