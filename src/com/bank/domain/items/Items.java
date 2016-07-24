package com.bank.domain.items;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;

import com.bank.domain.category.Category;
import com.bank.domain.subcategory.Subcategory;

@Entity
@Table(name="items")
public class Items {
	private int id;
	private String itemName;
	private String itemImage;
	private String itemDesc;
	private String itemBrand;
	private double itemPrise;
	private Map<Integer,Subcategory> subcategories;
	private Category category;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="itemname")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Column(name="itemimage")
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	@Column(name="itemdesc")
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	@Column(name="itembrand")
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	@Column(name="itemprise",columnDefinition="double default 0.0")
	public double getItemPrise() {
		return itemPrise;
	}
	public void setItemPrise(double itemPrise) {
		this.itemPrise = itemPrise;
	}
	
//	@ManyToMany
//    @JoinColumn(name="id")
//	@JoinColumn(name="subcategoryid", referencedColumnName="subcategoryid", insertable=false, updatable=false)
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="subcategory_items", 
                joinColumns={@JoinColumn(name="item",referencedColumnName="id")}, 
                inverseJoinColumns={@JoinColumn(name="subcategory",referencedColumnName="subcategoryid")})
	@MapKey(name="subcategoryId")
	public Map<Integer, Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(Map<Integer, Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	
	@ManyToOne
	@JoinColumn(name="category", referencedColumnName="categoryid", insertable=false, updatable=false)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
