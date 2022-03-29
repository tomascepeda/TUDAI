package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * The Class ClientProductId.
 *  The embeddable id for ClientProduct
 */
@Embeddable
public class ClientProductId implements Serializable{

	/**
	 * To string.
	 *
	 * @return the entity as a string
	 */
	@Override
	public String toString() {
		return "ClientProductId [idProduct=" + idProduct + ", idClient=" + idClient + ", date=" + date + "]";
	}


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8825738415373631317L;
	
	/** The id product. */
	@Column(name = "id_product")
	private Long idProduct;
	
	/** The id client. */
	@Column(name = "id_client")
	private Long idClient;
	
	/** The date. */
	@Column(name = "id_date")
	private Long date;


	/**
	 * Instantiates a new client product id.
	 */
	public ClientProductId() {}

	/**
	 * Instantiates a new client product id.
	 *
	 * @param idProduct the id product
	 * @param idClient the id client
	 * @param date the date
	 */
	public ClientProductId(Long idProduct, Long idClient, Long date) {
		super();
		this.idProduct = idProduct;
		this.idClient = idClient;
		this.date = date;
	}


	/**
	 * Gets the id product.
	 *
	 * @return the id product
	 */
	public Long getIdProduct() {
		return idProduct;
	}


	/**
	 * Sets the id product.
	 *
	 * @param idProduct the new id product
	 */
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}


	/**
	 * Gets the id client.
	 *
	 * @return the id client
	 */
	public Long getIdClient() {
		return idClient;
	}


	/**
	 * Sets the id client.
	 *
	 * @param idClient the new id client
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Long getDate() {
		return date;
	}


	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Long date) {
		this.date = date;
	}



	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(date, idClient, idProduct);
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
		ClientProductId other = (ClientProductId) obj;
		return Objects.equals(date, other.date) && Objects.equals(idClient, other.idClient)
				&& Objects.equals(idProduct, other.idProduct);
	}
}
