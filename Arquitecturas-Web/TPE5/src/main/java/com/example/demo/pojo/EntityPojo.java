package com.example.demo.pojo;

/**
 * The Interface EntityPojo. 
 * A common interface for all the entities
 *
 * @param <ID> the generic type
 */
public interface EntityPojo<ID> {
	
	/**
	 * Gets the entity's id.
	 *
	 * @return the entity's id
	 */
	public ID getID();
}
