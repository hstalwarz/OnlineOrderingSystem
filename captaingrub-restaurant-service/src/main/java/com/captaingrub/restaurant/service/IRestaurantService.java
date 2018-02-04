package com.captaingrub.restaurant.service;

import java.util.Optional;
import java.util.Set;

import com.captaingrub.restaurant.domainmodel.entity.Menu;
import com.captaingrub.restaurant.domainmodel.entity.MenuItem;
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

	/**
	 * Gets the menu by restaurant id.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @return the menu by restaurant id
	 */
	Set<Menu> getMenuByRestaurantId(Long restaurantId, Optional<Long> menuId);

	/**
	 * Gets the restaurant by postal code.
	 *
	 * @param postalCode the postal code
	 * @return the restaurant by postal code
	 */
	Set<Restaurant> getRestaurantByPostalCode(Integer postalCode);

	/**
	 * Gets the menu item.
	 *
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 * @return the menu item
	 */
	Set<MenuItem> getMenuItem(Long menuId, Optional<Long> menuItemId);
	
}
