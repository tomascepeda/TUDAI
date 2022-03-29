package com.example.demo.testing;

import static org.junit.Assert.assertEquals; 

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.ClientProduct;
import com.example.demo.pojo.DTODaylyProductReport;
import com.example.demo.pojo.Product;
import com.example.demo.repository.ClientProductRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Class ProductRepositoryTest.
 */
@DisplayName("Test: Capa de repositorios - Product Repository")
public class ProductRepositoryTest extends RepositoryTest<Product, Long>  {

	/** The product repository. */
	@Autowired
	private ProductRepository pr;
	/** The client repository. */
	@Autowired
	private ClientRepository cr;
	/** The ClientProduct repository. */
	@Autowired
	private ClientProductRepository cpr;
	
	/**
	 * Sets the up.
	 */
	@Override
	public void setUp() {
		this.entities = List.of(
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 20, 1),
				new Product("Nombre", "Descripción", 20, 10));
		this.entity = getRandomEntity();
	}
	
	/**
	 * Tear down.
	 */
	@Override
	public void tearDown() {
		this.entities = null;
		this.getRespository().deleteAll();
	}

	/**
	 * Gets the respository.
	 *
	 * @return the respository
	 */
	@Override
	public JpaRepository<Product, Long> getRespository() {
		return this.pr;
	}

	@Test
	@DisplayName("Test: test para acciones de bajas por ID")
	public void testForGetProductSelectByDate() {
		Product p1 = pr.save(new Product("Nombre", "Descripción", 10, 1));
		Product p2 = pr.save(new Product("Nombre", "Descripción", 10, 1));
		Page<DTODaylyProductReport> result = this.pr.getProductSelectByDate(PageRequest.of(1, 1000));
		result.stream().forEach((p) ->
			assertEquals(p.getAmountCollected(), p1.getStock() * p1.getPrice() + p2.getStock() * p2.getPrice())
		);
	}
	
	@SuppressWarnings("deprecation")
	@DisplayName("Test: test para saber cuál fue el producto más vendido")
	@Test
	public void testForGetAmountSpendByClientReport() {
		Client c = cr.save(new Client(1L, "Juan"));
		List<Product> products = List.of(
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 20, 1),
				new Product("Nombre", "Descripción", 20, 10));
		List<ClientProduct> productsSelled = List.of(
				new ClientProduct(products.get(0), c, new Date(2021, 1, 1), products.get(0).getStock()),
				new ClientProduct(products.get(1), c, new Date(2021, 1, 1), products.get(1).getStock()),
				new ClientProduct(products.get(2), c, new Date(2021, 1, 1), products.get(2).getStock()),
				new ClientProduct(products.get(3), c, new Date(2021, 1, 1), products.get(3).getStock()));
		this.pr.saveAll(products);
		this.cpr.saveAll(productsSelled);
		assertEquals(((Product) ((Object[]) this.pr.getMostSelledProduct(PageRequest.of(0, 1))[0])[1]).getID(),products.stream().reduce((p1, p2) -> (p1.getStock() > p2.getStock()) ? p1:p2).get().getID());
	}
	
	@DisplayName("Test: test para comprobar que un cliente solo puede comprar 3 productos por día")
	@SuppressWarnings("deprecation")
	@Test
	public void testForFindTheAmountOfProductBoughtByAClientOnADate() {
		Client c = cr.save(new Client(1L, "Juan"));
		List<Product> products = List.of(
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 20, 1));
		List<ClientProduct> productsSelled = List.of(
				new ClientProduct(products.get(0), c, new Date(2021, 1, 1), products.get(0).getStock()),
				new ClientProduct(products.get(1), c, new Date(2021, 1, 1), products.get(1).getStock()),
				new ClientProduct(products.get(2), c, new Date(2021, 1, 1), products.get(2).getStock()));
		products = this.pr.saveAll(products);
		productsSelled = this.cpr.saveAll(productsSelled);
		assertEquals(productsSelled.size(),  cpr.findAmountBoughtProductsByDate(c.getID(), productsSelled.get(0).getDate()).intValue());
	}
}
