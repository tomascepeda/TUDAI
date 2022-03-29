package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.ClientProduct;

/**
 * The Interface ClientProductRepository.
 */
@Repository
public interface ClientProductRepository extends JpaRepository<ClientProduct, Long> {

	/**
	 * Find by id client.
	 * 
	 * @brief Since the Client_Product table has a compound PK, a query was made
	 *        that searches only for the client PK
	 * @param idClient id del cliente a buscar
	 * @return the list
	 */
	@Query(value="SELECT cp FROM ClientProduct cp WHERE cp.id.idClient = :idClient ")
	List<ClientProduct> findByIdClient(@Param("idClient") Long idClient);
	
	/**
	 * Find by id product.
	 *
	 * @param idProduct products's id
	 * @return the list
	 */
	@Query(value="SELECT cp FROM ClientProduct cp WHERE cp.id.idProduct = :idProduct")
	List<ClientProduct> findByIdProduct(@Param("idProduct") Long idProduct);
	
	/**
	 * Find the amount of product bought by a client on a date.
	 *
	 * @param idClient the id client
	 * @param mydate the date
	 * @return the integer
	 * @brief 
	 */
	@Query(value=""
			+ "SELECT SUM(cp.cant) "
			+ "FROM ClientProduct cp "
			+ "WHERE cp.id.idClient = :idClient "
			+ "AND cp.date = :mydate "
			+ "GROUP BY (cp.id.idClient)")
	Integer findAmountBoughtProductsByDate(@Param("idClient") Long idClient, @Param("mydate") Date mydate);
	
	
}
