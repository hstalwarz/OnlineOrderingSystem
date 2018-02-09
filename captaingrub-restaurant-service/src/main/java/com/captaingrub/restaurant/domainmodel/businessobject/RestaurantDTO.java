package com.captaingrub.restaurant.domainmodel.businessobject;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.captaingrub.restaurant.constants.RestaurantCategoryEnum;

/**
 * The Class RestaurantDTO captures the details of a restaurant.
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
	 * Instantiates a new restaurant DTO.
	 */
	public RestaurantDTO() {
		super();
	}

	/**
	 * Instantiates a new restaurant DTO.
	 *
	 * @param name the name
	 * @param address the address
	 * @param phone the phone
	 * @param averageRating the average rating
	 * @param category the category
	 * @param postalCode the postal code
	 */
	public RestaurantDTO(String name, String address, String phone, Double averageRating,
			RestaurantCategoryEnum category, Integer postalCode) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.averageRating = averageRating;
		this.category = category;
		this.postalCode = postalCode;
	}

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
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(this.name).append(this.phone)
				.append(this.category).append(this.address).append(this.averageRating)
				.append(this.postalCode).toHashCode();
	}
	
	@Override
	public boolean equals(final Object obj) {
		boolean isEqual = false;
		if (this == obj) {
			isEqual = true;
		} else if (obj != null && this.getClass() == obj.getClass()) {
			RestaurantDTO dto = (RestaurantDTO) obj;
			isEqual = new EqualsBuilder().append(this.getAddress(), dto.getAddress())
					.append(this.getAverageRating(), dto.getAverageRating())
					.append(this.getCategory(), dto.getCategory())
					.append(this.getName(), dto.getName())
					.append(this.getPhone(), dto.getPhone())
					.append(this.getPostalCode(), dto.getPostalCode()).isEquals();
		}
		return isEqual;
	}

	
}
