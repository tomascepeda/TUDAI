package com.example.demo.pojo;

import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Client.
 */
@Entity
public class Client implements EntityPojo<Long>{

	/** The id client. */
	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("idClient")
	private Long idClient;

	/** The client's name. */
	@Column(nullable = false)
	private String name;

	/**
	 * Instantiates a new client.
	 */
	public Client() {
	}

	/**
	 * Instantiates a new client.
	 *
	 * @param idClient the id client
	 * @param name the client's name
	 */
	public Client(Long idClient, String name) {
		super();
		this.idClient = idClient;
		this.name = name;
	}
	
	/**
	 * Gets the client's id.
	 *
	 * @return the client's id
	 */
	@Override
	public Long getID() {
		return idClient;
	}

	/**
	 * Gets the client's name.
	 *
	 * @return the client's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the client's name.
	 *
	 * @param name the new client's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * To string.
	 *
	 * @return the client as a string
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + "]";
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(idClient, other.idClient);
	}

}
