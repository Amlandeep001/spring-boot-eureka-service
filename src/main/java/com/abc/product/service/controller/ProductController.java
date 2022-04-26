package com.abc.product.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.product.service.entity.Product;
import com.abc.product.service.repository.ProductRepository;

/**
 * 
 * @author amlandeep.nandi
 *
 */
@RestController
public class ProductController {

	private final ProductRepository productRepo;

	ProductController(ProductRepository productRepo) {
		this.productRepo = productRepo;

	}

	/**
	 * Fetch the product list
	 * 
	 * @return list of products
	 */
	@RequestMapping("/products")
	public List<Product> fetchAll() {
		return (List<Product>) productRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product fetchByID(@PathVariable("id") Long id) {
		return productRepo.findById(id).orElse(null);
	}

	/**
	 * Insert products
	 * 
	 * @param product
	 * @return product
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product store(@RequestBody Product product) {
		return productRepo.save(product);
	}

	/**
	 * Edit products by Id
	 * 
	 * @param product
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/update/{id}")
	public Product editById(@RequestBody Product product, @PathVariable("id") Long id) {
		Product existingProduct = fetchByID(id);
		if (existingProduct != null) {
			if (product.getProductname() != null) {
				existingProduct.setProductname(product.getProductname());
			}
			if (product.getQuantity() != null) {
				existingProduct.setQuantity(product.getQuantity());
			}
			if (product.getBrand() != null) {
				existingProduct.setBrand(product.getBrand());
			}
			if (product.getPrice() != null) {
				existingProduct.setPrice(product.getPrice());
			}
			if (product.getExpiryDate() != null) {
				existingProduct.setExpiryDate(product.getExpiryDate());
			}
			return productRepo.save(existingProduct);
		}
		return null;
	}

	/**
	 * Delete products by Id
	 * 
	 * @param id
	 */

	@RequestMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable("id") Long id) {
		Product product = fetchByID(id);
		if (product == null) {
			return false;
		}
		productRepo.delete(product);
		return true;
	}

}
