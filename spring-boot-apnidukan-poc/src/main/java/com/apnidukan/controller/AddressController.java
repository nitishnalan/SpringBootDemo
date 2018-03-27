package com.apnidukan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apnidukan.model.Address;
import com.apnidukan.service.AddressService;

//@RestController

@Controller
@RequestMapping("/address")
public class AddressController {
 
		private AddressService addressService;
		
		@Autowired
		public AddressController(AddressService addressService) {
			this.addressService = addressService;
		}

		
		
		@RequestMapping("/list/{id}")
		public Address findOne(@PathVariable Long id) {
			return addressService.findOne(id);
		}
		
		@RequestMapping("/add")
		public Address addAddress(@RequestBody Address address) {
			return addressService.addAddress(address);
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteAddress(@PathVariable Long id) {
			return addressService.deleteAddress(id);
		}
		
	/*	@RequestMapping("/list")
		public List<Address> addressList(){
			return addressService.addressList();
		}*/
		
		@GetMapping("/list")
		public String addressList(Model model){
			model.addAttribute("address",addressService.addressList());
			return "/address/list";
		}
}
