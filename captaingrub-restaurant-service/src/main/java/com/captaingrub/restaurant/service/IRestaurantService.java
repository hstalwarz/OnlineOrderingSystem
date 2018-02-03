package com.captaingrub.restaurant.service;

import java.util.List;

import com.captaingrub.restaurant.domainmodel.entity.Restaurant;

/**
 * The Interface IRestaurantService.
 */
public interface IRestaurantService {
	
	/**
	 * Gets the restaurant by id.
	 *
	 * @param id the id
	 * @return the restaurant by id
	 */
	Restaurant getRestaurantById(Long id);
	
}
