package com.captaingrub.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.domainmodel.repo.RestaurantRepository;
import com.captaingrub.restaurant.service.IRestaurantService;

/**
 * The Class RestaurantServiceImpl.
 */
@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	/** The restaurant repo. */
	@Autowired
	private RestaurantRepository restaurantRepo;

	@Override
	public Restaurant getRestaurantById(Long id) {
		return this.restaurantRepo.findOne(id);
	}

}
