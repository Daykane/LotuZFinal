package com.LotuZ.product;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;



public class ProductManager {

	private PersistKit pkit;

	/**
	 * @return the pkit
	 */
	public PersistKit getPkit() {
		return pkit;
	}

	/**
	 * @param pkit the pkit to set
	 */
	public void setPkit(PersistKit pkit) {
		this.pkit = pkit;
	}
	
	/**
	 * @param kit
	 */
	public ProductManager(PersistKit kit){
		this.setPkit(kit);
	}

	
	/**
	 * @param productName
	 * @param price
	 * @param quantity
	 * @param category
	 * @param reduction
	 * @param creationDate
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createProduct(String productName, int price, int quantity, int category, int reduction, String creationDate) throws ClassNotFoundException, SQLException {
		Product product = pkit.createProduct();
		// set informations into the product
		product.setProductName(productName);	
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setReduction(reduction);
		product.setCreationDate(creationDate);
		product.setUpdateDate(creationDate);
		product.setCategory(category);
		// Save in database 
		product.saveProduct();
	}
	
	/**
	 * @param idProduct
	 * @return
	 * @throws SQLException
	 */
	public Product loadProduct(int idProduct) throws SQLException {
		Product product = pkit.createProduct();
		product = product.loadProduct(idProduct);
		return product;
	}
	
	/**
	 * @param product1
	 * @param productName
	 * @param category
	 * @param quantity
	 * @param price
	 * @param reduction
	 * @param updateDate
	 * @return
	 * @throws SQLException
	 */
	public Product updateProduct(Product product1, String productName, int category, int quantity, int price, int reduction, String updateDate) throws SQLException {
		Product product = pkit.createProduct();
		
		//set informations into the product got
		product1.setProductName(productName);
		product1.setQuantity(quantity);
		product1.setPrice(price);
		product1.setReduction(reduction);
		product1.setUpdateDate(updateDate);
		product1.setCategory(category);

		product.updateProduct(product1);
		return product;
		
	}
	
	/**
	 * @param idProduct
	 * @throws SQLException
	 */
	public void deleteProduct(int idProduct) throws SQLException {
		Product product = pkit.createProduct();
		product.setId(idProduct);
		product.deleteProduct();
	}


	/**
	 * @param idCategory
	 * @return
	 * @throws SQLException
	 */
	public List<Product> loadAllProducts(int idCategory) throws SQLException {
		List<Product> listProduct;
		Product product = pkit.createProduct();
		listProduct = product.loadAllProducts(idCategory);
		return listProduct;
	}

}
