package com.captaingrub.restaurant.domainmodel.businessobject;

/**
 * The Class MenuItem.
 */
public class MenuItemDTO {
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The price. */
	private Double price;
	
	/** The menu. */
	private MenuDTO menu;

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
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public MenuDTO getMenu() {
		return menu;
	}

	/**
	 * Sets the menu.
	 *
	 * @param menu the new menu
	 */
	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}
}
