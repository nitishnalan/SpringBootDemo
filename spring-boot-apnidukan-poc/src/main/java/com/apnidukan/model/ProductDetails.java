package com.apnidukan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Entity
@Table(name="product_details")
@Data
public class ProductDetails extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6136115792820266816L;
	
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private String productDescription;
	private boolean productImageExists;
	private String productImageName;
	
	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	private transient long categoryId;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private int productNumItems;
	private boolean productArchived;
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public boolean isProductImageExists() {
		return productImageExists;
	}

	public void setProductImageExists(boolean productImageExists) {
		this.productImageExists = productImageExists;
	}

	public int getProductNumItems() {
		return productNumItems;
	}

	public void setProductNumItems(int productNumItems) {
		this.productNumItems = productNumItems;
	}

	public boolean isProductArchived() {
		return productArchived;
	}

	public void setProductArchived(boolean productArchived) {
		this.productArchived = productArchived;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	private double productPrice;
	
	@OneToOne
	@JoinColumn(name="categoryId", nullable = false, insertable = false, updatable = false)
	private Category category;
}
