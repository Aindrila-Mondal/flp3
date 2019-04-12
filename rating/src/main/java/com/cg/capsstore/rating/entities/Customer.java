package com.cg.capsstore.rating.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="customer_seq", initialValue=6000)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_seq")
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerMobile;
	private String customerPassword;

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address customerAddresses;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<OrderDetails> customerOrders;

	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart customerCart;

	@OneToOne
	@JoinColumn(name = "cardId")
	private Card customerCard;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/*
	 * public List<Address> getCustomerAddresses() { return customerAddresses; }
	 * 
	 * public void setCustomerAddresses(List<Address> customerAddresses) {
	 * this.customerAddresses = customerAddresses; }
	 */

	public List<OrderDetails> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<OrderDetails> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public Cart getCustomerCart() {
		return customerCart;
	}

	public void setCustomerCart(Cart customerCart) {
		this.customerCart = customerCart;
	}

	public Card getCustomerCard() {
		return customerCard;
	}

	public void setCustomerCard(Card customerCard) {
		this.customerCard = customerCard;
	}

	public Customer(int customerId, String customerName, String customerEmail, String customerMobile,
			String customerPassword, Address customerAddresses, List<OrderDetails> customerOrders, Cart customerCart,
			Card customerCard) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerPassword = customerPassword;
		this.customerAddresses = customerAddresses;
		this.customerOrders = customerOrders;
		this.customerCart = customerCart;
		this.customerCard = customerCard;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerMobile=" + customerMobile + ", customerPassword=" + customerPassword
				+ ", customerAddresses=" + customerAddresses + ", customerCart="
				+ customerCart + ", customerCard=" + customerCard + "]";
	}

}
