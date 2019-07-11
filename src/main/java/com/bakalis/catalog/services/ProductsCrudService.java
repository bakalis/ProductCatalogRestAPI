package com.bakalis.catalog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakalis.catalog.models.Product;
import com.bakalis.catalog.models.ProductImage;
import com.bakalis.catalog.models.ProductSpecification;

@Service
public class ProductsCrudService {

	@Autowired
	private ProductsRepository repo;
	
	
	public List<Product> getAllProducts(){
		List<Product> list = new ArrayList<Product>();
		repo.findAll().forEach(list::add);
		return list;
	}

	
	public Product getProductById(int id){
		return (Product) repo.findById(id);//.get();
	}
	
	public void addProduct(Product product){
		repo.save(product);
	}
	
	public void updateProduct(int id, Product product){
		repo.save(product);
	}
	
	public void deleteProduct(int id){
		repo.deleteById(id);
	}

	public List<ProductImage> getImages(int id) {
		return repo.getImages(id);
		
	}
	
	public ProductImage getImage(int id){
		return repo.getImage(id);
	}

	public void addImage(int id, ProductImage img) {
		repo.addImage(id,img);
		
	}
	
	public void deleteImage(int id){
		repo.deleteImage(id);
	}

	public List<ProductSpecification> getSpecifications(int id) {
		return repo.getSpecifications(id);
	}

	public void addSpecification(int id, ProductSpecification specification) {
		repo.addSpecification(id,specification);
		
	}
}
