package com.bakalis.catalog.services;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	       private static SessionFactory sessionFactory;

	       static {
	    	   
	            Configuration configuration = new Configuration();
	            configuration.addAnnotatedClass(com.bakalis.catalog.models.Product.class);
	            configuration.addAnnotatedClass(com.bakalis.catalog.models.ProductImage.class);
	            configuration.addAnnotatedClass(com.bakalis.catalog.models.ProductSpecification.class);
	            configuration.configure("hibernate.cfg.xml");
	            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	       }

	       public static SessionFactory getSessionFactory() {
	             return sessionFactory;
	       }
	    
}
