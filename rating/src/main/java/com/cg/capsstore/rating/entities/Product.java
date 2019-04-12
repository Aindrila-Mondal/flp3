package com.cg.capsstore.rating.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="product_seq", initialValue=1000)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
	private int productId;
	private String productName;
	private String productType;
	private int productsInStock;
	private double productPrice;
	private int noOfProductsSold;
	private double avgRating; 
	private String imageLinks[];
	private String description;

	@ManyToOne
	@JoinColumn(name = "merchantId")
	private Merchant merchant;

	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductsInStock() {
		return productsInStock;
	}

	public void setProductsInStock(int productsInStock) {
		this.productsInStock = productsInStock;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getNoOfProductsSold() {
		return noOfProductsSold;
	}

	public void setNoOfProductsSold(int noOfProductsSold) {
		this.noOfProductsSold = noOfProductsSold;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public String[] getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(String[] imageLinks) {
		this.imageLinks = imageLinks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Product(int productId, String productName, String productType, int productsInStock, double productPrice,
			int noOfProductsSold, double avgRating, String[] imageLinks, String description, Merchant merchant,
			Cart cart) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productsInStock = productsInStock;
		this.productPrice = productPrice;
		this.noOfProductsSold = noOfProductsSold;
		this.avgRating = avgRating;
		this.imageLinks = imageLinks;
		this.description = description;
		this.merchant = merchant;
		this.cart = cart;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productsInStock=" + productsInStock + ", productPrice=" + productPrice + ", noOfProductsSold="
				+ noOfProductsSold + ", avgRating=" + avgRating + ", imageLinks=" + Arrays.toString(imageLinks)
				+ ", description=" + description + ", cart=" + cart + "]";
	}
	
}
