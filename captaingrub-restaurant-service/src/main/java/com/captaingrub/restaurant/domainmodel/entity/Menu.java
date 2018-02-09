package com.captaingrub.restaurant.domainmodel.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Menu is the restaurant menu entity mapped to the database.
 */
@Entity
@Table(name = "menu")
public class Menu {
	
	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The name. */
	@Column(name = "name")
	private String name;
	
	/** The description. */
	@Column(name = "description")
	private String description;
	
	/** The restaurant. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	@JsonIgnore
	private Restaurant restaurant;
	
	/** The menu items. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<MenuItem> menuItems = new HashSet<>();

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

	/**
	 * Gets the menu items.
	 *
	 * @return the menu items
	 */
	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	/**
	 * Sets the menu items.
	 *
	 * @param menuItems the new menu items
	 */
	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
}
