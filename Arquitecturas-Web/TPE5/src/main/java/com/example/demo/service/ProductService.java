package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pagination.Pagination;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;

/**
 * The Class ProductService.
 */
@Service
public class ProductService implements BasicService<Product, Long>{

	/** The pr. */
	@Autowired
	private ProductRepository pr;
	
	/** The cpr. */
	@Autowired
	private ClientProductRepository cpr;
	

	/**
	 * Find all products.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the pagination instance
	 */
	@Override
	public Pagination<Product> findAll(int page, int size) {
		Page<Product> p = this.pr.findAll(PageRequest.of(page, size));
		if(p.getTotalPages() < page) {			
			p = this.pr.findAll(PageRequest.of(p.getTotalPages(), size));
		}
		return new Pagination<Product>(p.getContent(), page, size, ((p.isFirst())?-1:page-1), ((p.isLast())?-1:page+1), p.getTotalPages());
	}
	
	/**
	 * Find by product's id.
	 *
	 * @param id the product's id
	 * @return an optional that contains product
	 */
	@Override
	public Optional<Product> findById(Long id) {
		return this.pr.findById(id);
	}
	
	
	/**
	 * Save an product.
	 *
	 * @param o the product
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean save(Product c) {
		if(c != null) {			
			this.pr.save(c);
			return true;
		}
		return false;
	}

	/**
	 * Delete an product.
	 *
	 * @param o the product.
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean delete(Product p) {
		System.out.println(p);
		if(p != null) {
			this.cpr.deleteAll(cpr.findByIdProduct(p.getID()));
			this.pr.delete(p);
			return true;
		}
		return false;
	}
	
	/**
	 * Gets a report of sales ordered by date.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the product select by date
	 */
	public Pagination<DTODaylyProductReport> getProductSelectByDate(int page, int size) {
		Page<DTODaylyProductReport> p =  this.pr.getProductSelectByDate(PageRequest.of(page, size));
		return new Pagination<DTODaylyProductReport>(p.getContent(), page, size, ((p.isFirst())?-1:page-1), ((p.isLast())?-1:page+1), p.getTotalPages());
	}
	
	/**
	 * Gets the most selled product.
	 *
	 * @return the most selled product
	 */
	public Object[] getMostSelledProduct() {
		return this.pr.getMostSelledProduct(PageRequest.of(0, 1));
	}
	
	
	
	
	
	/**
	 * Find all sales.
	 *
	 * @param page the number page
	 * @param size the page size
	 * @return the pagination
	 */
	public Pagination<ClientProduct> findAllSale(int page, int size) {
		Page<ClientProduct> p = this.cpr.findAll(PageRequest.of(page, size));
		if(p.getTotalPages() < page) {			
			p = this.cpr.findAll(PageRequest.of(p.getTotalPages(), size));
		}
		return new Pagination<ClientProduct>(p.getContent(), page, size, ((p.isFirst())?-1:page-1), ((p.isLast())?-1:page+1), p.getTotalPages());
	}
	 

	/**
	 * Find by id client.
	 *
	 * @param clientId the client id
	 * @return the list
	 */
	public List<ClientProduct> findByIdClient(Long clientId) {
		return this.cpr.findByIdClient(clientId);
	}
	

	/**
	 * Save a sale.
	 *
	 * @param c the sale
	 * @return true, if successful
	 */
	@Transactional
	public boolean save(ClientProduct c) {
		if(c != null) {
			this.cpr.save(c);
			return true;
		}
		return false;
	}
	

	/**
	 * Can buy.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean canBuy(ClientProduct p) {
		p.setDate(new Date());
		Integer cant = this.cpr.findAmountBoughtProductsByDate(p.getClient().getID(), p.getDate());
		return (cant != null) ? cant + p.getCant() <= 3 : p.getCant() <= 3;
	}
	
	

	/**
	 * Buy product.
	 *
	 * @param idProduct the id product
	 * @param cant the cant
	 * @return true, if successful
	 */
	public boolean buyProduct(ClientProduct p, int cant) {
		if (this.canBuy(p)) {
			Product product = this.pr.findById(p.getProduct().getID()).get();
			if (product.getStock() - cant >= 0) {
				product.setStock(product.getStock() - cant);
				this.pr.save(product);
				return true;
			}
		}
		return false;
	}
	
}
