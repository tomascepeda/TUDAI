package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pagination.Pagination;
import com.example.demo.pojo.ClientProduct;
import com.example.demo.pojo.DTODaylyProductReport;
import com.example.demo.pojo.Product;
import com.example.demo.service.ProductService;

import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductController.
 */
@RestController
@RequestMapping("api/products")
public class ProductController implements BasicController<Product> {

	/** The ps. */
	@Autowired
	private ProductService ps;

	/**
	 * Find product by id.
	 *
	 * @param page the page
	 * @param size the size
	 * @return the response product
	 */
	@GetMapping(value = { "/report/page", "/report/", "/report" })
	@ApiOperation("Find product by id.")
	public ResponseEntity<Pagination<DTODaylyProductReport>> findById(
			@RequestParam(value = "page", defaultValue="1") int page, 
			@RequestParam(value = "size", defaultValue="5") int size) {
			return new ResponseEntity<Pagination<DTODaylyProductReport>>(this.ps.getProductSelectByDate(page, size), HttpStatus.OK);
	}
	
	/**
	 * Gets the most selled product.
	 *
	 * @return the most selled product
	 */
	@GetMapping("/most-selled")
	@ApiOperation("Gets the most selled product.")
	public ResponseEntity<Object[]> getMostSelledProduct() {
			return new ResponseEntity<Object[]>(this.ps.getMostSelledProduct(), HttpStatus.OK);
	}
	
	/**
	 * Gets the all the product.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return all the product
	 */
	@Override
	@GetMapping(value={"/page", "/", ""})
	@ApiOperation("Gets the all the product.")
	public ResponseEntity<Pagination<Product>> getAll(
			@RequestParam(value = "page", defaultValue="1") int page, 
			@RequestParam(value = "size", defaultValue="5") int size) {
		return new ResponseEntity<Pagination<Product>>(ps.findAll(page, size), HttpStatus.OK);
	}
	
	/**
	 * Gets a product by id.
	 *
	 * @param id the entity id
	 * @return the product
	 */
	@Override
	@GetMapping("/{id}")
	@ApiOperation("Gets a product by id.")
	public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
		Optional<Product> o = this.ps.findById(id);
		if(o.isPresent()) {
			return new ResponseEntity<Product>(o.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
		
	/**
	 * Save a product.
	 *
	 * @param c the product
	 * @return the response product
	 */
	@Override
	@PostMapping(value={"/", ""},
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Save a product.")
	public ResponseEntity<Product> save(@RequestBody Product c) {
		if(this.ps.save(c)) {
			return new  ResponseEntity<Product>(c, HttpStatus.OK);
		}
		return new  ResponseEntity<Product>(c, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Delete a product.
	 *
	 * @param id the product id
	 * @return the response product
	 */
	@Override
	@DeleteMapping("/{id}")
	@ApiOperation("Delete a product.")
	public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
		Optional<Product> o = this.ps.findById(id);
		if(o.isPresent()&&this.ps.delete(o.get())) {		
			return new  ResponseEntity<Product>(o.get(), HttpStatus.OK);
		}
		return new  ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Update a product.
	 *
	 * @param o the product
	 * @return the response product
	 */
	@Override
	@PutMapping(value={"/", ""},
		    consumes = MediaType.APPLICATION_JSON_VALUE, 
		    produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Update a product.")
	public ResponseEntity<Product> update(@RequestBody Product c) {
		return this.save(c);
	}

	
	
	

	
	/**
	 * Gets the all sales.
	 *
	 * @param page the page
	 * @param size the size
	 * @return all the sales
	 */
	@GetMapping(value = { "bought/page", "bought/", "bought" })
	@ApiOperation("Gets the report amount spend.")
	public ResponseEntity<Pagination<ClientProduct>> getAllSales(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		return new ResponseEntity<Pagination<ClientProduct>>(this.ps.findAllSale(page, size), HttpStatus.OK);
	}

	/**
	 * Gets the sales by client id.
	 *
	 * @param id the client id
	 * @return the sales 
	 */
	@GetMapping("bought/{id}")
	@ApiOperation(" Gets the all sales.")
	public ResponseEntity<List<ClientProduct>> getByClientId(@PathVariable("id") Long id) {
		List<ClientProduct> o = this.ps.findByIdClient(id);
		return new ResponseEntity<List<ClientProduct>>(o, HttpStatus.OK);

	}

	/**
	 * Save a sale.
	 *
	 * @param c the sale
	 * @return the response sale
	 */
	@PostMapping(value = { "bought/","bought" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Save a sale.")
	public ResponseEntity<ClientProduct> save(@RequestBody ClientProduct c) {
		if (ps.buyProduct(c, c.getCant())) {
			if (this.ps.save(c)) {
				return new ResponseEntity<ClientProduct>(c, HttpStatus.OK);
			}
			return new ResponseEntity<ClientProduct>(c, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClientProduct>(c, HttpStatus.FORBIDDEN);
	}
}
