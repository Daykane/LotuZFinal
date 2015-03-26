package com.LotuZ.product.category.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;

public class ListCategoryJDBC extends ListCategoryProduct 
{

	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	/**
	 * @param cn
	 */
	public ListCategoryJDBC(Connection cn) 
	{
		this.cn = cn;
	}
	
	/**
	 * @param listActivityLeader
	 */
	public ListCategoryJDBC(List<CategoryProduct> listCategoryJDBC) 
	{
		super(listCategoryJDBC);
	}



	

	public ListCategoryProduct load() throws SQLException
	{
		
		// On d�clare une liste d'utilisateurs 
		List<CategoryProduct> categorieS = new ArrayList<CategoryProduct>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.Category";

			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while( result.next() ){	
				// Cr�ation et ajout d'un utilisateurs dans la liste 
				categorieS.add( map(result));
			}
		} catch (SQLException e) {
				throw e;
		}
		ListCategoryProduct categories = new ListCategoryJDBC(categorieS);
		return categories;
	}
	
	public ListCategoryProduct load(int levelCategory) throws SQLException
	{
		
		// On d�clare une liste d'utilisateurs 
		List<CategoryProduct> categorieS = new ArrayList<CategoryProduct>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.Category Where levelCategory="+levelCategory;

			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while( result.next() ){	
				// Cr�ation et ajout d'un utilisateurs dans la liste 
				categorieS.add( map(result));
			}
		} catch (SQLException e) {
				throw e;
		}
		ListCategoryProduct categories = new ListCategoryJDBC(categorieS);
		return categories;
	}

	public ListCategoryProduct loadSubCategories() throws SQLException
	{
		// On d�clare une liste d'utilisateurs 
		List<CategoryProduct> subCategorieS = new ArrayList<CategoryProduct>();

			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.Category Where levelCategory="+1;

			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while( result.next() ){	
				// Cr�ation et ajout d'un utilisateurs dans la liste 
				subCategorieS.add( map(result));
			}
		
		ListCategoryProduct subCategories = new ListCategoryJDBC(subCategorieS);
		return subCategories;
		
	}
	
	public ListCategoryProduct loadSubCategories(int idFatherCategoryProduct) throws SQLException
	{
		// On d�clare une liste d'utilisateurs 
		List<CategoryProduct> subCategorieS = new ArrayList<CategoryProduct>();

			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.Category Where fatherCategory="+idFatherCategoryProduct;

			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while( result.next() ){	
				// Cr�ation et ajout d'un utilisateurs dans la liste 
				subCategorieS.add( map(result));
			}
		
		ListCategoryProduct subCategories = new ListCategoryJDBC(subCategorieS);
		return subCategories;
		
	}
	
	
	
    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static CategoryProduct map( ResultSet resultSet ) throws SQLException {
    	// On cr��e un utlisateur 
    	CategoryProduct category = new CatgeoryJdbc();
    	
    	// On lui ajoute ses attributs � partir des r�sultats de la requ�te
    	category.setIdCategoryProduct(resultSet.getInt("idCategory"));
    	category.setNameCategory(resultSet.getString("nameCategory"));
    	category.setDecriptionCategory(resultSet.getString("descriptionCategory"));
    	category.setLevelCategory(resultSet.getInt("levelCategory"));
    	category.setFactherCategory(resultSet.getInt("fatherCategory"));
        return category;
    }

}
