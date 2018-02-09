package com.captaingrub.restaurant.api;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.captaingrub.restaurant.domainmodel.businessobject.MenuDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.MenuItemDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.RestaurantDTO;
import com.captaingrub.restaurant.domainmodel.entity.Menu;
import com.captaingrub.restaurant.domainmodel.entity.MenuItem;
import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.service.IRestaurantService;

/**
 * The Class RestaurantController contains REST end points for Captain Grub, the Online Ordering System,
 * including those for restaurants, their menus and menu items.
 */
@RestController
public class RestaurantController {
	
	/** The restaurant service reference */
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
	 * @return the restaurants by postal code
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/restaurant/location/{postalCode}")
	public ResponseEntity<Set<Restaurant>> getRestaurantByPostalCode(
			@PathVariable("postalCode") final Integer postalCode) {
		return new ResponseEntity<>(restaurantService.getRestaurantByPostalCode(postalCode), HttpStatus.OK);
	}
	
	/**
	 * Adds new restaurants.
	 *
	 * @param newRestaurants the new restaurants
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/restaurant")
	public ResponseEntity<Void> addRestaurants(@RequestBody final List<RestaurantDTO> newRestaurants) {
		this.restaurantService.addRestaurants(newRestaurants);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Deletes restaurant by ID.
	 *
	 * @param restaurantId the restaurant id
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurant/{restaurantId}")
	public ResponseEntity<Void> deleteRestaurantById(@PathVariable("restaurantId") final Long restaurantId) {
		this.restaurantService.deleteRestaurant(restaurantId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Gets the menu by restaurant ID, with an optional menu ID parameter. If the optional parameter is not passed
	 * the end point returns all the menus for the given restaurant ID.
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
	 * Adds new menus for a given restaurant ID.
	 *
	 * @param restaurantId the restaurant id
	 * @param newMenus the new menus
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/restaurant/{restaurantId}/menu")
	public ResponseEntity<Void> addMenus(@PathVariable("restaurantId") final Long restaurantId,
			@RequestBody final List<MenuDTO> newMenus) {
		this.restaurantService.addMenus(restaurantId, newMenus);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Deletes a menu for a given restaurant ID and menu ID.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurant/{restaurantId}/menu/{menuId}")
	public ResponseEntity<Void> deleteMenu(@PathVariable("restaurantId") final Long restaurantId,
			@PathVariable("menuId") final Long menuId) {
		this.restaurantService.deleteMenu(restaurantId, menuId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Gets the menu items for a given menu ID. An optional path variable menuItemId, if present returns
	 * only the specific menu item associated with the ID.
	 *
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 * @return the menu item(s)
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/menu/{menuId}/item/{menuItemId}", 
			"/menu/{menuId}"})
	public ResponseEntity<Set<MenuItem>> getMenuItem(@PathVariable("menuId") final Long menuId, 
			@PathVariable Optional<Long> menuItemId) {
		return new ResponseEntity<>(restaurantService.getMenuItem(menuId, menuItemId),
		HttpStatus.OK);
	}
	
	/**
	 * Adds new menu items for a given restaurant ID and menu ID.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @param newMenuItems the new menu items
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/restaurant/{restaurantId}/menu/{menuId}/menuItem")
	public ResponseEntity<Void> addMenuItems(@PathVariable("restaurantId") final Long restaurantId,
			@PathVariable("menuId") final Long menuId,
			@RequestBody final List<MenuItemDTO> newMenuItems) {
		this.restaurantService.addMenuItems(restaurantId, menuId, newMenuItems);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Deletes the menu item for a given restaurant ID, menu ID and menu item ID.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurant/{restaurantId}/menu/{menuId}"
			+ "/menuItem/{menuItemId}")
	public ResponseEntity<Void> deleteMenuItem(@PathVariable("restaurantId") final Long restaurantId,
			@PathVariable("menuId") final Long menuId, @PathVariable("menuItemId") final Long menuItemId) {
		this.restaurantService.deleteMenuItem(restaurantId, menuId, menuItemId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
