package com.abc.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.product.service.entity.Product;

/**
 * 
 * @author amlandeep.nandi
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

}
