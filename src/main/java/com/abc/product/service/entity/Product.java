package com.abc.product.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = -6815393342888631903L;
	
	@Id
	Long id;
	String productname;
	Integer quantity;
	String brand;
	BigDecimal price;
	LocalDate expiryDate;
	LocalDate manufacturedDate;

}
