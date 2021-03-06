package com.captaingrub.restaurant.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captaingrub.restaurant.domainmodel.businessobject.MenuDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.MenuItemDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.RestaurantDTO;
import com.captaingrub.restaurant.domainmodel.entity.Menu;
import com.captaingrub.restaurant.domainmodel.entity.MenuItem;
import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.domainmodel.repo.MenuItemRepository;
import com.captaingrub.restaurant.domainmodel.repo.MenuRepository;
import com.captaingrub.restaurant.domainmodel.repo.RestaurantRepository;
import com.captaingrub.restaurant.service.IRestaurantService;

/**
 * The Class RestaurantServiceImpl is a concrete implementation of {@link IRestaurantService}.
 */
@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	/** The restaurant repo. */
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	/** The menu repository. */
	@Autowired
	private MenuRepository menuRepository;
	
	/** The menu item repository. */
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public Restaurant getRestaurantById(Long id) {
		return this.restaurantRepo.findOne(id);
	}
	
	@Override
	public Set<Restaurant> getRestaurantByPostalCode(Integer postalCode) {
		return this.restaurantRepo.findAllByPostalCode(postalCode);
	}
	
	@Override
	@Transactional
	public void addRestaurants(List<RestaurantDTO> newRestaurantDTOs) {
		List<Restaurant> newRestaurants = new ArrayList<>(newRestaurantDTOs.size());
		for (RestaurantDTO dto : newRestaurantDTOs) {
			// creating new Restaurant entities for each of the input DTOs
			Restaurant restaurant = new Restaurant();
			BeanUtils.copyProperties(dto, restaurant);
			newRestaurants.add(restaurant);
		}
		this.restaurantRepo.save(newRestaurants);
	}

	@Override
	public void deleteRestaurant(Long restaurantId) {
		this.restaurantRepo.delete(restaurantId);
	}

	@Override
	public Set<Menu> getMenuByRestaurantId(Long restaurantId, Optional<Long> menuId) {
		Set<Menu> result = null;
		if (!menuId.isPresent()) {
			// find all menus for a restaurant if menu ID is not present
			result = this.menuRepository.findAllByRestaurantId(restaurantId);
		} else {
			// find a specific menu for a restaurant if menu ID is present
			result = new HashSet<>();
			result.add(this.menuRepository.findByRestaurantIdAndId(restaurantId, menuId.get()));
		}
		return result;
	}

	@Override
	@Transactional
	public void addMenus(Long restaurantId, List<MenuDTO> newMenuDTOs) {
		// Future improvement: validate that we have an actual restaurant based on the ID
		Restaurant restaurant = this.restaurantRepo.findOne(restaurantId);
		List<Menu> newMenus = new ArrayList<>(newMenuDTOs.size());
		for (MenuDTO menuDTO : newMenuDTOs) {
			// Create new menu entities from each of the input DTOs
			Menu newMenu = new Menu();
			BeanUtils.copyProperties(menuDTO, newMenu);
			newMenu.setRestaurant(restaurant);
			newMenus.add(newMenu);
		}
		this.menuRepository.save(newMenus);
	}

	@Override
	@Transactional
	public void deleteMenu(Long restaurantId, Long menuId) {
		this.menuRepository.deleteByRestaurantIdAndId(restaurantId, menuId);
	}


	@Override
	public Set<MenuItem> getMenuItem(Long menuId, Optional<Long> menuItemId) {
		Set<MenuItem> result = null;
		if (!menuItemId.isPresent()) {
			// get all menu items for given menu ID if menu item ID is not present
			result = this.menuItemRepository.findAllByMenuId(menuId);
		} else {
			// get a specific menu item for a given menu ID
			result = new HashSet<>();
			result.add(this.menuItemRepository.findByMenuIdAndId(menuId, menuItemId.get()));
		}
		return result;
	}
	
	@Override
	@Transactional
	public void deleteMenuItem(Long restaurantId, Long menuId, Long menuItemId) {
		this.menuItemRepository.deleteByMenuIdAndId(menuId, menuItemId);
	}

	@Override
	@Transactional
	public void addMenuItems(Long restaurantId, Long menuId, List<MenuItemDTO> newMenuItemDTOs) {
		// Future improvement: validate that we have an actual menu
		Menu menu = this.menuRepository.findByRestaurantIdAndId(restaurantId, menuId);
		List<MenuItem> newMenuItems = new ArrayList<>(newMenuItemDTOs.size());
		for (MenuItemDTO menuItemDTO : newMenuItemDTOs) {
			// create a new MenuItem entity for each of the input menu items
			MenuItem newMenuItem = new MenuItem();
			BeanUtils.copyProperties(menuItemDTO, newMenuItem);
			newMenuItem.setMenu(menu);
			newMenuItems.add(newMenuItem);
		}
		this.menuItemRepository.save(newMenuItems);
		
	}

}
