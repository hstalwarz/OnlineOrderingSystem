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
 * The Interface IRestaurantService declares the service layer contracts for functionalities associated with
 * restaurants, menus and menu items.
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
	 * Adds new restaurants.
	 *
	 * @param newRestaurants the new restaurants
	 */
	void addRestaurants(List<RestaurantDTO> newRestaurants);

	/**
	 * Deletes a restaurant by its ID.
	 *
	 * @param restaurantId the restaurant id
	 */
	void deleteRestaurant(Long restaurantId);

	/**
	 * Gets all menus by restaurant id or a specific menu with an optional menuId.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @return the menu by restaurant id
	 */
	Set<Menu> getMenuByRestaurantId(Long restaurantId, Optional<Long> menuId);

	/**
	 * Gets all menu items by a menu ID or a specific menu item with an optional menuItemID
	 *
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 * @return the menu item
	 */
	Set<MenuItem> getMenuItem(Long menuId, Optional<Long> menuItemId);

	/**
	 * Adds new menus.
	 *
	 * @param restaurantId the restaurant id
	 * @param newMenus the new menus
	 */
	void addMenus(Long restaurantId, List<MenuDTO> newMenus);

	/**
	 * Deletes a menu based on the restaurantId and the menuId.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 */
	void deleteMenu(Long restaurantId, Long menuId);

	/**
	 * Deletes a menu item based on the restaurant ID, menu ID and menu item ID.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 */
	void deleteMenuItem(Long restaurantId, Long menuId, Long menuItemId);

	/**
	 * Adds new menu items for a specific restaurant ID and menu ID.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @param newMenuItems the new menu items
	 */
	void addMenuItems(Long restaurantId, Long menuId, List<MenuItemDTO> newMenuItems);
	
}
