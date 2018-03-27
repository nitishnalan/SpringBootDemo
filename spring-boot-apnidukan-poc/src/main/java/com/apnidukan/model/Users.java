package com.apnidukan.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

/*@Entity
@Table(name="users")
@Getter
@Setter*/

@Entity
public class Users extends AbstractPersistable<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4957637396239696444L;
			
	@OneToMany(targetEntity=Address.class, mappedBy="user",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Address> addresses;
	
	//we will create one transient field for userId
	
	
	private String username;
	private String name;
	private String email;
	
	@Column(name = "id", insertable = false, updatable = false)
	private Long userId;
	

	public String getUsername() {
		return username;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
/*	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/


	
}
