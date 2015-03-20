package com.LotuZ.product;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.LotuZ.PersistKit;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

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
	
	public void createProduct(String productName, int quantity, int price, int reduction) throws ClassNotFoundException, SQLException {
		User user = UserLog.getUserLog();
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
		// Save in database the user
		product.saveProduct();
	}


}
