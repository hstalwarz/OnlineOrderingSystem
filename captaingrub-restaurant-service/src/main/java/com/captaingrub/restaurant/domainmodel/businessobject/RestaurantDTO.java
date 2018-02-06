package com.captaingrub.restaurant.domainmodel.businessobject;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.captaingrub.restaurant.constants.RestaurantCategoryEnum;

/**
 * The Class RestaurantDTO.
 */
public class RestaurantDTO {
	
	/** The name. */
	private String name;
	
	/** The address. */
	private String address;
	
	/** The phone. */
	private String phone;
	
	/** The average rating. */
	private Double averageRating;
	
	/** The category. */
	private RestaurantCategoryEnum category;
	
	/** The postal code. */
	private Integer postalCode;

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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the average rating.
	 *
	 * @return the average rating
	 */
	public Double getAverageRating() {
		return averageRating;
	}

	/**
	 * Sets the average rating.
	 *
	 * @param averageRating the new average rating
	 */
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public RestaurantCategoryEnum getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(RestaurantCategoryEnum category) {
		this.category = category;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public Integer getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
}
