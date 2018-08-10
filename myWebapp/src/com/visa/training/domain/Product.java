package com.visa.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// DOM called domain object model 
// requirement for JPA here we will provide 
// by default mapped to class name 
@Entity                   
public class Product {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY ) // different db's have different ways to generate primary keys so provided 
	@Column(name="id")
	int ind ;
	String name ;
	// @column()  if the variable name is different from the column name 
	// we need to create persistent.xml file to tell jpa that which db to connect and all 
	float price ;
	int qoh ;
	public Product() {
		
	}
	public Product( String name, float price , int qoh) {
		this.name = name ;
		this.price = price ;
		this.qoh = qoh ;
	}
	public int getInd() {
		return ind;
	}
	public void setInd(int ind) {
		this.ind = ind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	@Override
	public String toString() {
		return "Product [ind=" + ind + ", name=" + name + ", price=" + price + ", qoh=" + qoh + "]";
	}
	
	

}
