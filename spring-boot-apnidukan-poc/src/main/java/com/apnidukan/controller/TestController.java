package com.apnidukan.controller;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.model.Category;
import com.apnidukan.repository.ProductDetailsRepository;
import com.apnidukan.repository.TestRepository;


@RestController
@RequestMapping("/category")
public class TestController {
	
	@Autowired
	private TestRepository testRepository;
	private ProductDetailsRepository productRepository;
	
	
	@RequestMapping("/list")
	public List<Category> categoryDetails(){
		return testRepository.findAll();
	}
	
	@RequestMapping("/list/{categoryId}")
	public Category categoryDetails(@PathVariable long categoryId){
		return testRepository.findOne(categoryId);
	}
	
	//usedby JSP page to load category data
	@RequestMapping("/pullcategory")
	public String categoryData(){
		JSONArray categoryInfoArray = new JSONArray();
		
		List<Category> categoryList = new LinkedList<>();
		//categoryList = (List<Category>) testRepository.findAllOrderByCategoryType();
		categoryList = (List<Category>) testRepository.findAllByOrderByCategoryTypeAsc();
		for (Category category : categoryList) {
			JSONObject categoryInfoObj = new JSONObject();
			//System.out.println("ID : " + category.getCategoryId() + "-- Name : " + category.getCategoryType());
			categoryInfoObj.put("categoryName", category.getCategoryType());
			categoryInfoObj.put("categoryId", category.getCategoryId());
			
			//System.out.println("JSON Obj : " + categoryInfoObj.toString());
			categoryInfoArray.put(categoryInfoObj);
			//System.out.println("JSON Array : " + categoryInfoArray.toString());
		}
		
		//[{"categoryName":"Sports","categoryId":1},{"categoryName":"Tshirts","categoryId":2},{"categoryName":"Others","categoryId":3},{"categoryName":"Instruments","categoryId":4}]
		
		return categoryInfoArray.toString();
	}
}
