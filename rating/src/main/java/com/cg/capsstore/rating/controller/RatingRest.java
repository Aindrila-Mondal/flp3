package com.cg.capsstore.rating.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capsstore.rating.service.IRatingService;

@RestController
public class RatingRest {

	@Autowired
	IRatingService ratingService;

	public IRatingService getRatingService() {
		return ratingService;
	}

	public void setRatingService(IRatingService ratingService) {
		this.ratingService = ratingService;
	}

	

	@PutMapping("/{customerId}/{orderId}/{productId}/{rating}")
	public boolean giveRating(@PathVariable("customerId") int customerId, @PathVariable("orderId") int orderId,
			@PathVariable("productId") int productId, @PathVariable("rating") double rating) 
	{
		boolean isRatingDone=false;
		try {
		if(rating>=1.0 && rating<=5.0)
			isRatingDone=ratingService.giveRating(customerId, orderId, productId, rating);
		}
		catch(EntityNotFoundException | NullPointerException e)
		{
			isRatingDone=false;
		}
		
		return isRatingDone;
		
	}
}
