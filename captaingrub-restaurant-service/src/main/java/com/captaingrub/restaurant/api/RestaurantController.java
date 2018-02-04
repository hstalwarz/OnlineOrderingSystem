package com.captaingrub.restaurant.api;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.captaingrub.restaurant.domainmodel.entity.Menu;
import com.captaingrub.restaurant.domainmodel.entity.MenuItem;
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
	@RequestMapping(method = RequestMethod.GET, value="/restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("restaurantId") final Long restaurantId) {
		return new ResponseEntity<>(restaurantService.getRestaurantById(restaurantId), HttpStatus.OK);
	}
	
	/**
	 * Gets the restaurant by postal code.
	 *
	 * @param postalCode the postal code
	 * @return the restaurant by postal code
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/restaurant/location/{postalCode}")
	public ResponseEntity<Set<Restaurant>> getRestaurantByPostalCode(
			@PathVariable("postalCode") final Integer postalCode) {
		return new ResponseEntity<>(restaurantService.getRestaurantByPostalCode(postalCode), HttpStatus.OK);
	}
	
	/**
	 * Gets the menu by restaurant id.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @return the menu by restaurant id
	 */
	@RequestMapping(method = RequestMethod.GET, value={"/restaurant/{restaurantId}/menu/{menuId}", 
			"/restaurant/{restaurantId}/menu"})
	public ResponseEntity<Set<Menu>> getMenuByRestaurantId(@PathVariable("restaurantId") final Long restaurantId,
			@PathVariable Optional<Long> menuId) {
		return new ResponseEntity<>(restaurantService.getMenuByRestaurantId(restaurantId, menuId),
				HttpStatus.OK);
	}
	
	/**
	 * Gets the menu item.
	 *
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 * @return the menu item
	 */
	@RequestMapping(method = RequestMethod.GET, value={"/menu/{menuId}/item/{menuItemId}", 
			"/menu/{menuId}"})
	public ResponseEntity<Set<MenuItem>> getMenuItem(@PathVariable("menuId") final Long menuId, 
			@PathVariable Optional<Long> menuItemId) {
		return new ResponseEntity<>(restaurantService.getMenuItem(menuId, menuItemId),
		HttpStatus.OK);
	}
	
	
}
