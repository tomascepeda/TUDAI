package com.example.demo.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.ClientProduct;
import com.example.demo.pojo.DTOClientAmountSpend;
import com.example.demo.pojo.Product;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.BasicService;
import com.example.demo.service.ClientService;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * The Class ClientServiceTest.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Test: Capa de Servicios - Client Service")
public class ClientServiceTest extends ServiceTest<Client, Long>{

	/** The cr. */
	@Mock
	private ClientRepository cr;
	
	/** The p. */
	@Mock
	Page<DTOClientAmountSpend> p;
	
	/** The cs. */
	@Autowired
	@InjectMocks
	private ClientService cs;

	/**
	 * Sets the up.
	 */
	@Override
	public void setUp() {
		this.entities = List.of(
				new Client(1L, "Juan"),
				new Client(2L, "Juan"),
				new Client(3L, "Juan"),
				new Client(4L, "Juan"));
		this.entity = entities.get(0);
	}

	/**
	 * Tear down.
	 */
	@Override
	public void tearDown() {
	}

	/**
	 * Gets the respository.
	 *
	 * @return the respository
	 */
	@Override
	public JpaRepository<Client, Long> getRespository() {
		return this.cr;
	}

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	@Override
	public BasicService<Client, Long> getService() {
		return this.cs;
	}	
	
	

	/**
	 * Test for get amount spend by client report.
	 */
	@SuppressWarnings("deprecation")
	@DisplayName("Test: test para generar un reporte donde se indiquen los clientes y el monto total de sus compras")
	@Test
	public void testForGetAmountSpendByClientReport() {
		Client c = new Client(1L, "Juan");
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
		List<DTOClientAmountSpend> listTest = List.of(new DTOClientAmountSpend(c, 60));
		when(p.getContent()).thenReturn(listTest);
		when(p.getTotalPages()).thenReturn(1);
		when(cr.getAmountSpendByClientReport(PageRequest.of(0, 1))).thenReturn(p);
		assertEquals((Integer)this.cs.getAmountSpendByClientReport(0, 1).getElements().get(0).getAmountSpend(),productsSelled.stream().map( p -> p.getCant() * p.getProduct().getPrice()).reduce((p1, p2) -> p1 + p2).get());
	}
}
