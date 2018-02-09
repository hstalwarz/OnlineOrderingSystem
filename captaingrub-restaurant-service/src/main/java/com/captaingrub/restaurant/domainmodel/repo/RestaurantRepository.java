package com.captaingrub.restaurant.domainmodel.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.captaingrub.restaurant.domainmodel.entity.Restaurant;

/**
 * The Interface RestaurantRepository is the JPA repository to work with {@link Restaurant} objects.
 */
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

	/**
	 * Find all restaurants by postal code.
	 *
	 * @param postalCode the postal code
	 * @return the sets the
	 */
	Set<Restaurant> findAllByPostalCode(Integer postalCode);

}
