package com.captaingrub.restaurant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.service.IRestaurantService;

/**
 * The Class RestaurantController.
 */
@RestController
public class RestaurantController {
	
	/** The restaurant service. */
	@Autowired
	private IRestaurantService restaurantService;
	
	/**
	 * Gets the restaurant by id.
	 *
	 * @param restaurantId the restaurant id
	 * @return the restaurant by id
	 */
	@RequestMapping(value="/restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("restaurantId") final Long restaurantId) {
		return new ResponseEntity<Restaurant>(restaurantService.getRestaurantById(restaurantId), HttpStatus.OK);
	}
	
}
