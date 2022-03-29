package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.DTODaylyProductReport;
import com.example.demo.pojo.Product;

/**
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/**
	 * Gets a report of sales ordered by date.
	 *
	 * @brief In this query, the report of the products sold per day is obtained,
	 *        detailing the date the number of products sold, and the amount
	 *        collected, saving the information in a DTO
	 * @param limit the limit
	 * @return the product select by date
	 */
	@Query(value =""
			+ "SELECT  new com.example.demo.pojo.DTODaylyProductReport(CONCAT(CONCAT(CONCAT(EXTRACT(YEAR FROM cp.date), '-'), EXTRACT(MONTH FROM cp.date)), CONCAT('-', EXTRACT(DAY FROM cp.date))), CAST(COUNT(p) AS int), CAST(SUM(cp.cant * p.price) AS int)) "
			+ "FROM ClientProduct cp, Product p "
			+ "WHERE cp.product.idProduct = p.idProduct "
			+ "GROUP BY CONCAT(CONCAT(CONCAT(EXTRACT(YEAR FROM cp.date), '-'), EXTRACT(MONTH FROM cp.date)), CONCAT('-', EXTRACT(DAY FROM cp.date))) "
			+ "ORDER BY CONCAT(CONCAT(CONCAT(EXTRACT(YEAR FROM cp.date), '-'), EXTRACT(MONTH FROM cp.date)), CONCAT('-', EXTRACT(DAY FROM cp.date)))")
	public Page<DTODaylyProductReport> getProductSelectByDate(PageRequest limit);
	
	/**
	 * Gets the most selled product.
	 *
	 * @brief The customer product and product tables are consulted, the result
	 *        obtained is shown by ordering the products from highest to lowest
	 *        according to the quantity sold that product
	 * @param limit the limit
	 * @return the most selled product
	 */ 
	@Query(value =""
			+ "SELECT SUM(cp.cant), p "
			+ "FROM ClientProduct cp, Product p "
			+ "WHERE cp.product.idProduct = p.idProduct "
			+ "GROUP BY (p, p.description) "
			+ "ORDER BY SUM(cp.cant) DESC")
	public Object[] getMostSelledProduct(PageRequest limit);

}
