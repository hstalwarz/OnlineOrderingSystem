package com.captaingrub.restaurant.domainmodel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Restaurant.
 */
@Entity
@Table(name = "restaurant")
public class Restaurant {
	
	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The name. */
	@Column(name = "name")
	private String name;
	
	/** The address. */
	@Column(name = "address")
	private String address;
	
	/** The phone. */
	@Column(name = "phone")
	private String phone;
	
	/** The average rating. */
	@Column(name = "average_rating")
	private Integer averageRating;
	
	/** The category. */
	@Column(name = "category")
	private String category;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	public Integer getAverageRating() {
		return averageRating;
	}

	/**
	 * Sets the average rating.
	 *
	 * @param averageRating the new average rating
	 */
	public void setAverageRating(Integer averageRating) {
		this.averageRating = averageRating;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
