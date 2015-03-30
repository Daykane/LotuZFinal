package com.LotuZ.product.category.bl;

import java.sql.SQLException;
import java.util.List;

import javax.swing.ComboBoxModel;

import com.LotuZ.user.user.bl.User;

/**
 * <b> ListCategoryProduct est la classe représentant une liste de CategoryProduct </b>
 * 
 * @see CategoryProduct 
 * 
 * @author Loïc
 * @version 1.0
 */

public abstract class ListCategoryProduct {
	
	/**
	 * On d�clare une liste de responsables d'activit�s 
	 */
	private List<CategoryProduct> listCategoryProduct;

	/**
	 * @param listActivityLeader
	 */
	public ListCategoryProduct(List<CategoryProduct> listCategoryProduct) 
	{
		this.listCategoryProduct = listCategoryProduct;
	}


	public ListCategoryProduct() 
	{
	}

	/**
	 * @return une liste de responsables d'activit�s
	 */
	public List<CategoryProduct> getListCategoryProduct()
	{
		return listCategoryProduct;
	}

	/**
	 * @param listActivityLeader
	 */
	public void setListCategoryProduct(List<CategoryProduct> listCategoryProduct) 
	{
		this.listCategoryProduct = listCategoryProduct;
	}


	/**
	 * @return une liste de responsables d'activit�s 
	 * @throws SQLException 
	 */
	public abstract ListCategoryProduct load() throws SQLException;


	public abstract ListCategoryProduct load(int levelCategory) throws SQLException;


	public abstract ListCategoryProduct loadSubCategories(int idFatherCategoryProduct) throws SQLException;
	
	public abstract ListCategoryProduct loadSubCategories() throws SQLException;

}