package com.cg.capsstore.rating.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capsstore.rating.entities.Merchant;
import com.cg.capsstore.rating.entities.OrderDetails;
import com.cg.capsstore.rating.entities.OrderedProduct;
import com.cg.capsstore.rating.entities.Product;
import com.cg.capsstore.rating.repo.IRatingCustomerRepo;
import com.cg.capsstore.rating.repo.IRatingMerchantRepo;
import com.cg.capsstore.rating.repo.IRatingOrderDetailsRepo;
import com.cg.capsstore.rating.repo.IRatingOrderedProductRepo;
import com.cg.capsstore.rating.repo.IRatingProductRepo;

@Service
@Transactional
public class RatingServiceImpl implements IRatingService
{

	@Autowired
	IRatingOrderDetailsRepo ratingOrderDetailsRepo;

	@Autowired
	IRatingCustomerRepo ratingCustomerRepo;

	@Autowired
	IRatingMerchantRepo ratingMerchantRepo;

	@Autowired
	IRatingProductRepo ratingProductRepo;

	@Autowired
	IRatingOrderedProductRepo ratingOrderedProductRepo;

	public IRatingOrderDetailsRepo getRatingOrderDetailsRepo() {
		return ratingOrderDetailsRepo;
	}

	public void setRatingOrderDetailsRepo(IRatingOrderDetailsRepo ratingOrderDetailsRepo) {
		this.ratingOrderDetailsRepo = ratingOrderDetailsRepo;
	}

	public IRatingCustomerRepo getRatingCustomerRepo() {
		return ratingCustomerRepo;
	}

	public void setRatingCustomerRepo(IRatingCustomerRepo ratingCustomerRepo) {
		this.ratingCustomerRepo = ratingCustomerRepo;
	}

	public IRatingMerchantRepo getRatingMerchantRepo() {
		return ratingMerchantRepo;
	}

	public void setRatingMerchantRepo(IRatingMerchantRepo ratingMerchantRepo) {
		this.ratingMerchantRepo = ratingMerchantRepo;
	}

	public IRatingProductRepo getRatingProductRepo() {
		return ratingProductRepo;
	}

	public void setRatingProductRepo(IRatingProductRepo ratingProductRepo) {
		this.ratingProductRepo = ratingProductRepo;
	}

	public IRatingOrderedProductRepo getRatingOrderedProductRepo() {
		return ratingOrderedProductRepo;
	}

	public void setRatingOrderedProductRepo(IRatingOrderedProductRepo ratingOrderedProductRepo) {
		this.ratingOrderedProductRepo = ratingOrderedProductRepo;
	}

	/*
	 * this method is used to update the average rating for the product that rating is provided
	 */
	public void changeProductAvgRating(int productId, double rating,int countOfRating)
	{
		
		Product product = ratingProductRepo.getOne(productId);
		double prevAvgRating = product.getAvgRating();
		
		double newAvgRating = ((prevAvgRating * countOfRating) + rating) / (countOfRating +1);
		product.setAvgRating(newAvgRating);
		ratingProductRepo.save(product);
	}

	/*
	 * this method is used to update merchant rating bases on all its product
	 */
	public void updateMerchantRating(int productId) 
	{
		
		Product prod = ratingProductRepo.getOne(productId);
		int merchantId = (prod.getMerchant()).getMerchantId();
		Merchant merchant = ratingMerchantRepo.getOne(merchantId);
		List<Product> listproduct = merchant.getProductsAvailable();
		double sumOfRating = 0;
		int noOfProductRatingGiven = 0;
		
		for (Product productsOfMerchant : listproduct) 
		{
			if (productsOfMerchant.getAvgRating() != 0) 
			{
				sumOfRating += productsOfMerchant.getAvgRating();
				noOfProductRatingGiven++;

			}
		}
		double newMerchantRating = sumOfRating / noOfProductRatingGiven;
		merchant.setMerchantRating(newMerchantRating);
		ratingMerchantRepo.save(merchant);
	}

	/*
	 * This method is used to get number of a particular product rating already provided it will be used in generating product avg rating
	 */
	public int getNoOfRatingAlreadyGiven(int productId)
	{
		List<OrderedProduct> listOfOrdered=ratingOrderedProductRepo.findAll();
		int countOfRating=0;
		for(OrderedProduct productsOrdered:listOfOrdered)
		{
			if((productsOrdered.getProductOrdered()).getProductId()==productId  && productsOrdered.isRatingProvided()==true)
			{
				countOfRating++;
				
			}
		}
		return countOfRating;
	}
	
	
	@Override
	/*
	 * Description:-
	 * this method take customer id and search his order details from order_details table
	 * from that table only that particular order is fetched which is passes as named query
	 * then from that particular order all the order products are fetched from ordered_product table
	 * then the value of product Id is matched and retrived that particular product and rating is provided for that ordered product  
	 */
	public boolean giveRating(int customerId, int orderId, int productId, double rating) throws EntityNotFoundException,NullPointerException
	{
		boolean isRatingUpdated=false;
	
		List<OrderDetails> listOrderDetails = ratingCustomerRepo.getOne(customerId).getCustomerOrders();
	
		if(listOrderDetails != null) 
		{
			
			OrderDetails customerOrderDetails = null;
			for (OrderDetails particularOrderDetails : listOrderDetails) 
			{
				if (particularOrderDetails.getOrderId() == orderId) 
				{
					customerOrderDetails = particularOrderDetails;
				
				}
			
			}

			List<OrderedProduct> listProductOrdered = customerOrderDetails.getProductsOrdered();
	
			for (OrderedProduct orderedProd : listProductOrdered) 
			{
			
				if ((orderedProd.getProductOrdered()).getProductId() == productId) 
				{
				
					if (orderedProd.isRatingProvided() == false) 
					{
					
						orderedProd.setProductRating(rating);
					
						changeProductAvgRating(productId, rating, getNoOfRatingAlreadyGiven(productId));
					
						updateMerchantRating(productId);
					
						orderedProd.setRatingProvided(true);
					
						ratingOrderedProductRepo.save(orderedProd);
						ratingOrderDetailsRepo.save(customerOrderDetails);
						
						isRatingUpdated=true;
					}
				}

			}
		}
		else
		{
			isRatingUpdated=false;
		}
		return isRatingUpdated;

	}
}
