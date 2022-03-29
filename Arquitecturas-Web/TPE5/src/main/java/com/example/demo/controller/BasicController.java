package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.pagination.Pagination;


/**
 *  
 * @brief Interface that defines common methods for all controllers. 
 *
 * @param <T> the generic type for an entity
 */ 
public interface BasicController<T> {


	/**
	 * Gets the all the entities.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the all
	 */
	ResponseEntity<Pagination<T>> getAll(int page, int size);

	/**
	 * Gets a entity by id.
	 *
	 * @param id the entity id
	 * @return the by id
	 */
	public ResponseEntity<T> getById(Long id);

	/**
	 * Save an entity.
	 *
	 * @param c the entity
	 * @return the response entity
	 */
	public ResponseEntity<T> save(T o);

	/**
	 * Delete an entity.
	 *
	 * @param id the entity id
	 * @return the response entity
	 */
	public ResponseEntity<T> delete(Long id);

	/**
	 * Update an entity.
	 *
	 * @param o the entity
	 * @return the response entity
	 */
	public ResponseEntity<T> update(T o);

}
