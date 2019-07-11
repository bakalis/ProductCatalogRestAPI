package com.bakalis.catalog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductSpecification {
	
	@Id
	@GeneratedValue
	private int specificationId;
	private String specificationTitle;
	private String specificationValue;
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	public int getSpecificationId() {
		return specificationId;
	}
	public void setSpecificationId(int specificationId) {
		this.specificationId = specificationId;
	}
	public String getSpecificationTitle() {
		return specificationTitle;
	}
	public void setSpecificationTitle(String specificationTitle) {
		this.specificationTitle = specificationTitle;
	}
	public String getSpecificationValue() {
		return specificationValue;
	}
	public void setSpecificationValue(String specificationValue) {
		this.specificationValue = specificationValue;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
