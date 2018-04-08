package com.apnidukan.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.apnidukan.model.AddProductDetails;
import com.apnidukan.model.ProductDetails;
import com.apnidukan.model.SearchProduct;
import com.apnidukan.repository.CommonQueryRepository;
import com.apnidukan.repository.ProductDetailsRepository;
import com.apnidukan.utils.ProductDetailsUtil;

@Controller

public class AdministratorController {

	private Path folderLocation;

	//private Path rootLocation = Paths.get("upload-dir");
	//Resource resource = new ClassPathResource("static/images").getPath();
	private Path rootLocation = Paths.get(("src\\main\\resources\\static\\images\\"));
	@Autowired
    private ResourceLoader resourceLoader;
	private Path rootLocationTemp = Paths.get(new ClassPathResource("noimage.jpg").getPath());

	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	@Autowired
	private CommonQueryRepository commonQueryRepository;
	
	@RequestMapping("/admin")
	//@RequestMapping("/addproducts")
	public String welcome(Model model) {
		model.addAttribute("message","Hello Welcome NN");
		return "/admin/AddProduct";
	}
	
	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public String testFileUpload(/*@RequestParam("file") MultipartFile file, */HttpServletRequest request,@ModelAttribute AddProductDetails addProducts) {
		//rootLocation = Paths.get("upload-dir");
		ProductDetails products= new ProductDetails();
		try {
			System.out.println("Inside try");
			long tempFolderName = 0;
			String folderNametemp = ProductDetailsUtil.getAutoIncrementId("product_details","Id",commonQueryRepository);
			
			System.out.println("Root Path : " + rootLocation);
			
			//NNC delete
			/*System.out.println("Temp Root Path : " + rootLocationTemp);
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			//URL url = loader.getResource("/static");
			Resource fileResource =resourceLoader.getResource("classpath: noimage.jpg");
			
		    File dir = fileResource.getFile();
			
		    
		    System.out.println("URL path : " + dir.getAbsoluteFile().getParent());
			*/
			
			
			System.out.println("FolderName : " + folderNametemp);
			tempFolderName = Long.parseLong(folderNametemp);
			System.out.println("tempFolderName : " + tempFolderName);
			System.out.println("method init root location");
			if(!Files.exists(rootLocation)){
				System.out.println("before init root location");
				init();
			}
			
			System.out.println("after init root location");
			//System.out.println("addProducts.getProductImages() : " + addProducts.getProductImages().getOriginalFilename());
			System.out.println("path root " + rootLocation.toString());
			if(!addProducts.getProductImages().getOriginalFilename().equals("")) {
				MultipartFile file = addProducts.getProductImages();
				
				System.out.println("adding multipart");
				//creates project with the product ID
				if(tempFolderName!=0) {
					//String folderName = "upload-dir/".concat(Long.toString(tempFolderName));
					String folderName = "src/main/resources/static/images/".concat(Long.toString(tempFolderName));
					System.out.println("totalPATH : " + folderName);
					folderLocation = Paths.get(folderName);
					if(!Files.exists(folderLocation)){
						Files.createDirectory(folderLocation);
					}else
					{
						//delete all existing files from the folder
						File directory = new File(folderName);
						FileUtils.cleanDirectory(directory); 
					}
				}
				
				System.out.println("file.getOriginalFilename() : " + file.getOriginalFilename());
				System.out.println("this.folderLocation : " + this.folderLocation);
				
				System.out.println("folderLocation : " + folderLocation);
	            Files.copy(file.getInputStream(), this.folderLocation.resolve(file.getOriginalFilename()));
	            
	            System.out.println("image name : "+ file.getOriginalFilename());
	            addProducts.setProductImageName(file.getOriginalFilename());
	            products.setProductImageName(addProducts.getProductImageName());
	            products.setProductImageExists(true);
			}
			else {
				products.setProductImageExists(false);
			}
			
			System.out.println("Product Name: " + request.getParameter("productName"));
			System.out.println("Product Name with Model: " + addProducts.getProductName());
			System.out.println("Product Details : " + addProducts.toString());
			
			
			products.setProductName(addProducts.getProductName());
			products.setCategoryId(addProducts.getCategoryId());
			products.setProductArchived(addProducts.isProductArchived());
			products.setProductDescription(addProducts.getProductDescription());
			products.setProductNumItems(addProducts.getProductNumItems());
			products.setProductPrice(addProducts.getProductPrice());
			productDetailsRepository.save(products);			
			
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!");
        }		
		return "/admin/AddProduct";
		
	}
	
	public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
	}
	
	
/*	@RequestMapping(value = "/admin/searchproduct/{pageid}", method = RequestMethod.GET)
	public ModelAndView searchProduct(@PathVariable int pageid) {
		int total=1;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<SearchProduct> listSearchProduct= commonQueryRepository.getProductsByPage(pageid,total);  
          
        return new ModelAndView("/admin/UpdateProduct","list",listSearchProduct);  
	}*/
	
	
/*	@RequestMapping(value = "/admin/searchprod/{pageid}", method = RequestMethod.GET)
	public ModelAndView searchProductOne(@PathVariable int pageid,HttpServletRequest request,@RequestParam String searchfield) {
		String searchFieldController = request.getParameter("searchfield");
		List<SearchProduct> listSearchProduct =  new LinkedList<>();
		
		int total=1;  
		if(pageid==1){}  
		else{  
			pageid=(pageid-1)*total+1;  
		} 
		
		if(searchFieldController.trim().equals("")) {			 
			listSearchProduct= commonQueryRepository.getProductsByPage(pageid,total);            			
		}
		else {
			
			//session.setAttribute("searchFieldController", searchFieldController);
			listSearchProduct= commonQueryRepository.getProductsByPageAndSearch(pageid,total,searchFieldController);
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("searchFieldController", searchFieldController);
		
		if(listSearchProduct!=null) {
			session.setAttribute("foundResults", "true");
		}
		return new ModelAndView("/admin/UpdateProduct","list",listSearchProduct);   
	}*/
	
	
	
	@RequestMapping(value = "/admin/searchproduct/{pageid}", method = RequestMethod.GET)
	
	public ModelAndView searchProduct(@PathVariable int pageid,HttpServletRequest request,@RequestParam String searchfield) {
		
		String searchFieldController = request.getParameter("searchfield");
		List<SearchProduct> listSearchProduct =  new LinkedList<>();
		List<SearchProduct> resultSize =  new LinkedList<>();
		
		//set total size you would like to display
		
		System.out.println("PAGE ID in /admin/searchproduct/{pageid} : " + pageid);
		System.out.println("searchFieldController : "+ searchFieldController);
		
		
		int total=1;  
		if(pageid==1){}  
		else{  
			pageid=(pageid-1)*total+1;  
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
		
		int totalPagesRequired = resultSize.size()/total;
		
		
		session.setAttribute("totalPages", totalPagesRequired);
		System.out.println("totalPages: " + totalPagesRequired);
		return new ModelAndView("/admin/UpdateProduct","list",listSearchProduct);  
	}
}


