package com.apnidukan.model;

import org.springframework.web.multipart.MultipartFile;

public class AddProductDetails {
	
	private long productId;
	private String productName;
	private String productDescription;
	private boolean productImageExists;
	private int productNumItems;
	private boolean productArchived;
	
	private double productPrice;
	
	private long categoryId;
	
	private MultipartFile productImages;
	
	private String productImageName;
	
	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

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

	public MultipartFile getProductImages() {
		return productImages;
	}

	public void setProductImages(MultipartFile productImages) {
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "AddProductDetails [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productImageExists=" + productImageExists + ", productNumItems="
				+ productNumItems + ", productArchived=" + productArchived + ", productPrice=" + productPrice
				+ ", categoryId=" + categoryId + ", productImages=" + productImages + "]";
	}
	
	
	
}
