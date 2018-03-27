package com.apnidukan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.model.Address;
import com.apnidukan.repository.AddressRepository;
import com.apnidukan.repository.UsersRepository;
import com.apnidukan.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	private AddressRepository addressRepository;
	private UsersRepository userRepository;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, UsersRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findOne(id);
	}

	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		address.setUsers(userRepository.findOne(address.getUserId()));
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		// TODO Auto-generated method stub
		addressRepository.delete(id);
		return "{'message':'address deleted successfully'}";
	}
	
	
}
