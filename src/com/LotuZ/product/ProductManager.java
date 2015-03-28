package com.LotuZ.product;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.LotuZ.FacadeBL;
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
	
	public ProductManager(PersistKit kit){
		this.setPkit(kit);
	}

	
	public void createProduct(String productName, int price, int quantity, int category, int reduction) throws ClassNotFoundException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// Create empty ProductJDBC
		Product product = pkit.createProduct();
		// set informations into the userJdbc
		product.setProductName(productName);	
		//faire un setCategory en récupérant l'int de category
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setReduction(reduction);
		product.setCreationDate(dateFormat.format(date));
		product.setUpdateDate(dateFormat.format(date));
		product.setCategory(category);
		// Save in database 
		product.saveProduct();
	}
	
	public Product readProduct(int idProduct) throws SQLException {
		Product product = pkit.createProduct();
		product = product.loadProduct(idProduct);
		return product;
	}
	
	public Product updateProduct(Product product1, String productName, int category, int quantity, int price, int reduction) throws SQLException {
		Product product = pkit.createProduct();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		product1.setProductName(productName);
		product1.setQuantity(quantity);
		product1.setPrice(price);
		product1.setReduction(reduction);
		product1.setUpdateDate(dateFormat.format(date));
		product1.setCategory(category);

		product.updateProduct(product1);
		return product;
		
	}
	
	public void deleteProduct(int idProduct) throws SQLException {
		Product product = pkit.createProduct();
		System.out.println("LE PRODUIT EST:");
		System.out.println(product);
		product.setId(idProduct);
		//product = FacadeBL.loadProduct(idProduct);
		product.deleteProduct();
	}


	public List<Product> getAllProducts(int idCategory) throws SQLException {
		List<Product> listProduct;
		Product product = pkit.createProduct();
		listProduct = product.getAllProducts(idCategory);
		return listProduct;
	}


}
