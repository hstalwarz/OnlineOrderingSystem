package com.captaingrub.restaurant.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captaingrub.restaurant.domainmodel.entity.Menu;
import com.captaingrub.restaurant.domainmodel.entity.MenuItem;
import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.domainmodel.repo.MenuItemRepository;
import com.captaingrub.restaurant.domainmodel.repo.MenuRepository;
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
	public Set<Menu> getMenuByRestaurantId(Long restaurantId, Optional<Long> menuId) {
		Set<Menu> result = null;
		if (!menuId.isPresent()) {
			result = this.menuRepository.findAllByRestaurantId(restaurantId);
		} else {
			result = new HashSet<>();
			result.add(this.menuRepository.findByRestaurantIdAndId(restaurantId, menuId.get()));
		}
		return result;
	}

	@Override
	public Set<Restaurant> getRestaurantByPostalCode(Integer postalCode) {
		return this.restaurantRepo.findAllByPostalCode(postalCode);
	}

	@Override
	public Set<MenuItem> getMenuItem(Long menuId, Optional<Long> menuItemId) {
		Set<MenuItem> result = null;
		if (!menuItemId.isPresent()) {
			result = this.menuItemRepository.findAllByMenuId(menuId);
		} else {
			result = new HashSet<>();
			result.add(this.menuItemRepository.findByMenuIdAndId(menuId, menuItemId.get()));
		}
		return result;
	}

}
