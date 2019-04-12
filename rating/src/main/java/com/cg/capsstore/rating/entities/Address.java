package com.cg.capsstore.rating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="address_seq", initialValue=2000)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_seq")
	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private String landMark;
	private String city;
	private String pinCode;
	private String state;
	private String country;


	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(int addressId, String addressLine1, String addressLine2, String landMark, String city,
			String pinCode, String state, String country) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landMark = landMark;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", landMark=" + landMark + ", city=" + city + ", pinCode=" + pinCode + ", state=" + state
				+ ", country=" + country + "]";
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

}
