package com.bakalis.catalog.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import com.bakalis.catalog.models.Product;
import com.bakalis.catalog.models.ProductImage;
import com.bakalis.catalog.models.ProductSpecification;

@Repository
public class ProductsRepository{
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session;
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		session = factory.openSession();
		session.beginTransaction();
		List<Product> list = (List<Product>) session.createQuery("from Product").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public Product findById(int id) {
		session = factory.openSession();
		session.beginTransaction();
		
		Product returned = (Product) session.get(Product.class, id);
		
		session.getTransaction().commit();
		session.close();
		return returned;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.beginTransaction();
		Product testable = session.get(Product.class, product.getProductId());
		session.getTransaction().commit();
		session.close();
		if(testable == null){
			session = factory.openSession();
			session.beginTransaction();
			session.save(product);
		}else{
			session = factory.openSession();
			session.beginTransaction();
			session.update(product);
		}
		System.out.println(testable);	
		
		session.getTransaction().commit();
		session.close();
	}

	public void deleteById(int id) {
		session = factory.openSession();
		session.beginTransaction();
		
		Product deleted = session.get(Product.class, id);
		session.delete(deleted);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<ProductImage> getImages(int id) {
		session = factory.openSession();
		session.beginTransaction();
		List<ProductImage> list = (List<ProductImage>) session.createQuery("from ProductImage where productId = "+String.valueOf(id)).list();
			
		session.getTransaction().commit();
		session.close();
		
		return list;
		
	}
	
	public ProductImage getImage(int id){
		session = factory.openSession();
		session.beginTransaction();
		
		ProductImage img = session.get(ProductImage.class, id);
		
		session.getTransaction().commit();
		session.close();
		return img;
	}

	public void addImage(int id, ProductImage img) {
		session = factory.openSession();
		session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		img.setProduct(product);
		session.save(img);
		
		session.getTransaction().commit();
		session.close();
	}
	
	

	public void deleteImage(int id) {
		session = factory.openSession();
		session.beginTransaction();
		
		ProductImage img = session.get(ProductImage.class, id);
		session.delete(img);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<ProductSpecification> getSpecifications(int id) {
		session = factory.openSession();
		session.beginTransaction();
		
		List<ProductSpecification> list = (List<ProductSpecification>) 
				session.createQuery("from ProductSpecification where productId = "+String.valueOf(id)).list();
		
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public void addSpecification(int id, ProductSpecification specification) {
		session = factory.openSession();
		session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		specification.setProduct(product);
		session.save(specification);
		
		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteSpecification(int id) {
		session = factory.openSession();
		session.beginTransaction();
		
		ProductSpecification spec = session.get(ProductSpecification.class, id);
		session.delete(spec);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
