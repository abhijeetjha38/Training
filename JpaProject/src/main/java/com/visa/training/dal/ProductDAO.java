package com.visa.training.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.visa.training.domain.Product;
import com.visa.training.util.JpaUtil;


public class ProductDAO {
	public void delete(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Product p = em.find(Product.class,id) ;    // data type,  id .. .class for data type
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(p);
		tx.commit();
		em.close();
	}
	public void changePrice(int id, float newPrice) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class,id) ;    // data type,  id .. .class for data type .. if we are not able to find the object null will be returned and null pointer exception 
		tx.begin();
		p.setPrice(newPrice);
		tx.commit();
		em.close();
		
	}
	public Product findOne(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Product p = em.find(Product.class,id) ;    // data type,  id .. .class for data type
		em.close() ;
		return p ;
	}
	public Product addNew(Product P) {
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em  = emf.createEntityManager(); // this has a db connection and its costly 
		// begin transaction 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(P);
		tx.commit();
		em.close();
		return P;
		
	}

}
