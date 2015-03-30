package com.LotuZ.product.category.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.LotuZ.product.category.bl.CategoryProduct;

/**
 * <b> CatgeoryJdbc est la classe représentant les catégories des produits dans la base de données. </b>
 * <p>
 * CatgeoryJdbc héritent de CategoryProduct
 * Les attributs de la classe CatgeoryJdbc sont:
 * <ul>
 * <li> idCategoryProduct </li> 
 * <li> nameCategory </li> 
 * <li> decriptionCategory </li> 
 * <li> levelCategory </li> 
 * <li> factherCategory </li>
 * </ul>
 * </p>
 * 
 * @see CategoryProduct 
 * 
 * @author Loïc
 * @version 1.0
 */

public class CatgeoryJdbc extends CategoryProduct 
{
	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;

				//
	/**
	 * Constructeur CatgeoryJdbc
	 * @param idCategoryProduct
	 * @param nameCategory
	 * @param levelCategory
	 * @param factherCategory
	 */
	public CatgeoryJdbc(int id, String name, int level, int father)
	{
		super(id, name, level, father);
	}

	/**
	 * Constructeur CatgeoryJdbc avec decriptionCategory
	 * @param idCategoryProduct
	 * @param nameCategory
	 * @param decriptionCategory
	 * @param levelCategory
	 * @param factherCategory
	 */
	public CatgeoryJdbc(int id, String name, String decription, int level, int father)
	{
		super(id, name, decription, level, father);
	}
	
	public CatgeoryJdbc() {
		super();
	}
	
	public CatgeoryJdbc(Connection cn) 
	{
		this.cn = cn;
	}

	/**
	 * @param cn
	 * @throws SQLException 
	 */
	
	
	public CategoryProduct load(int idCategoryProduct) throws SQLException
	{
			
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.Category where idCategory="+idCategoryProduct;
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while(result.next())
			{	
				this.setIdCategoryProduct(result.getInt("idCategory"));
				this.setNameCategory(result.getString("nameCategory"));
				this.setDecriptionCategory(result.getString("descriptionCategory"));
				this.setLevelCategory(result.getInt("levelCategory"));
				this.setFactherCategory(result.getInt("fatherCategory"));
			}
				
		return this;
		
	}
	
	public void update(int id, String name, String description, int level, int father) throws SQLException
	{		
			
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Update LotuZ.Category Set nameCategory='"+name+"', descriptionCategory='"+description+"',levelCategory="+level+",fatherCategory="+father+" Where idCategory="+id;
			// Ex�cution de la requ�te
			st.executeUpdate(sql);
		
	}
	
	public void save() throws SQLException 
	{
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			String sql = "INSERT INTO LotuZ.Category (nameCategory,descriptionCategory,levelCategory,fatherCategory) VALUES  "
					+ "("
					+this.getNameCategory()+","
					+this.getDecriptionCategory()+","
					+this.getLevelCategory()+","
					+this.getFactherCategory()+")";
			// Ex�cution de la requ�te
			st.executeQuery(sql);
	}
	
	public void save(String name, String description, int level, int father) throws SQLException 
	{	
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			String sql = "INSERT INTO LotuZ.Category (nameCategory,descriptionCategory,levelCategory,fatherCategory) VALUES "
					+ "("
					+'"'+name+'"'+","
					+'"'+description+'"'+","
					+level+","
					+father+")";
			// Ex�cution de la requ�te
			st.executeUpdate(sql);
	}

	public void delete(int idCategoryProduct) throws SQLException 
	{
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			//String sql = "Select * From LotuZ.Category where idCategory="+idCategoryProduct;
			String sql = "Delete From LotuZ.Category where idCategory="+idCategoryProduct;	// pour réaliser un suppression il faut utiliser "executeUpdate" et non pas executeQuery " 	
			// Ex�cution de la requ�te
			st.executeUpdate(sql);
			
	}


}