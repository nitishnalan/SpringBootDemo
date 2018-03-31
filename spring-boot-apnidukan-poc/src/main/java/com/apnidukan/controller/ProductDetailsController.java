package com.apnidukan.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.model.Category;
import com.apnidukan.model.ProductDetails;
import com.apnidukan.repository.ProductDetailsRepository;
import com.apnidukan.repository.TestRepository;

@RestController

@RequestMapping("/product")
public class ProductDetailsController {
	
	//@Autowired
	private ProductDetailsRepository productDetailsRepository;
	//private TestRepository categoryTestRepo;

	@Autowired
	public ProductDetailsController(ProductDetailsRepository productDetailsRepository/*,TestRepository categoryTestRepo*/) {
		//super();
		this.productDetailsRepository = productDetailsRepository;
		//this.categoryTestRepo = categoryTestRepo;
	};
	
	@RequestMapping("/list")
	public List<ProductDetails> productDetails(){
		return productDetailsRepository.findAll();
	}
	
	//@RequestMapping("/bytype/{categoryId}")
/*	public ProductDetails productByType(@PathVariable int categoryId){
		
		//JSONObject responseObject = new JSONObject();
		
		//ProductDetails temp = productRepository.findByCategoryId()
		
		return  productDetailsRepository.findByCategoryId(categoryId);
	}*/
	
/*	public ResponseEntity productByType(@PathVariable long categoryId){
				
		JSONObject responseObject = new JSONObject();
		//System.out.println("NN Print : " + categoryTestRepo.findOne(categoryId));
		ProductDetails tempProdDetails = new ProductDetails();
		tempProdDetails.setCategory((categoryTestRepo.findOne(categoryId)));
		responseObject.put("data",categoryTestRepo.findOne(categoryId));
		
		return ResponseEntity.ok(responseObject.toString());
	}*/
	
	//add method to get data based on category 
	
	//add method to get product based on its id
	
	//method for for adding new product to the database
	
	//method for soft deleting the data
	
	
	
}
