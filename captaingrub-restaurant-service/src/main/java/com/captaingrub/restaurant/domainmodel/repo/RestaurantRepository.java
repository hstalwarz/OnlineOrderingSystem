package com.captaingrub.restaurant.domainmodel.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.captaingrub.restaurant.domainmodel.entity.Restaurant;

/**
 * The Interface RestaurantRepository.
 */
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {


}
