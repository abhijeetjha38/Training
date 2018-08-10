package com.visa.training.dal;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.visa.training.domain.Product;

public class ProductDAOTest {
	@Test
	public void addNewInsertsARowAndReturnsProductWithId() {
		ProductDAO  dao = new  MysqlProductDAO();
		Product p = new Product("Iphone", (float) 2343.9, 0) ;
		dao.addNew(p);
		System.out.println("Added Product :"+p);
		assertTrue(p.getInd()>0) ;
	}
}
// Roll back after test !! 
// the extra element you have inserted 
// or set up a test  DB