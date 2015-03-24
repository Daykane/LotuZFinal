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

	/**
	 * @param cn
	 */
	
	public CategoryProduct load(String idCategoryProduct) throws SQLException
	{
		try {

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
		
		} catch (SQLException e) {
			throw e;
		}
		return this;
		
	}

	@Override
	public CategoryProduct save() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryProduct delete(String idCategoryProduct) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
