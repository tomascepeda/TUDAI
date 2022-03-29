package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.*;

/**
 * The Interface ClientRepository.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	/**
	 * Gets the amount spend by client report.
	 *
	 * @brief This query selects all customers, along with what they spent, and a
	 *        DTO is instantiated to save that information
	 * @param of the of
	 * @return the amount spend by client report
	 */
	@Query(value =""
			+ "SELECT new com.example.demo.pojo.DTOClientAmountSpend(cp.client, CAST(SUM(cp.cant * p.price) AS int)) "
			+ "FROM ClientProduct cp, Client c, Product p "
			+ "WHERE "
			+ "		cp.client.idClient = c.idClient AND "
			+ "		cp.product.idProduct = p.idProduct "
			+ "GROUP BY (c.idClient) "
			+ "ORDER BY CAST(SUM(cp.cant * p.price) AS int) DESC")
	public Page<DTOClientAmountSpend> getAmountSpendByClientReport(PageRequest of);

}
