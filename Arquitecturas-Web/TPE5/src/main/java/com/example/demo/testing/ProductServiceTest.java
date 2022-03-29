package com.example.demo.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.ClientProduct;
import com.example.demo.pojo.DTODaylyProductReport;
import com.example.demo.pojo.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.BasicService;
import com.example.demo.service.ProductService;

/**
 * The Class ProductServiceTest.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Test: Capa de Servicios - Product Service")
public class ProductServiceTest extends ServiceTest<Product, Long>{

	/** The pr. */
	@Mock
	private ProductRepository pr;
	
	/** The p. */
	@Mock
	Page<DTODaylyProductReport> p;
	
	/** The ps. */
	@Autowired
	@InjectMocks
	private ProductService ps;

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
		this.entity = this.entities.get(0);
	}
	
	/**
	 * Tear down.
	 */
	@Override
	public void tearDown() {
		this.entities = null;
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

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	@Override
	public BasicService<Product, Long> getService() {
		return this.ps;
	}
	
	/**
	 * Test for get product select by date.
	 */
	@Test
	@DisplayName("Test: test para obtener la lista de productos vendidos por día")
	public void testForGetProductSelectByDate() {
		List<DTODaylyProductReport> products = List.of(
				new DTODaylyProductReport(),
				new DTODaylyProductReport(),
				new DTODaylyProductReport()
				);
		when(p.getContent()).thenReturn(products);
		when(p.getTotalPages()).thenReturn(1);
		when(pr.getProductSelectByDate(PageRequest.of(0, 1))).thenReturn(p);
		assertEquals(products.size(), this.ps.getProductSelectByDate(0, 1).getElements().size());
		verify(pr, times(1)).getProductSelectByDate(PageRequest.of(0, 1));		
	}
	
	/**
	 * Test for get amount spend by client report.
	 */
	@DisplayName("Test: test para saber cuál fue el producto más vendido")
	@Test
	public void testForGetAmountSpendByClientReport() {
		List<Product> products = List.of(
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 20, 1),
				new Product("Nombre", "Descripción", 20, 10));
		when(pr.getMostSelledProduct(PageRequest.of(0, 1))).thenReturn(new Object[] {new Object[] {20, new Product("Nombre", "Descripción", 20, 10)}});
		assertEquals(((Product) ((Object[]) this.ps.getMostSelledProduct()[0])[1]).getID(),products.stream().reduce((p1, p2) -> (p1.getStock() > p2.getStock()) ? p1:p2).get().getID());
	}
	
	@DisplayName("Test: test para comprobar que un cliente solo puede comprar 3 productos por día")
	@SuppressWarnings("deprecation")
	@Test
	public void testForVerifyClientCanOnlyBuy3ProductsPerDay() {
		Client c = new Client(1L, "Juan");
		List<Product> products = List.of(
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 10, 1),
				new Product("Nombre", "Descripción", 20, 1));
		List<ClientProduct> productsSelled = new ArrayList<>();
		productsSelled.add(new ClientProduct(products.get(0), c, new Date(2021, 1, 1), products.get(0).getStock()));
		productsSelled.add(new ClientProduct(products.get(1), c, new Date(2021, 1, 1), products.get(1).getStock()));
		
		when(pr.findById(any())).thenReturn(Optional.of(products.get(0)));
		when(cpr.findAmountBoughtProductsByDate(any(), any())).thenReturn( Integer.valueOf(productsSelled.size()) );
		assertTrue(this.ps.buyProduct(productsSelled.get(0), 0));
		
		productsSelled.add(new ClientProduct(products.get(2), c, new Date(2021, 1, 1), products.get(2).getStock()));
		when(cpr.findAmountBoughtProductsByDate(any(), any())).thenReturn( Integer.valueOf(productsSelled.size()) );
		assertFalse(this.ps.buyProduct(productsSelled.get(0), 0));
	}
}
