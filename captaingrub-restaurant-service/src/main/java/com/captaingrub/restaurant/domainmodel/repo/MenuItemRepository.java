package com.captaingrub.restaurant.domainmodel.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.captaingrub.restaurant.domainmodel.entity.MenuItem;

/**
 * The Interface MenuItemRepository is the JPA repository to work with {@link MenuItem} objects.
 */
@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

	/**
	 * Find all by menu id.
	 *
	 * @param menuId the menu id
	 * @return the sets the
	 */
	Set<MenuItem> findAllByMenuId(Long menuId);

	/**
	 * Find by menu id and menu item id.
	 *
	 * @param menuId the menu id
	 * @param id the id
	 * @return the menu item
	 */
	MenuItem findByMenuIdAndId(Long menuId, Long id);

	/**
	 * Delete by menu id and menu item id.
	 *
	 * @param menuId the menu id
	 * @param menuItemId the menu item id
	 */
	void deleteByMenuIdAndId(Long menuId, Long menuItemId);


}
