package com.visa.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.visa.training.domain.Product;

class ProductServiceTest {

	@Test
	void test() {
		ProductService service = new ProductService();
		Product p = new Product("testProduct",10000,1) ;
		Product created = service.addNew(p); 
		// here add new  is not a good approach ..
		// its unit testing and we already tested the uao stuff .. i just want to test whether the service layers works or not !! 
		assertNotNull(created) ;
		assertTrue( created.getInd() > 0 );
	}

}
