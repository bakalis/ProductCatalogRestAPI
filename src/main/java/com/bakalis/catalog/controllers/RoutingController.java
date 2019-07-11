package com.bakalis.catalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakalis.catalog.models.Product;
import com.bakalis.catalog.models.ProductImage;
import com.bakalis.catalog.models.ProductSpecification;
import com.bakalis.catalog.services.ProductsCrudService;
import com.bakalis.catalog.services.HibernateUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoutingController {
	
	@Autowired
	ProductsCrudService productsService;
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productsService.getAllProducts();
	}
	

	
	@PostMapping("/products")
	public void saveProduct(@ModelAttribute("product")Product product){
		productsService.addProduct(product);
		System.out.println("Request Happened!");
	}
	
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id){
		return productsService.getProductById(id);
	}
	
	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable int id, @ModelAttribute("product") Product product){
		productsService.updateProduct(id, product);
	}
	
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id){
		productsService.deleteProduct(id);
	
	}
	
	@GetMapping("/products/{id}/images")
	public List<ProductImage> getImages(@PathVariable int id){
		return productsService.getImages(id);	
	}
	
	@PostMapping("/products/{id}/images")
	public void addImage(@PathVariable int id, @ModelAttribute("image") ProductImage img){
		productsService.addImage(id,img);
	}
	
	@GetMapping("/products/{productId}/images/{id}")
	public ProductImage getImage(@PathVariable int id){
		return productsService.getImage(id);
	}
	
	@DeleteMapping("/products/{productId}/images/{id}")
	public void deleteImage(@PathVariable int id){
		productsService.deleteImage(id);
	}
	
	
	@GetMapping("/products/{id}/specifications")
	public List<ProductSpecification> getSpecifications(@PathVariable int id){
		return productsService.getSpecifications(id);
	}
	
	@PostMapping("/products/{id}/specifications")
	public void addSpecification(@PathVariable int id,
			@ModelAttribute("specification") ProductSpecification specification){
		
		productsService.addSpecification(id,specification);
	}

}
