package com.captaingrub.restaurant.domainmodel.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.captaingrub.restaurant.domainmodel.entity.Menu;

/**
 * The Interface MenuRepository is the JPA repository to work {@link Menu} objects.
 */
@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

	/**
	 * Find all by restaurant id.
	 *
	 * @param restaurantId the restaurant id
	 * @return the sets the
	 */
	Set<Menu> findAllByRestaurantId(Long restaurantId);

	/**
	 * Find by restaurant id and menu id.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 * @return the menu
	 */
	Menu findByRestaurantIdAndId(Long restaurantId, Long menuId);

	/**
	 * Delete by restaurant id and menu id.
	 *
	 * @param restaurantId the restaurant id
	 * @param menuId the menu id
	 */
	void deleteByRestaurantIdAndId(Long restaurantId, Long menuId);


}
