package com.example.demo.service;

import java.util.Optional;

import com.example.demo.pagination.Pagination;
import com.example.demo.pojo.EntityPojo;

/**
 *  
 *
 * @param <Entity> the generic type
 * @param <ID> the generic type
 * @brief Interface that defines common methods for all Services.
 */ 
public interface BasicService<Entity extends EntityPojo<ID>, ID> {

	/**
	 * Find all entities.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the pagination instance
	 */
	Pagination<Entity> findAll(int page, int size);

	/**
	 * Find by entity's id.
	 *
	 * @param id the entity's id
	 * @return an optional that contains entity
	 */
	public Optional<Entity> findById(ID id);

	/**
	 * Save an entity.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean save(Entity o);

	/**
	 * Delete an entity.
	 *
	 * @param o the an entity.
	 * @return true, if successful
	 */
	public boolean delete(Entity o);
}
