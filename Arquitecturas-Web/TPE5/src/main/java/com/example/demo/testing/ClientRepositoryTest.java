package com.example.demo.testing;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.ClientProduct;
import com.example.demo.pojo.Product;
import com.example.demo.repository.ClientProductRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Class ClientRepositoryTest.
 */
@DisplayName("Test: Capa de repositorios - Client Repository")
public class ClientRepositoryTest extends RepositoryTest<Client, Long> {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/** The client repository. */
	@Autowired
	private ClientRepository clientRepository;
	
	/** The client product repository. */
	@Autowired
	private ClientProductRepository clientProductRepository;

	/**
	 * Sets the up.
	 */
	@Override
	public void setUp() {
		this.entities = List.of(
				new Client(1L, "Juan"),
				new Client(2L, "Juan"),
				new Client(3L, "Juan"),
				new Client(4L, "Juan"))
				.stream().map((c) -> 
				this.clientRepository.save(c)).collect(Collectors.toList());
		this.entity = this.getRandomEntity();
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
	public JpaRepository<Client, Long> getRespository() {
		return this.clientRepository;
	}

	/**
	 * Test for get amount spend by client report.
	 */
	@SuppressWarnings("deprecation")
	@DisplayName("Test: test para generar un reporte donde se indiquen los clientes y el monto total de sus compras")
	@Test
	public void testForGetAmountSpendByClientReport() {
		Client c = clientRepository.save(new Client(1L, "Juan"));
		List<Product> products = List.of(
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 20, 1),
				new Product("Nombre", "Descripción", 20, 1));
		List<ClientProduct> productsSelled = List.of(
				new ClientProduct(products.get(0), c, new Date(2021, 1, 1), products.get(0).getStock()),
				new ClientProduct(products.get(1), c, new Date(2021, 1, 1), products.get(1).getStock()),
				new ClientProduct(products.get(2), c, new Date(2021, 1, 1), products.get(2).getStock()),
				new ClientProduct(products.get(3), c, new Date(2021, 1, 1), products.get(3).getStock()));
		this.productRepository.saveAll(products);
		this.clientProductRepository.saveAll(productsSelled);
		assertEquals((Integer)this.clientRepository.getAmountSpendByClientReport(PageRequest.of(0, 1)).getContent().get(0).getAmountSpend(),
				productsSelled.stream().map( p -> p.getCant() * p.getProduct().getPrice()).reduce((p1, p2) -> p1 + p2).get());
	}
}
