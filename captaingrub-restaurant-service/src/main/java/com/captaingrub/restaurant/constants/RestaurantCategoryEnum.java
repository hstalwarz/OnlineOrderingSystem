package com.captaingrub.restaurant.constants;

/**
 * The Enum RestaurantCategoryEnum.
 */
public enum RestaurantCategoryEnum {
	
	/** The cafe. */
	CAFE("Cafe"),
	
	/** The dining. */
	DINING("Dining"),
	
	/** The bakery. */
	BAKERY("Bakery"),
	
	/** The fast food. */
	FAST_FOOD("Fast Food");
	
	/** The category. */
	private String category;
	
	/**
	 * Instantiates a new restaurant category enum.
	 *
	 * @param category the category
	 */
	private RestaurantCategoryEnum(String category) {
		this.category = category;
	}
	
	/**
	 * Gets the response category.
	 *
	 * @return the response category
	 */
	public String getResponseCategory() {
		return this.category;
	}

}
