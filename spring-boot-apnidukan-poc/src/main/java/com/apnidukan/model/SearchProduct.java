package com.apnidukan.model;

public class SearchProduct {
	
	private long productId;
	private String productName;
	private String productDescription;
	private boolean productImageExists;
	private int productNumItems;
	private boolean productArchived;
	
	private double productPrice;
	
	private long categoryId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}