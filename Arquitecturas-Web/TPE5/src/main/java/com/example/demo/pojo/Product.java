package com.example.demo.pojo;

import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Product.
 */
@Entity
public class Product implements EntityPojo<Long>{

	/**
	 * To string.
	 *
	 * @return the entity as a string
	 */
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", price="
				+ price + ", stock=" + stock + "]";
	}

	/** The id product. */
	@Id
	@Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("idProduct")
	private Long idProduct;
	
	/** The name. */
	@Column(nullable = false)
	private String name;
	
	/** The description. */
	@Column(nullable = false)
	private String description;
	
	/** The price. */
	@Column(nullable = false)
	private int price;
	
	/** The stock. */
	@Column(nullable = false)
	private int stock;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 * @param description the description
	 * @param price the price
	 * @param stock the stock
	 */
	public Product(String name, String description, int price, int stock) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public Long getID() {
		return idProduct;
	}

	/**
	 * Gets the sets the id product.
	 *
	 * @param idProduct the id product
	 * @return the sets the id product
	 */
	public Long setIdProduct(Long idProduct) {
		return this.idProduct = idProduct;
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
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock the new stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(idProduct, other.idProduct);
	}

}
