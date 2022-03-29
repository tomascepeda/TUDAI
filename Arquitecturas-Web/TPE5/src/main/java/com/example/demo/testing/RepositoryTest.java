package com.example.demo.testing;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.pojo.EntityPojo;

/**
 * The Class RepositoryTest.
 *
 * @param <Entity> the generic type, must extends from EntityPojo interface
 * @param <ID> the generic type
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public abstract class RepositoryTest<Entity extends EntityPojo<ID>, ID> {

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
	 * Gets the random entity.
	 *
	 * @return the random entity
	 */
	public Entity getRandomEntity() {
		return this.entities.get((int)Math.random()*this.entities.size());
	}
	
	/**
	 * Test save entity.
	 */
	@Test
	@DisplayName("Test: test para acciones de alta de un elemento")
	public void testSave() {
		
		getRespository().save(entity);
		Entity entity = getRespository().findById(this.entity.getID()).get();
		assertEquals(this.entity, entity);
	}

	/**
	 * Test save all entities.
	 */
	@Test
	@DisplayName("Test: test para acciones de altas de varios elementos")
	public void testSaveAll() {
		getRespository().saveAll(entities);
		List<Entity> entities = getRespository().findAll();
		assertEquals(this.entities.size(), entities.size());
	}

	/**
	 * Test get a entity by id.
	 */
	@Test
	@DisplayName("Test: test para acciones de consulta por ID")
	public void testGetById() {
		Entity entity = getRespository().save(this.entity);
		Optional<Entity> optional = getRespository().findById(entity.getID());
		assertEquals(this.entity, optional.get());
	}

	/**
	 * Test for delete an entity by id.
	 */
	@Test
	@DisplayName("Test: test para acciones de bajas por ID")
	public void testForDeleteEntityById() {
		getRespository().save(entity);
		getRespository().deleteById(this.entity.getID());
		Optional<Entity> optional = getRespository().findById(this.entity.getID());
		assertEquals(Optional.empty(), optional);
	}
}
