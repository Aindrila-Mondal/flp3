package com.cg.capsstore.signup.entites;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "order_seq", initialValue = 7000)
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	private int orderId;

	@JsonIgnore
	@OneToMany(mappedBy = "orderDetails", cascade = CascadeType.ALL)
	private List<OrderedProduct> productsOrdered;

	private String modeOfPurchase;
	private Timestamp orderDateTime;
	private double totalAmount;

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address deliveryAddress;
	private String deliveryStatus;

	@OneToOne
	@JoinColumn(name = "cardId")
	private Card card;

	private Date expectedDeliveryDate;
	private Date deliveredDate;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getModeOfPurchase() {
		return modeOfPurchase;
	}

	public void setModeOfPurchase(String modeOfPurchase) {
		this.modeOfPurchase = modeOfPurchase;
	}

	public Timestamp getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Timestamp orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderedProduct> getProductsOrdered() {
		return productsOrdered;
	}

	public void setProductsOrdered(List<OrderedProduct> productsOrdered) {
		this.productsOrdered = productsOrdered;
	}

	public OrderDetails(int orderId, List<OrderedProduct> productsOrdered, String modeOfPurchase,
			Timestamp orderDateTime, double totalAmount, Address deliveryAddress, String deliveryStatus, Card card,
			Date expectedDeliveryDate, Date deliveredDate, Customer customer) {
		super();
		this.orderId = orderId;
		this.productsOrdered = productsOrdered;
		this.modeOfPurchase = modeOfPurchase;
		this.orderDateTime = orderDateTime;
		this.totalAmount = totalAmount;
		this.deliveryAddress = deliveryAddress;
		this.deliveryStatus = deliveryStatus;
		this.card = card;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.deliveredDate = deliveredDate;
		this.customer = customer;
	}

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId +  ", modeOfPurchase="
				+ modeOfPurchase + ", orderDateTime=" + orderDateTime + ", totalAmount=" + totalAmount
				+ ", deliveryAddress=" + deliveryAddress + ", deliveryStatus=" + deliveryStatus + ", card=" + card
				+ ", expectedDeliveryDate=" + expectedDeliveryDate + ", deliveredDate=" + deliveredDate + ", customer="
				+ customer + "]\n";
	}

}
