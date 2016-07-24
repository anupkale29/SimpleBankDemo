package com.bank.domain.subcategory;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bank.domain.category.Category;
import com.bank.domain.items.Items;

@Entity
@Table(name="subcategory")
public class Subcategory {
	private int subcategoryId;
	private String subCategoryName;
	private String subCategoryImage;
	private String subCategoryDesc;
	private Category category;
	private Map<Integer,Items> items;
	
	@Id
	@GeneratedValue
	@Column(name="subcategoryid")
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	@Column(name="subcategoryname")
	public String getSubCategoryName() {
		return subCategoryName;
	}
	
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	@Column(name="subcategoryimage")
	public String getSubCategoryImage() {
		return subCategoryImage;
	}
	public void setSubCategoryImage(String subCategoryImage) {
		this.subCategoryImage = subCategoryImage;
	}
	@Column(name="subcategorydesc")
	public String getSubCategoryDesc() {
		return subCategoryDesc;
	}
	public void setSubCategoryDesc(String subCategoryDesc) {
		this.subCategoryDesc = subCategoryDesc;
	}
	@Column(name="items")
	@ManyToMany(mappedBy="subcategories")
	@MapKey(name="id")
	public Map<Integer, Items> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Items> items) {
		this.items = items;
	}

	@ManyToOne
//    @JoinColumn(name="id")
//	@JoinColumn(column="owner_name", referencedColumnName="name")
	@JoinColumn(name="category", referencedColumnName="categoryid", insertable=false, updatable=false)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
