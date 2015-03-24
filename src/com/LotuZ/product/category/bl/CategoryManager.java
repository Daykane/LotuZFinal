package com.LotuZ.product.category.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.activity.Activity;

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
	
	public ListCategoryProduct getCategories()
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

}
