package com.apnidukan.service;

import java.util.List;

import com.apnidukan.model.Address;

public interface AddressService {
	List<Address> addressList();
	
	Address findOne(Long id);
	
	Address addAddress(Address address);
	
	String deleteAddress(Long id);
}
