package com.example.demo.controller;

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
import com.example.demo.pojo.Client;
import com.example.demo.pojo.DTOClientAmountSpend;
import com.example.demo.service.ClientService;

import io.swagger.annotations.ApiOperation;

/**
 * The Class ClientController.
 */
@RestController
@RequestMapping("api/clients")
public class ClientController implements BasicController<Client> {

	/** The cs. */
	@Autowired
	private ClientService cs;

	/**
	 * Gets the report amount spend.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the report amount spend
	 */
	@GetMapping(value = { "/report/page", "/report/", "/report" })
	@ApiOperation("Gets the report amount spend.")
	public ResponseEntity<Pagination<DTOClientAmountSpend>> getReportAmountSpend(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		return new ResponseEntity<Pagination<DTOClientAmountSpend>>(this.cs.getAmountSpendByClientReport(page, size),
				HttpStatus.OK);
	}

	/**
	 * clients
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the all
	 */
	@Override
	@GetMapping(value = { "/page", "/", "" })
	@ApiOperation("Gets the report amount spend.")
	public ResponseEntity<Pagination<Client>> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		return new ResponseEntity<Pagination<Client>>(this.cs.findAll(page, size), HttpStatus.OK);
	}

	/**
	 * Gets a client by id.
	 *
	 * @param id the entity id
	 * @return the by id
	 */
	@Override
	@GetMapping("/{id}")
	@ApiOperation("Gets a client by id.")
	public ResponseEntity<Client> getById(@PathVariable("id") Long id) {
		Optional<Client> o = this.cs.findById(id);
		if (o.isPresent()) {
			return new ResponseEntity<Client>(o.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Save an client.
	 *
	 * @param c the client's id
	 * @return the response client
	 */
	@Override
	@PostMapping(value = { "/",
			"" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Save an client.")
	public ResponseEntity<Client> save(@RequestBody Client c) {
		if (this.cs.save(c)) {
			return new ResponseEntity<Client>(c, HttpStatus.OK);
		}
		return new ResponseEntity<Client>(c, HttpStatus.NOT_FOUND);
	}

	/**
	 * Delete a client.
	 *
	 * @param id the client id
	 * @return the response client
	 */
	@Override
	@DeleteMapping("/{id}")
	@ApiOperation("Delete a client.")
	public ResponseEntity<Client> delete(@PathVariable("id") Long id) {
		Optional<Client> o = this.cs.findById(id);
		if (o.isPresent()&&this.cs.delete(o.get())) {
			return new ResponseEntity<Client>(o.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Update a client.
	 *
	 * @param o the client
	 * @return the response client
	 */
	@Override
	@PutMapping(value = { "/",
			"" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Update a client.")
	public ResponseEntity<Client> update(@RequestBody Client o) {
		return this.save(o);
	}
}
