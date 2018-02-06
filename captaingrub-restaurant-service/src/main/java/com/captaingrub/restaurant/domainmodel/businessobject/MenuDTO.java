package com.captaingrub.restaurant.domainmodel.businessobject;

import com.captaingrub.restaurant.domainmodel.entity.Restaurant;

/**
 * The Class MenuDTO.
 */
public class MenuDTO {
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The restaurant. */
	private Restaurant restaurant;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the restaurant.
	 *
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * Sets the restaurant.
	 *
	 * @param restaurant the new restaurant
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
