package com.LotuZ.product.category.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public int generateId() throws SQLException
	{
		int idGenerated=0;
		try 
		{		
			
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select generatedIdCategory From LotuZ.generateIdCategory";
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			System.out.println(idGenerated);
			System.out.println(sql);
			
			while(result.next())
			{	
				System.out.println("generatedIdCategory");
				idGenerated = result.getInt("generatedIdCategory");
				System.out.println(idGenerated); 
			}
			System.out.println(idGenerated);
			idGenerated++;
			System.out.println(idGenerated);
			// Requ�te de s�lection � partir de l'identifiant 
			String sql1 = "Update LotuZ.generateIdCategory Set generatedIdCategory="+idGenerated+" Where idgenerateIdCategory="+0;
			System.out.println("cJDBC3");
			// Ex�cution de la requ�te
			st.executeUpdate(sql1);
			System.out.println("cJDBC4");
					
		} 
		catch (SQLException e) 
		{
			throw e;
		}
		return idGenerated;
	}
	
	public CategoryProduct load(int idCategoryProduct) throws SQLException
	{
		try 
		{
				List<String> CategoryProduct = new ArrayList<String>();
			
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.Category where idCategory="+idCategoryProduct;
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while(result.next()){	
				this.setIdCategoryProduct(result.getInt("idCategory"));
				this.setNameCategory(result.getString("nameCategory"));
				this.setDecriptionCategory(result.getString("descriptionCategory"));
				this.setLevelCategory(result.getInt("levelCategory"));
				this.setFactherCategory(result.getInt("fatherCategory"));
			}
		} 
		catch (SQLException e) 
		{
			throw e;
		}
		return this;
		
	}
	
	public void update(int id, String name, String description, int level, int father) throws SQLException
	{		
			System.out.println("cJDBC1");
			
			Statement st =null;
			System.out.println("cJDBC1'");
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			System.out.println("cJDBC2");
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Update LotuZ.Category Set nameCategory='"+name+"', descriptionCategory='"+description+"',levelCategory="+level+",fatherCategory="+father+" Where idCategory="+id;
			System.out.println("cJDBC3");
			// Ex�cution de la requ�te
			st.executeUpdate(sql);
			System.out.println("cJDBC4");
		
	}
	
	public void save() throws SQLException 
	{
		try {

			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			String sql = "INSERT INTO LotuZ.Category VALUES "
					+ "("
					+this.getIdCategoryProduct()+","
					+this.getNameCategory()+","
					+this.getDecriptionCategory()+","
					+this.getLevelCategory()+","
					+this.getFactherCategory()+")";
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			}
		 catch (SQLException e) 
		{
			throw e;
		}
	}
	
	public void save(int id, String name, String description, int level, int father) throws SQLException 
	{
		try {		
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			String sql = "INSERT INTO LotuZ.Category VALUES "
					+ "("
					+id+","
					+'"'+name+'"'+","
					+'"'+description+'"'+","
					+level+","
					+father+")";
			// Ex�cution de la requ�te
			System.out.println(sql);
			int result = st.executeUpdate(sql);
			}
		 catch (SQLException e) 
		{
			throw e;
		}
	}

	@Override
	public void delete(int idCategoryProduct) throws SQLException 
	{
		System.out.println("cJDBC1");
			System.out.println("cJDBC2");
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			//String sql = "Select * From LotuZ.Category where idCategory="+idCategoryProduct;
			String sql = "Delete From LotuZ.Category where idCategory="+idCategoryProduct;	// pour réaliser un suppression il faut utiliser "executeUpdate" et non pas executeQuery " 	
			System.out.println(sql);
			// Ex�cution de la requ�te
			int result = st.executeUpdate(sql);
			System.out.println("cJDBC3");
			
	}


}
