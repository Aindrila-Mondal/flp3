package com.cg.capsstore.rating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="card_seq", initialValue=4000)
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="card_seq")
	private int cardId;

	private String cardHolderName;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private int cardCVV;
	private String cardType;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(int cardCVV) {
		this.cardCVV = cardCVV;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Card(int cardId, String cardHolderName, String cardNumber, String expiryMonth, String expiryYear,
			int cardCVV, String cardType) {
		super();
		this.cardId = cardId;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cardCVV = cardCVV;
		this.cardType = cardType;
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardHolderName=" + cardHolderName + ", cardNumber=" + cardNumber
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", cardCVV=" + cardCVV + ", cardType="
				+ cardType + "]";
	}
	
}
