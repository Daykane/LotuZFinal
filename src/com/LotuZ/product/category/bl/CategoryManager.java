package com.LotuZ.product.category.bl;

import java.sql.SQLException;


import com.LotuZ.PersistKit;


public class CategoryManager 
{
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
	
	public CategoryManager(PersistKit kit){
		this.setPkit(kit);
	}
	
	public ListCategoryProduct getAllCategories()
	{
		ListCategoryProduct categories = pkit.createListCategory();
		try {
			categories = categories.load();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;	
	}
	
	public ListCategoryProduct getCategories()
	{
		int levelCategory =0; // 
		ListCategoryProduct categories = pkit.createListCategory();
		try {
			categories = categories.load(levelCategory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;	
	}
	
	public ListCategoryProduct getSubCategories() 
	{
		ListCategoryProduct categories = pkit.createListCategory();
		try {
			categories = categories.loadSubCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	public ListCategoryProduct getSubCategories(int idFatherCategoryProduct) 
	{
		ListCategoryProduct categories = pkit.createListCategory();
		try {
			categories = categories.loadSubCategories(idFatherCategoryProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	public CategoryProduct getCategory(int idCategory) {
		CategoryProduct category = pkit.createCategory();
		try {
			category = category.load(idCategory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}

	public void createCategory(String nameCategory, String descriptionCategory, int levelCategory, int fatherCategory) 
	{
		CategoryProduct category = pkit.createCategory();
		try {
			category.save(nameCategory, descriptionCategory, levelCategory, fatherCategory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCategory(int idCategory, String nameCategory,
			String descriptionCategory, int levelCategory, int fatherCategory) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCategory(int idCategory) 
	{
		CategoryProduct category = pkit.createCategory();
		try {
			category.delete(idCategory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


//	public int generateId() {
//		int idCatGen = 0;
//		CategoryProduct category = pkit.createCategory();
//		try {
//			idCatGen = category.generateId();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return idCatGen;
//	}





}