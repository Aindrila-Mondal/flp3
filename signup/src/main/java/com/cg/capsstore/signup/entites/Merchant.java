package com.cg.capsstore.signup.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="merchant_seq", initialValue=3001)
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="merchant_seq")
	private int merchantId;

	private String merchantName;
	private String shopName;
	private String shopAddress;
	private String merchantEmail;
	private String merchantMobile;
	private String merchantPassword;
	private double merchantRating;

	@JsonIgnore
	@OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
	private List<Product> productsAvailable;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public String getMerchantMobile() {
		return merchantMobile;
	}

	public void setMerchantMobile(String merchantMobile) {
		this.merchantMobile = merchantMobile;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public double getMerchantRating() {
		return merchantRating;
	}

	public void setMerchantRating(double merchantRating) {
		this.merchantRating = merchantRating;
	}

	public List<Product> getProductsAvailable() {
		return productsAvailable;
	}

	public void setProductsAvailable(List<Product> productsAvailable) {
		this.productsAvailable = productsAvailable;
	}

	public Merchant(int merchantId, String merchantName, String shopName, String shopAddress, String merchantEmail,
			String merchantMobile, String merchantPassword, double merchantRating, List<Product> productsAvailable) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.merchantEmail = merchantEmail;
		this.merchantMobile = merchantMobile;
		this.merchantPassword = merchantPassword;
		this.merchantRating = merchantRating;
		this.productsAvailable = productsAvailable;
	}

	public Merchant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantName=" + merchantName + ", shopName=" + shopName
				+ ", shopAddress=" + shopAddress + ", merchantEmail=" + merchantEmail + ", merchantMobile="
				+ merchantMobile + ", merchantPassword=" + merchantPassword + ", merchantRating=" + merchantRating
				+ "]";
	}
	
}
