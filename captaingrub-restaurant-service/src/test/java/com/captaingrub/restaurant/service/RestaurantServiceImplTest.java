package com.captaingrub.restaurant.service;

import java.util.ArrayList;
import java.util.List;

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
import com.captaingrub.restaurant.domainmodel.businessobject.RestaurantDTO;
import com.captaingrub.restaurant.domainmodel.entity.Restaurant;
import com.captaingrub.restaurant.domainmodel.repo.MenuItemRepository;
import com.captaingrub.restaurant.domainmodel.repo.MenuRepository;
import com.captaingrub.restaurant.domainmodel.repo.RestaurantRepository;
import com.captaingrub.restaurant.service.impl.RestaurantServiceImpl;

/**
 * The Class RestaurantServiceImplTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceImplTest {

	@InjectMocks
	private RestaurantServiceImpl restaurantService;
	
	/** The restaurant repo. */
	@Mock
	private RestaurantRepository restaurantRepo;
	
	/** The menu repository. */
	@Mock
	private MenuRepository menuRepository;
	
	/** The menu item repository. */
	@Mock
	private MenuItemRepository menuItemRepository;
	
	/** The restaurant list captor. */
	@Captor
	ArgumentCaptor<List<Restaurant>> restaurantListCaptor;
	
	/**
	 * Gets the restaurant by id.
	 *
	 * @return the restaurant by id
	 */
	@Test
	public void testGetRestaurantById() {
		Long restaurantId = 1L;
		Restaurant expectedInstance = new Restaurant();
		expectedInstance.setId(restaurantId);
		Mockito.when(this.restaurantRepo.findOne(Mockito.anyLong())).thenReturn(expectedInstance);
		// invoke method under test
		Restaurant actualInstance = restaurantService.getRestaurantById(restaurantId);
		Mockito.verify(this.restaurantRepo, Mockito.times(1)).findOne(restaurantId);
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
		Mockito.verify(this.restaurantRepo, Mockito.times(1)).save(this.restaurantListCaptor.capture());
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
		Mockito.verify(this.restaurantRepo, Mockito.times(1)).delete(idToDelete);
	}
}
