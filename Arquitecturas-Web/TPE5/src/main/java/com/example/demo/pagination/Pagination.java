package com.example.demo.pagination;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Pagination.
 *
 * @param <T> the generic type
 */
// Una implementación de un paginado
public class Pagination<T> {
	
	/** The elements. */
	private List<T> elements;
	
	/** The page number. */
	private int page;
	
	/** The page size. */
	private int size;
	
	/** The prev page. */
	private int prev;
	
	/** The next page. */
	private int next;
	
	/** The max page. */
	private int maxPage;

	/**
	 * Instantiates a new pagination.
	 *
	 * @param elements the elements
	 * @param page the number page
	 * @param size the size page
	 * @param prev the prev page
	 * @param next the next page
	 * @param maxPage the max page
	 */
	public Pagination(List<T> elements, int page, int size, int prev, int next, int maxPage) {
		super();
		this.elements = elements;
		this.page = page;
		this.size = size;
		this.prev = prev;
		this.next = next;
		this.maxPage = maxPage;
	}

	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public List<T> getElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements the new elements
	 */
	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page number
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page number
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the page size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the prev page.
	 *
	 * @return the prev page
	 */
	public int getPrev() {
		return prev;
	}

	/**
	 * Sets the prev page.
	 *
	 * @param prev the new prev page
	 */
	public void setPrev(int prev) {
		this.prev = prev;
	}

	/**
	 * Gets the next page.
	 *
	 * @return the next page
	 */
	public int getNext() {
		return next;
	}

	/**
	 * Sets the next page.
	 *
	 * @param next the new next page
	 */
	public void setNext(int next) {
		this.next = next;
	}

	/**
	 * Gets the max page number.
	 *
	 * @return the max page number
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/**
	 * Sets the max page number.
	 *
	 * @param maxPage the new max page number
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
