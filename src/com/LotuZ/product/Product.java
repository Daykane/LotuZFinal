package com.LotuZ.product;

import java.sql.SQLException;

import com.LotuZ.product.category.CategoryProduct;


public abstract class Product {
	
	private int idProduct;
	private String productName;
	private int category;
	private int quantity ;
	private int price;
	private int reduction;
	private String creationDate;
	private String updateDate;
	private int idProvider;
	
	public Product() {
		super();
	}

		
	/**
	 * @param productName
	 * @param quantity
	 * @param price
	 * @param reduction
	 */
	public Product(String productName, int quantity, int price, int reduction, int category) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.reduction = reduction;
		this.category = category;
	}


	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the reduction
	 */
	public int getReduction() {
		return reduction;
	}
	/**
	 * @param reduction the reduction to set
	 */
	public void setReduction(int reduction) {
		this.reduction = reduction;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return idProduct;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.idProduct = id;
	}

	/**
	 * @return the idProvider
	 */
	public int getIdProvider() {
		return idProvider;
	}
	/**
	 * @param idProvider the idProvider to set
	 */
	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}
	
	
public abstract Product loadProduct(int id) throws SQLException;

public abstract Product loadProduct(String productName) throws SQLException;

public abstract void saveProduct() throws SQLException, ClassNotFoundException;

public abstract Product updateProduct () throws SQLException;

public abstract void deleteProduct () throws SQLException;


	
}
