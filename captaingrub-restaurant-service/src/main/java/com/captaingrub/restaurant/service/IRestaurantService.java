package com.captaingrub.restaurant.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.captaingrub.restaurant.domainmodel.businessobject.MenuDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.MenuItemDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.RestaurantDTO;
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
	 * Gets the restaurant by postal code.
	 *
	 * @param postalCode the postal code
	 * @return the restaurant by postal code
	 */
	Set<Restaurant> getRestaurantByPostalCode(Integer postalCode);
	
	/**
	 * Adds the restaurants.
	 *
	 * @param newRestaurants the new restaurants
	 */
	void addRestaurants(List<RestaurantDTO> newRestaurants);

	/**
	 * Delete restaurant.
	 *
	 * @param restaurantId the restaurant id
	 */
	void deleteRestaurant(Long restaurantId);

	/**
	 * Gets the menu by restaurant id.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @return the menu by restaurant id
	 */
	Set<Menu> getMenuByRestaurantId(Long restaurantId, Optional<Long> menuId);

	/**
	 * Gets the menu item.
	 *
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 * @return the menu item
	 */
	Set<MenuItem> getMenuItem(Long menuId, Optional<Long> menuItemId);

	/**
	 * Adds the menus.
	 *
	 * @param restaurantId the restaurant id
	 * @param newMenus the new menus
	 */
	void addMenus(Long restaurantId, List<MenuDTO> newMenus);

	/**
	 * Delete menu.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 */
	void deleteMenu(Long restaurantId, Long menuId);

	/**
	 * Delete menu item.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 */
	void deleteMenuItem(Long restaurantId, Long menuId, Long menuItemId);

	/**
	 * Adds the menu items.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @param newMenuItems the new menu items
	 */
	void addMenuItems(Long restaurantId, Long menuId, List<MenuItemDTO> newMenuItems);
	
}
