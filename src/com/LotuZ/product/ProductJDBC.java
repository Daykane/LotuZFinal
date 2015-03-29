package com.LotuZ.product;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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

	/**
	 * constructor of the class ProductJDBC
	 * @param cn
	 */
	public ProductJDBC(Connection cn) {
		this.cn = cn;
	}

	/**
	 * constructor of the class ProductJDBC
	 * @param id
	 * @param productName
	 * @param category
	 * @param quantity
	 * @param price
	 * @param reduction
	 * @param creationDate
	 * @param updateDate
	 */
	public ProductJDBC(int id, String productName, int category, int quantity, int price, int reduction, String creationDate, String updateDate) {
		this.setId(id);
		this.setProductName(productName);
		this.setCategory(category);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setReduction(reduction);
		this.setCreationDate(creationDate);
		this.setUpdateDate(updateDate);
	}

	/**
	 * constructor of the class ProductJDBC
	 * @param productName
	 * @param quantity
	 * @param price
	 * @param reduction
	 */
	public ProductJDBC(String productName, int quantity, int price, int reduction) {
		this.setProductName(productName);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setReduction(reduction);
	}

	@Override
	public Product loadProduct(int idP) throws SQLException {
		Product product = null;
		try {
			Statement st =null;
			//Creation of a statement
			st = this.cn.createStatement();
			//SQL query which load a product according to its id
			String sql = "Select * From LotuZ.Product Where idProduct='"+idP+"'";
			//query running
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
			//creation of a statement
			st = this.cn.createStatement();
			//SQL query which insert a product in the database
			String sql = "Insert into Product (`name`, `quantity`, `prix`, `reduction`,`creationDate`, `updateDate`, `category`) VALUES ('"+ this.getProductName() +"','"+ this.getQuantity() +"','"+ this.getPrice()+"','"+ this.getReduction() +"','"+ this.getCreationDate() + "','"+ this.getUpdateDate() +"','"+ this.getCategory() +"')";
			//query running
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw e;
		}
	}

	public Product updateProduct(Product product) throws SQLException {
		try {		
			Statement st =null;
			//creation of a statement
			st = this.cn.createStatement();
			//SQL query which update a product in the database
			String sql = "UPDATE Product SET `name`='"+product.getProductName() +"',`category`='"+ product.getCategory() +"',`quantity`='"+product.getQuantity()+"',`updateDate`='"+ product.getUpdateDate() +"',`prix`='"+product.getPrice()+"',`reduction`='"+product.getReduction()+"' Where `idProduct`='"+product.getId() +"'";
			//query running
			st.executeUpdate(sql);	
		} catch (SQLException e) {
			throw e;
		}
		return this;
	}

	public void deleteProduct() throws SQLException {
		try {	
			Statement st =null;
			//creation of a statement
			st = this.cn.createStatement();
			//SQL query which delete a product in the database
			String sql = "DELETE FROM LotuZ.Product WHERE `idProduct`='"+this.getId()+"'";
			//query running
			st.executeUpdate(sql);	
		} catch (SQLException e) {
			throw e;
		}
	}

	private static Product getAndCreateProduct(ResultSet result) throws SQLException {
		ProductJDBC product = null;
		while( result.next() ){	
			int id = result.getInt("idProduct");
			String productName = result.getString("name");
			int category = result.getInt("category");
			int quantity = result.getInt("quantity");
			int price = result.getInt("prix");
			int reduction = result.getInt("reduction");
			String creationDate = result.getString("creationDate");
			String updateDate = result.getString("updateDate");

			product = new ProductJDBC(id,productName,category,quantity,price,reduction,creationDate,updateDate);
		}
		return product;
	}	

	@Override
	public List<Product> loadAllProducts(int idCategory) throws SQLException {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Product> products = new ArrayList();

		Statement st =null;
		//creation of a statement
		st = this.cn.createStatement();
		//SQL query which load all products according to its id
		String sql = "Select * From LotuZ.Product where `category`='"+idCategory+"'";
		//query running
		ResultSet result = st.executeQuery(sql);

		while( result.next() ){	
			ProductJDBC product = null;
			int idProduct = result.getInt("idProduct");
			String ProductName = result.getString("name");
			int quantity = result.getInt("quantity");
			int category = result.getInt("category");
			int price = result.getInt("prix");
			int reduction = result.getInt("reduction");
			String creationDate = result.getString("creationDate");
			String updateDate = result.getString("updateDate");


			product = new ProductJDBC (idProduct,ProductName,category,quantity,price,reduction, creationDate,updateDate);
			products.add(product);
		}
		return products;
	}


}
