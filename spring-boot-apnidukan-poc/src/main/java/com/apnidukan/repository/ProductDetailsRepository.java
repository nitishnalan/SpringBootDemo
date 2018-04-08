package com.apnidukan.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apnidukan.model.Category;
import com.apnidukan.model.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long>{

	//ProductDetails findByCategoryId(long id);

	Collection findByCategory(Category findOne);
	
	ProductDetails findByIdAndProductArchived(long productId,boolean productArchived);
}
