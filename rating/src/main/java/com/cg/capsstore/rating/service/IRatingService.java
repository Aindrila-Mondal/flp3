package com.cg.capsstore.rating.service;

import javax.persistence.EntityNotFoundException;

public interface IRatingService {



	public boolean giveRating(int customerId, int orderId, int productId, double rating) throws EntityNotFoundException,NullPointerException;

}
