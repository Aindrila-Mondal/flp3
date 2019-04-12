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
@SequenceGenerator(name="cart_seq", initialValue=5000)
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_seq")
	private int cartId;

	@JsonIgnore
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Product> productsInCart;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(List<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}

	public Cart(int cartId, List<Product> productsInCart) {
		super();
		this.cartId = cartId;
		this.productsInCart = productsInCart;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productsInCart=" + productsInCart + "]";
	}
	
}
