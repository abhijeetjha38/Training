package com.visa.training.dal;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.domain.Customer;
import com.visa.training.domain.SavingsAccount;
import com.visa.training.util.JpaUtil;

public class AssociationDemo {

	public static void main(String[] args) {
		createNewAccountWithNewCustomer();

	}

	private static void createNewAccountWithNewCustomer() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer( "fn" , "mn" , "ln" , new Date(System.currentTimeMillis()) );
		
		
		SavingsAccount sa = new SavingsAccount(1999999) ;
		// i want to say this account belongs to this customer 
		sa.setCustomer(c);
		em.persist(c);
		tx.commit();
		em.close();
		// you need to keep killing these jvm processes !! 
	}

}
