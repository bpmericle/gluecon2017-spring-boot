package com.wistful.widgets.api.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Widget implements Serializable {
	private static final long serialVersionUID = -2107197233933919667L;

	@Id
	private String id;
	
	private String name;
	private String description;
	private String price;

	public Widget() {

	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param price
	 */
	public Widget(String name, String description, String price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Widget[id=%s, name='%s', description='%s', price='%s']", id, name, description, price);
	}
}
