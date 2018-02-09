package com.captaingrub.restaurant.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.captaingrub.restaurant.constants.RestaurantCategoryEnum;
import com.captaingrub.restaurant.domainmodel.businessobject.MenuDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.MenuItemDTO;
import com.captaingrub.restaurant.domainmodel.businessobject.RestaurantDTO;
import com.captaingrub.restaurant.domainmodel.entity.Menu;
import com.captaingrub.restaurant.domainmodel.entity.MenuItem;
import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.domainmodel.repo.MenuItemRepository;
import com.captaingrub.restaurant.domainmodel.repo.MenuRepository;
import com.captaingrub.restaurant.domainmodel.repo.RestaurantRepository;
import com.captaingrub.restaurant.service.impl.RestaurantServiceImpl;

/**
 * The Class RestaurantServiceImplTest contains unit tests for {@link RestaurantServiceImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceImplTest {

	/** The restaurant service to be tested */
	@InjectMocks
	private RestaurantServiceImpl restaurantService;
	
	/** The restaurant repository mock. */
	@Mock
	private RestaurantRepository restaurantRepository;
	
	/** The menu repository mock. */
	@Mock
	private MenuRepository menuRepository;
	
	/** The menu item repository mock. */
	@Mock
	private MenuItemRepository menuItemRepository;
	
	/** An ArgumentCapture to capture methods parameters of type List<Restaurant> */
	@Captor
	ArgumentCaptor<List<Restaurant>> restaurantListCaptor;
	
	/** An ArgumentCapture to capture methods parameters of type List<Menu> */
	@Captor
	ArgumentCaptor<List<Menu>> menuListCaptor;
	
	/** An ArgumentCapture to capture methods parameters of type List<MenuItem> */
	@Captor
	ArgumentCaptor<List<MenuItem>> menuItemListCaptor;
	
	/**
	 * Test get restaurant by id.
	 *
	 * @return the restaurant by id
	 */
	@Test
	public void testGetRestaurantById() {
		Long restaurantId = 1L;
		Restaurant expectedInstance = new Restaurant();
		expectedInstance.setId(restaurantId);
		Mockito.when(this.restaurantRepository.findOne(Mockito.anyLong())).thenReturn(expectedInstance);
		// invoke method under test
		Restaurant actualInstance = restaurantService.getRestaurantById(restaurantId);
		Mockito.verify(this.restaurantRepository, Mockito.times(1)).findOne(restaurantId);
		MatcherAssert.assertThat(actualInstance.getId(), Matchers.equalTo(restaurantId));
	}
	
	/**
	 * Test add restaurants.
	 */
	@Test
	public void testAddRestaurants() {
		List<RestaurantDTO> restaurantsToAdd = new ArrayList<>();
		RestaurantDTO restaurantToAdd = new RestaurantDTO("test", "address", "phone", 3.5, 
				RestaurantCategoryEnum.DINING, 98105);
		restaurantsToAdd.add(restaurantToAdd);
		// invoke method under test
		this.restaurantService.addRestaurants(restaurantsToAdd);
		Mockito.verify(this.restaurantRepository, Mockito.times(1)).save(this.restaurantListCaptor.capture());
		List<Restaurant> restaurantsAdded = this.restaurantListCaptor.getValue();
		MatcherAssert.assertThat(restaurantsAdded.size(), Matchers.equalTo(restaurantsToAdd.size()));
		MatcherAssert.assertThat(restaurantsAdded.get(0).getName(), Matchers.equalTo(restaurantToAdd.getName()));
	}
	
	/**
	 * Test delete restaurant.
	 */
	@Test
	public void testDeleteRestaurant() {
		Long idToDelete = 1L;
		// invoke method under test
		this.restaurantService.deleteRestaurant(idToDelete);
		Mockito.verify(this.restaurantRepository, Mockito.times(1)).delete(idToDelete);
	}
	
	/**
	 * Test get menu by restaurant id.
	 */
	@Test
	public void testGetMenuByRestaurantId() {
		Long restaurantId = 1L;
		Long menuId = 2L;
		String menuName = "Cakes";
		Optional<Long> menuOptional = Optional.of(menuId);
		Set<Menu> expectedMenuSet = new HashSet<>();
		Menu expectedInstance = new Menu();
		expectedInstance.setId(menuId);
		expectedInstance.setName(menuName);
		expectedMenuSet.add(expectedInstance);
		Mockito.when(this.menuRepository.findByRestaurantIdAndId(restaurantId, menuId)).thenReturn(expectedInstance);
		Mockito.when(this.menuRepository.findAllByRestaurantId(restaurantId)).thenReturn(expectedMenuSet);
		// invoke method under test for specific menu ID
		Set<Menu> actualMenus = restaurantService.getMenuByRestaurantId(restaurantId, menuOptional);
		Mockito.verify(this.menuRepository, Mockito.times(1)).findByRestaurantIdAndId(restaurantId, menuId);
		MatcherAssert.assertThat(actualMenus.iterator().next().getId(), Matchers.equalTo(menuId));
		// invoke method under test without a specific menu ID
		menuOptional = Optional.empty();
		actualMenus = restaurantService.getMenuByRestaurantId(restaurantId, menuOptional);
		Mockito.verify(this.menuRepository, Mockito.times(1)).findAllByRestaurantId(restaurantId);
		MatcherAssert.assertThat(actualMenus.iterator().next().getId(), Matchers.equalTo(menuId));
	}
	
	/**
	 * Test add menus.
	 */
	@Test
	public void testAddMenus() {
		Long restaurantId = 1L;
		String menuName = "Cakes";
		List<MenuDTO> menusToAdd = new ArrayList<>();
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setName(menuName);
		menusToAdd.add(menuDTO);
		// invoke method under test
		this.restaurantService.addMenus(restaurantId, menusToAdd);
		Mockito.verify(this.menuRepository, Mockito.times(1)).save(this.menuListCaptor.capture());
		List<Menu> menusSaved = this.menuListCaptor.getValue();
		MatcherAssert.assertThat(menusSaved.size(), Matchers.equalTo(menusToAdd.size()));
		MatcherAssert.assertThat(menusSaved.get(0).getName(), Matchers.equalTo(menuName));
	}
	
	/**
	 * Test delete menu.
	 */
	@Test
	public void testDeleteMenu() {
		Long restaurantId = 1L;
		Long menuId = 2L;
		// invoke method under test
		this.restaurantService.deleteMenu(restaurantId, menuId);
		Mockito.verify(this.menuRepository, Mockito.times(1)).deleteByRestaurantIdAndId(restaurantId, menuId);
	}
	
	/**
	 * Test get menu by restaurant id.
	 */
	@Test
	public void testGetMenuItem() {
		Long menuId = 2L;
		Long menuItemId = 3L;
		String menuItemName = "Red Velvet";
		Optional<Long> menuItemIdOptional = Optional.of(menuItemId);
		Set<MenuItem> expectedMenuItemSet = new HashSet<>();
		MenuItem expectedInstance = new MenuItem();
		expectedInstance.setId(menuItemId);
		expectedInstance.setName(menuItemName);
		expectedMenuItemSet.add(expectedInstance);
		Mockito.when(this.menuItemRepository.findByMenuIdAndId(menuId, menuItemId)).thenReturn(expectedInstance);
		Mockito.when(this.menuItemRepository.findAllByMenuId(menuId)).thenReturn(expectedMenuItemSet);
		// invoke method under test for specific menu item ID
		Set<MenuItem> actualMenuItems = restaurantService.getMenuItem(menuId, menuItemIdOptional);
		Mockito.verify(this.menuItemRepository, Mockito.times(1)).findByMenuIdAndId(menuId, menuItemId);
		MatcherAssert.assertThat(actualMenuItems.iterator().next().getId(), Matchers.equalTo(menuItemId));
		// invoke method under test without a specific menu ID
		menuItemIdOptional = Optional.empty();
		actualMenuItems = restaurantService.getMenuItem(menuId, menuItemIdOptional);
		Mockito.verify(this.menuItemRepository, Mockito.times(1)).findAllByMenuId(menuId);
		MatcherAssert.assertThat(actualMenuItems.iterator().next().getId(), Matchers.equalTo(menuItemId));
	}
	
	/**
	 * Test delete menu item.
	 */
	@Test
	public void testDeleteMenuItem() {
		Long restaurantId = 1L;
		Long menuId = 2L;
		Long menuItemId = 3L;
		// invoke method under test
		this.restaurantService.deleteMenuItem(restaurantId, menuId, menuItemId);
		Mockito.verify(this.menuItemRepository, Mockito.times(1)).deleteByMenuIdAndId(menuId, menuItemId);
	}
	
	/**
	 * Test add menu items.
	 */
	@Test
	public void testAddMenuItems() {
		Long restaurantId = 1L;
		Long menuId = 2L;
		String menuItemName = "Red Velvet";
		List<MenuItemDTO> menuItemsToAdd = new ArrayList<>();
		MenuItemDTO menuItemDTO = new MenuItemDTO();
		menuItemDTO.setName(menuItemName);
		menuItemsToAdd.add(menuItemDTO);
		// invoke method under test
		this.restaurantService.addMenuItems(restaurantId, menuId, menuItemsToAdd);
		Mockito.verify(this.menuItemRepository, Mockito.times(1)).save(this.menuItemListCaptor.capture());
		List<MenuItem> menuItemsSaved = this.menuItemListCaptor.getValue();
		MatcherAssert.assertThat(menuItemsSaved.size(), Matchers.equalTo(menuItemsToAdd.size()));
		MatcherAssert.assertThat(menuItemsSaved.get(0).getName(), Matchers.equalTo(menuItemName));
	}
}
