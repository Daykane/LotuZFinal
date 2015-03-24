package com.LotuZ.product.category.bl;

import java.sql.SQLException;

import com.LotuZ.user.activityLeader.bl.ActivityLeader;

/**
 * <b> CategoryProduct est la classe représentant les catégories des produits. </b>
 * <p> 
 * Les attributs de la classe CategoryProduct sont:
 * <ul>
 * <li> idCategoryProduct </li> 
 * <li> nameCategory </li> 
 * <li> decriptionCategory </li> 
 * <li> levelCategory </li> 
 * <li> factherCategory </li>
 * </ul>
 * </p>
 * 
 * @see Product 
 * 
 * @author Loïc
 * @version 1.0
 */

public abstract class CategoryProduct 
{
		
		/**
		 * idCategoryProduct est l'indentifiant de la categorie.
		 * Cet id n'est pas modifiable.
		 * Il est généré automatiquement lors de la création d'une nouvelle catégorie dans le système.
		 * 
		 * @see setIdCategoryProduct(int idCategoryProduct)
		 * @see getIdCategoryProduct()
		 * @see CategoryProduct(int id, String name, int level, int father)
		 *  
		 */
		private int idCategoryProduct;
		
		/**
		 * nameCategory est le nom de la catégorie.
		 * Ce nom est modifiable.
		 * Ce nom est entrée par l'utilisateur du système lors de la création ou la modification d'une categorie.
		 * 
		 * @see setNameCategoryProduct(int idCategoryProduct)
		 * @see getNameCategoryProduct()
		 * @see CategoryProduct(int id, String name, int level, int father)
		 */
		private String nameCategory;
		
		/**
		 * descriptionCategory est une courte description de la catégorie
		 * Cete description est modifiable.
		 * 
		 * @see setDescriptionCategoryProduct(int idCategoryProduct)
		 * @see getDescriptionCategoryProduct()
		 */
		private String decriptionCategory;
		
		/**
		 * levelCategory est le niveau hiérarchique de la catégorie.
		 * Ce niveau est modifiable.
		 * <p> 
		 * La norme choisit pour levelCategory est:
		 * <ul>
		 * <li> levelCategory == 0 : Catégorie </li> 
		 * <li> levelCategory >0 : Sous Catégorie</li> 
		 * </ul>
		 * </p>
		 * @see setLevelCategoryProduct(int idCategoryProduct)
		 * @see getLevelCategoryProduct()
		 * @see CategoryProduct(int id, String name, int level, int father)
		 */
		private int levelCategory;
		
		/**
		 * fatherCategory correspond à l'identifiant de la catégorie mère
		 * Cet id est modifiable
		 * <p> 
		 * La norme choisit pour fatherCategory est:
		 * <ul>
		 * <li> levelCategory == 0 : fatherCategory = 0 </li> 
		 * <li> levelCategory >0 : fatherCategory = father.getIdCategoryProduct() </li> 
		 * </ul>
		 * </p>
		 * @see setLevelCategoryProduct(int idCategoryProduct)
		 * @see getLevelCategoryProduct()
		 * @see CategoryProduct(int id, String name, int level, int father
		 */
		private int factherCategory; // 0 to a Category, idCategoryProduct to a subcategory ... to know the category above
		
						//Get
		/**
		 * @return idCategoryProduct
		 */
		public int getIdCategoryProduct() {
			return idCategoryProduct;
		}
		
		/**
		 * @return nameCategory
		 */
		public String getNameCategory() {
			return nameCategory;
		}
		
		/**
		 * @return decriptionCategory
		 */
		public String getDecriptionCategory() {
			return decriptionCategory;
		}
		
		/**
		 * @return levelCategory
		 */
		public int getLevelCategory() {
			return levelCategory;
		}
		
		/**
		 * @return factherCategory
		 */
		public int getFactherCategory() {
			return factherCategory;
		}
						//Set
		
		
		/**
		 * @param idCategoryProduct
		 */
		public void setIdCategoryProduct(int idCategoryProduct) {
			this.idCategoryProduct = idCategoryProduct;
		}
		
		/**
		 * @param nameCategory
		 */
		public void setNameCategory(String nameCategory) {
			this.nameCategory = nameCategory;
		}
		
		/**
		 * @param decriptionCategory
		 */
		public void setDecriptionCategory(String decriptionCategory) {
			this.decriptionCategory = decriptionCategory;
		}
		
		/**
		 * @param levelCategory
		 */
		public void setLevelCategory(int levelCategory) {
			this.levelCategory = levelCategory;
		}
		
		/**
		 * @param factherCategory
		 */
		public void setFactherCategory(int factherCategory) {
			this.factherCategory = factherCategory;
		}
		
						//Constructeur
		/**
		 * Constructeur CategoryProduct
		 * @param idCategoryProduct
		 * @param nameCategory
		 * @param levelCategory
		 * @param factherCategory
		 */
		public CategoryProduct(int id, String name, int level, int father)
		{
			this.idCategoryProduct = id;
			this.nameCategory = name;
			this.levelCategory = level;
			this.factherCategory = father;
		}
		
		/**
		 * Constructeur CategoryProduct avec decriptionCategory
		 * @param idCategoryProduct
		 * @param nameCategory
		 * @param decriptionCategory
		 * @param levelCategory
		 * @param factherCategory
		 */
		public CategoryProduct(int id, String name, String decription, int level, int father)
		{
			this.idCategoryProduct = id;
			this.nameCategory = name;
			this.decriptionCategory = decription;
			this.levelCategory = level;
			this.factherCategory = father;
		}
		
		public abstract CategoryProduct load(String idCategoryProduct) throws SQLException;
		public abstract CategoryProduct save() throws SQLException;
		public abstract CategoryProduct delete(String idCategoryProduct) throws SQLException;
		

}
