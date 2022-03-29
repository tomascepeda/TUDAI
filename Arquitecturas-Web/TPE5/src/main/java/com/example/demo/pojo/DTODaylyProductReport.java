package com.example.demo.pojo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The Class DTODaylyProductReport.
 */
public class DTODaylyProductReport {
	
	/** The date. */
	private Date date;
	
	/** The quantity sold. */
	private int quantitySold;
	
	/** The amount collected. */
	private int amountCollected;

	/**
	 * Instantiates a new DTO dayly product report.
	 */
	public DTODaylyProductReport() {
	}

	/**
	 * Instantiates a new DTO dayly product report.
	 *
	 * @param date the date
	 * @param quantitySold the quantity sold
	 * @param amountCollected the amount collected
	 */
	@SuppressWarnings({  "static-access" })
	public DTODaylyProductReport(String date, int quantitySold, int amountCollected) {
		super();
		if(date.length() < 10) {
			String []aux = date.split("-");
			date = aux[0];
			if(aux[1].length() < 2) {
				date += "-0"+aux[1];
			} else {
				date += "-"+aux[1];	
			}
			if(aux[2].length() < 2) {
				date += "-0"+aux[2];
			} else {
				date += "-"+aux[2];		
			}
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate lDate = LocalDate.parse(date, format);
		this.date =  new Date().from(lDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.quantitySold = quantitySold;
		this.amountCollected = amountCollected;
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
	}

	/**
	 * Gets the quantity sold.
	 *
	 * @return the quantity sold
	 */
	public int getQuantitySold() {
		return quantitySold;
	}

	/**
	 * Sets the quantity sold.
	 *
	 * @param quantitySold the new quantity sold
	 */
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	/**
	 * Gets the amount collected.
	 *
	 * @return the amount collected
	 */
	public int getAmountCollected() {
		return amountCollected;
	}

	/**
	 * Sets the amount collected.
	 *
	 * @param amountCollected the new amount collected
	 */
	public void setAmountCollected(int amountCollected) {
		this.amountCollected = amountCollected;
	}

}
