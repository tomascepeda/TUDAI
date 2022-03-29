package com.example.demo.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.EntityPojo;
import com.example.demo.repository.ClientProductRepository;
import com.example.demo.service.BasicService;

/**
 * The Class ServiceTest.
 *
 * @param <Entity> the generic type, must extends from EntityPojo interface
 * @param <ID> the generic type
 */
@ExtendWith(MockitoExtension.class)
public abstract class ServiceTest<Entity extends EntityPojo<ID>, ID> {
	
	/** The cpr. */
	@Mock
	protected ClientProductRepository cpr;
	
	/** The p. */
	@Mock
	Page<Entity> p;
	
	/** The entity. */
	protected Entity entity;
	
	/** The entities. */
	protected List<Entity> entities;
	
	/**
	 * On set up.
	 */
	@BeforeEach
	public void onSetUp() {
		this.setUp();
	}	
	
	/**
	 * On tear down.
	 */
	@AfterEach
	public void onTearDown() {
		this.tearDown();
	}	
	
	/**
	 * Sets the up.
	 */
	public abstract void setUp();
	
	/**
	 * Tear down.
	 */
	public abstract void tearDown();
	

	/**
	 * Gets the respository.
	 *
	 * @return the respository
	 */
	public abstract JpaRepository<Entity, ID> getRespository();
	
	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public abstract BasicService<Entity, ID> getService();
	
	/**
	 * Gets the random entity.
	 *
	 * @return the random entity
	 */
	public EntityPojo<ID> getRandomEntity() {
		return this.entities.get((int)Math.random()*this.entities.size());
	}
	
	/**
	 * Test save a entity.
	 */
	@Test
	@DisplayName("Test: test para acciones de alta de un elemento")
	public void testSave() {
		when(getRespository().save(any())).thenReturn(any());
		getService().save(entity);
		verify(getRespository(),times(1)).save(any());
	}

	/**
	 * Test get a entity by id.
	 */
	@Test
	@DisplayName("Test: test para acciones de consulta por ID")
	public void testGetById() {  
		when(getRespository().findById(entity.getID())).thenReturn(Optional.ofNullable(entity));
		assertEquals(getService().findById(entity.getID()).get(), entity);
	}

	/**
	 * Test for delete entity by id.
	 */
	@Test
	@DisplayName("Test: test para acciones de bajas por ID")
	public void testForDeleteEntityById() {
		getService().delete(entity);
	    verify(getRespository(),times(1)).delete(entity);
	}

	/**
	 * Test for find all entities.
	 */
	@Test
	@DisplayName("Test: test para encontrar todas las entidades")
	public void testForFindAll() {
		when(p.getContent()).thenReturn(entities);
		when(p.getTotalPages()).thenReturn(1);
	    when(getRespository().findAll(PageRequest.of(0, 1000))).thenReturn(p);
	    assertEquals(entities.size(), getService().findAll(0, 1000).getElements().size());
	    verify(getRespository(),times(1)).findAll(PageRequest.of(0, 1000));
	}
}
