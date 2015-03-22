package com.LotuZ.product.category.data;

import java.sql.Connection;

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
	
	/**
	 * @param cn
	 */
//	public CatgeoryJdbc(Connection cn)
//	{
//		this.cn = cn;
//	}
//	
//					//
//	save()
//	{
//		
//	}
//
//	read()
//	{
//		
//	}
//	
//	update()
//	{
//		
//	}
//	
//	delete()
//	{
//		
//	}
}
