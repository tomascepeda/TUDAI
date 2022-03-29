
package com.example.demo.pojo;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.*;

/**
 * The Class ClientProduct.
 */
@Entity
@Table(name = "client_product")
public class ClientProduct implements EntityPojo<ClientProductId>{
    
    /** The sale's id. */
    @EmbeddedId
    private ClientProductId id;
    
    /** The sale's product. */
    @ManyToOne()
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
	private Product product;
    
    /** The sale's client. */
    @ManyToOne()
    @MapsId("idClient")
    @JoinColumn(name = "id_client")
	private Client client;
	
	/** The sale's date. */
	@Column(nullable = false)
	private Date date;
	
	/** The sale's cant. */
	@Column(nullable = true)
	private int cant;

	/**
	 * Instantiates a new client product.
	 */
	public ClientProduct() {this.id =  new ClientProductId();}

	/**
	 * Instantiates a new ClientProduct.
	 *
	 * @param product the product
	 * @param client the client
	 * @param date the date
	 * @param cant the cant
	 */
	public ClientProduct(Product product, Client client, Date date, int cant) {
		super();
		this.product = product;
		this.client = client;
		this.date = Date.from(date.toInstant().truncatedTo( ChronoUnit.DAYS ));
		this.cant = cant;
		this.id =  new ClientProductId(product.getID(), client.getID(), date.getTime());
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public ClientProductId getID() {
		return this.id;
	}
	
	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(Product product) {
		this.id.setIdProduct(product.getID());
		this.product = product;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	public void setClient(Client client) {
		this.id.setIdClient(client.getID());
		this.client = client;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
		this.date = Date.from(date.toInstant().truncatedTo( ChronoUnit.DAYS ));
		this.id.setDate(date.getTime());
	}

	/**
	 * Gets the cant.
	 *
	 * @return the cant
	 */
	public int getCant() {
		return cant;
	}

	/**
	 * Sets the cant.
	 *
	 * @param cant the new cant
	 */
	public void setCant(int cant) {
		this.cant = cant;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ClientProduct [id=" + id + ", product=" + product + ", client=" + client + ", date=" + date + ", cant="
				+ cant + "]";
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
		ClientProduct other = (ClientProduct) obj;
		return id.equals(other.id);
	}
	
	
}
