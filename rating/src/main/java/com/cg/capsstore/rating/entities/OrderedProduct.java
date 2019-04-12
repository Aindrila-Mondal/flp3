package com.cg.capsstore.rating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="orderedproduct_seq", initialValue=8000)
@Table(name="ordered_product")
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="orderedproduct_seq")
	private int orderedProductId;

	@OneToOne
	@JoinColumn(name = "productId")
	private Product productOrdered;
	private double productRating;
	private boolean isRatingProvided;
	private int productquantity;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderDetails orderDetails;

	public int getOrderedProductId() {
		return orderedProductId;
	}

	public void setOrderedProductId(int orderedProductId) {
		this.orderedProductId = orderedProductId;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}

	public boolean isRatingProvided() {
		return isRatingProvided;
	}

	public void setRatingProvided(boolean isRatingProvided) {
		this.isRatingProvided = isRatingProvided;
	}

	public Product getProductOrdered() {
		return productOrdered;
	}

	public void setProductOrdered(Product productOrdered) {
		this.productOrdered = productOrdered;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public OrderedProduct(int orderedProductId, Product productOrdered, double productRating, boolean isRatingProvided,
			OrderDetails orderDetails) {
		super();
		this.orderedProductId = orderedProductId;
		this.productOrdered = productOrdered;
		this.productRating = productRating;
		this.isRatingProvided = isRatingProvided;
		this.orderDetails = orderDetails;
	}

	public OrderedProduct() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderedProduct [orderedProductId=" + orderedProductId + ", productOrdered=" + productOrdered
				+ ", productRating=" + productRating + ", isRatingProvided=" + isRatingProvided + ", productquantity="
				+ productquantity + ", orderDetails=" + orderDetails + "]\n";
	}
}
