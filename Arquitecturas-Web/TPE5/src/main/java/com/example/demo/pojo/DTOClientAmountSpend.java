package com.example.demo.pojo;

/**
 * The Class DTOClientAmountSpend.
 */
public class DTOClientAmountSpend {

	/** The client. */
	private Client client;
	
	/** The amount spend. */
	private int amountSpend;

	/**
	 * Instantiates a new DTO client amount spend.
	 */
	public DTOClientAmountSpend() {
	}

	/**
	 * Instantiates a new DTO client amount spend.
	 *
	 * @param client the client
	 * @param amountSpend the amount spend
	 */
	public DTOClientAmountSpend(Client client, int amountSpend) {
		super();
		this.client = client;
		this.amountSpend = amountSpend;
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
		this.client = client;
	}

	/**
	 * Gets the amount spend.
	 *
	 * @return the amount spend
	 */
	public int getAmountSpend() {
		return amountSpend;
	}

	/**
	 * Sets the amount spend.
	 *
	 * @param amountSpend the new amount spend
	 */
	public void setAmountSpend(int amountSpend) {
		this.amountSpend = amountSpend;
	}

}
