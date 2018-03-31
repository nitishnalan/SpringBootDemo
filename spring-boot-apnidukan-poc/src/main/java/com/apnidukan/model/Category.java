package com.apnidukan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="category")
public class Category extends AbstractPersistable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1632834845844088731L;
	
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	private String categoryType;
	private String categoryDescription;
	
	//@OneToMany(targetEntity=ProductDetails.class, mappedBy="categoryId",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	//private Set<ProductDetails> ProductDetails;
	
	//transient field
	
	private transient ProductDetails productsForCategory;

	public ProductDetails getProductsForCategory() {
		return productsForCategory;
	}

	public void setProductsForCategory(ProductDetails productsForCategory) {
		this.productsForCategory = productsForCategory;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	public Category(){}
}
