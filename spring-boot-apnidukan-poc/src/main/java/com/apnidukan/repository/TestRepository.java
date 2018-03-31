package com.apnidukan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apnidukan.model.Category;

public interface TestRepository extends JpaRepository<Category, Long>{

	//Iterable<Category> findAllOrderByCategoryType();

	//List<Category> findByCategoryType();

	//List<Category> findAllByOrderByCategoryType();

	List<Category> findAllByOrderByCategoryTypeAsc();

}
