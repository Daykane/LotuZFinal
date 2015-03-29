package com.LotuZ.product;

import java.sql.SQLException;
import java.util.List;



public abstract class Product {
	private int idProduct;
	private String productName;
	private int category;
	private int quantity ;
	private int price;
	private int reduction;
	private String creationDate;
	private String updateDate;

	/**
	 * constructor of the abstract class Product
	 * @param productName
	 * @param quantity
	 * @param price
	 * @param reduction
	 * 
	 */

	public Product(String productName, int quantity, int price, int reduction, int category) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.reduction = reduction;
		this.category = category;
	}

	public Product(){
		super();
	}

	/**
	 *
	 * @return the name of the product
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
	 * @return the product category 
	 */
	public int getCategory() {
		return category;
	}
	/**
	 * @param category the product category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	/**
	 * @return the product quantity 
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the product quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the product price (in €)
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the product price to set (in €)
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the product reduction (in %)
	 */
	public int getReduction() {
		return reduction;
	}
	/**
	 * @param reduction the product reduction to set (in %)
	 */
	public void setReduction(int reduction) {
		this.reduction = reduction;
	}
	/**
	 * @return the creationDate of the product
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param date the creationDate of the product to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the updateDate of the product
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate of the product to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the product id
	 */
	public int getId() {
		return idProduct;
	}
	/**
	 * @param id the product id to set
	 */
	public void setId(int id) {
		this.idProduct = id;
	}


	/**
	 * abstract method to load a product according to its id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public abstract Product loadProduct(int id) throws SQLException;

	/**
	 * abstract method to save a product in the database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract void saveProduct() throws SQLException, ClassNotFoundException;

	/**
	 * abstract method to update a product in the database
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public abstract Product updateProduct (Product product) throws SQLException;

	/**
	 * abstract method to delete a product in the database
	 * @throws SQLException
	 */
	public abstract void deleteProduct() throws SQLException;


	/**
	 * abstract method to load all the products in the database according to its id
	 * @param idCategory
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Product> loadAllProducts(int idCategory) throws SQLException;

}
