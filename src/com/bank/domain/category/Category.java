package com.bank.domain.category;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bank.domain.items.Items;
import com.bank.domain.subcategory.Subcategory;

@Entity
@Table(name="category")
public class Category {
	private int categoryId;
	private String categoryName;
	private String categoryImage;
	private String categoryDesc;
	private boolean active=false;
	private Map<Integer,Subcategory> subcategories;
	private Map<Integer,Items> items;
	
	@Id
	@GeneratedValue
	@Column(name="categoryid")
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name="categoryname")
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Column(name="categoryimage")
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	@Column(name="categorydesc")
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	@MapKey(name="subcategoryId")
	@Column(name="subcategories")
	public Map<Integer, Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(Map<Integer, Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	@MapKey(name="id")
	@Column(name="items")
	public Map<Integer, Items> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Items> items) {
		this.items = items;
	}
	@Column(name="active",columnDefinition="boolean default false")
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
