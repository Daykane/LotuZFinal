package com.LotuZ.product;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProductJDBC extends Product {
private Connection cn;
	
	/**
	 * @return the cn
	 */
	public Connection getCn() {
		return cn;
	}

	/**
	 * @param cn the cn to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}

	public ProductJDBC(Connection cn) {
		this.cn = cn;
	}
	
	public ProductJDBC(int id, String productName, int category, int quantity, int price, int reduction, String creationDate, String updateDate, int idProvider) {
		this.setId(id);
		this.setProductName(productName);
		this.setCategory(category);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setReduction(reduction);
		this.setCreationDate(creationDate);
		this.setUpdateDate(updateDate);
		this.setIdProvider(idProvider);
	}
	
	public ProductJDBC(String productName, int quantity, int price, int reduction) {
		this.setProductName(productName);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setReduction(reduction);
	}

	@Override
	public Product loadProduct(int id) throws SQLException {
		Product product = null;
		try {

			Statement st =null;
			// Etape 1 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.Product Where id="+'"'+id+'"';
			// Etape 2 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			product = getAndCreateProduct(result);

		} catch (SQLException e) {
			throw e;
		}
		return product;
	}
	
	@Override
	public Product loadProduct(String productName) throws SQLException {
		Product product = null;
		try {
			Statement st =null;
			// Etape 1 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.Activity Where name="+'"'+productName+'"';
			// Etape 4 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			product = getAndCreateProduct(result);
		} catch (SQLException e) {
			throw e;
		}
		return product;
	}


	@Override
	public void saveProduct() throws SQLException, ClassNotFoundException {


		try {		
			Statement st =null;
			// Etape 1 : Creation d'un statement
			st = this.cn.createStatement();
			String sql = "Insert into Product Values ('"+ this.getProductName() +"','"+ this.getCategory() +"','"+ this.getQuantity()+"','"+ this.getPrice() +"','"+ this.getReduction() + "','"+ this.getCreationDate() +"','"+ this.getUpdateDate() + this.getId() + this.getIdProvider() +"')";
			// Etape 2 : exécution requête
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw e;
		}
	}

	public Product updateProduct() throws SQLException {
		try {		
			Statement st =null;
			// Etape 1 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "UPDATE product SET `productName`='"+this.getProductName() +"',`category`='"+ this.getCategory() +"',`quantity`='"+this.getQuantity()
					+"',`price`='"+this.getPrice()+"',`reduction`='"+this.getReduction()+"' Where `creationDate`='"+this.getCreationDate() +"',`updateDate`='"+this.getUpdateDate() +"',`idProduct`='"+this.getId() +"',`idProvider`='"+this.getIdProvider() +"'";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);	
			
		} catch (SQLException e) {
			throw e;
		}
		
		return this;
	}
		



	@Override
	public void deleteProduct(int id) throws SQLException {
		try {		
			Statement st =null;
			// Etape 1 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "DELETE FROM product WHERE `idProduct`='"+this.getId() +"'";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);	
			
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
	private static Product getAndCreateProduct(ResultSet result) throws SQLException {
		ProductJDBC product = null;
		while( result.next() ){	
			int id = result.getInt("id");
			String productName = result.getString("productName");
			int category = result.getInt("category");
			int quantity = result.getInt("quantity");
			int price = result.getInt("price");
			int reduction = result.getInt("reduction");
			String creationDate = result.getString("creationDate");
			String updateDate = result.getString("updateDate");
			int idProvider = result.getInt("ipProvider");

			product = new ProductJDBC(id,productName,category,quantity,price,reduction,creationDate,updateDate, idProvider);
		}
		return product;
	}	
	

}
