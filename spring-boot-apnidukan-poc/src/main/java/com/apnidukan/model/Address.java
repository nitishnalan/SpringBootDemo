package com.apnidukan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Address extends AbstractPersistable<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id",insertable=false,updatable=false)
	private int addressId;
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	private String state;
	private String city;
	private String country;
		
	
	//we will create one transient field for userId
	
	private transient Long userId;
	
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	private Users user;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users user) {
		this.user = user;
	}
	
	
}
