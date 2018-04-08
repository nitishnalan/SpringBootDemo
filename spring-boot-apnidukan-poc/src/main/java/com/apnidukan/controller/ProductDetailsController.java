package com.apnidukan.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apnidukan.model.ProductDetails;
import com.apnidukan.model.SearchProduct;
import com.apnidukan.repository.CommonQueryRepository;
import com.apnidukan.repository.ProductDetailsRepository;

@RestController

@RequestMapping("/product")
public class ProductDetailsController {
	
	//@Autowired
	private ProductDetailsRepository productDetailsRepository;
	//private TestRepository categoryTestRepo;
	
	@Autowired
	private CommonQueryRepository commonQueryRepository;

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
	
	@RequestMapping(value = "/search/{pageid}", method = RequestMethod.GET)
	
	public ModelAndView searchProduct(@PathVariable int pageid,HttpServletRequest request,@RequestParam String searchfield) {
		
		String searchFieldController = request.getParameter("searchfield");
		List<SearchProduct> listSearchProduct =  new LinkedList<>();
		List<SearchProduct> resultSize =  new LinkedList<>();
		//set total size you would like to display
		double totalD=2;
		double pageID2;
		int total= (int) totalD;
		if(pageid==1){}  
		else{  
			pageID2=(pageid-1)*totalD+1;  
			pageid = (int) pageID2;
		} 
		
		if(searchFieldController.trim().equals("*")) {			 
			//listSearchProduct= commonQueryRepository.getProductsByPage(pageid,total);
			listSearchProduct= commonQueryRepository.getProductsByPageAndSearch(pageid,total,searchFieldController);
			resultSize=commonQueryRepository.getProductsSearchSize(pageid, total, searchFieldController);
		}
		else if(!(searchFieldController.trim().equals(""))){
			listSearchProduct= commonQueryRepository.getProductsByPageAndSearch(pageid,total,searchFieldController);
			
			resultSize=commonQueryRepository.getProductsSearchSize(pageid, total, searchFieldController);
		}
		
		HttpSession session = request.getSession(false);
		session.setAttribute("searchFieldController", searchFieldController);
		
		if(listSearchProduct.size()!=0) {
			session.setAttribute("foundResults", "true");
		}else
		{
			session.setAttribute("foundResults", "false");
		}
		
		//display if the list is set
		System.out.println("listSearchProduct SIZE: " + listSearchProduct.toString());
		
		//display total result size
		System.out.println("result SIZE : " + resultSize.size());
		
		double resultSetSize = (double) resultSize.size();
		double totalPagesRequiredD =  Math.round(resultSetSize/totalD);
		System.out.println("totalPages: double : " + totalPagesRequiredD);
		int totalPagesRequired = (int) totalPagesRequiredD;
		session.setAttribute("totalPages", totalPagesRequired);
		System.out.println("totalPages: " + totalPagesRequired);
		return new ModelAndView("homepage","list",listSearchProduct);  
	}
	
    @RequestMapping(value = "/summary/{productId}", method = RequestMethod.GET)
	
	public ModelAndView summaryOfProduct(@PathVariable Integer productId,HttpServletRequest request) {
    	
    	//NNC
    	//set user login session else ask for login session
    	
    	ProductDetails productSummary =  new ProductDetails();
    	
    	if(productId != null) {
    		productSummary = productDetailsRepository.findByIdAndProductArchived(productId,false);
    	}
    	
    	System.out.println("Product Summary : " + productSummary.toString());
    	if(productSummary!=null) {
    	  return new ModelAndView("/product/summary","productSummary",productSummary); 
    	}
    	
    	return new ModelAndView("error","message","The requested product Id is not available in the database");
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
