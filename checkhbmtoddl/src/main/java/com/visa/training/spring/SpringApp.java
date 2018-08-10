package com.visa.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

public class SpringApp {

	public static void main(String[] args) {
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Spring Container set up done !! ") ;
		// whenever you have new beens defined never use new !! 
		ProductService service = (ProductService) springContainer.getBean("service"); // the id of the bean you have given !! 
		// we do have different applications !! 
		System.out.println("Got service OBject from spring container ");
		Product test = new Product("spring",99,1000);
		Product created = service.addNew(test);
		System.out.println("Creatd Product with id :"+created.getInd());
		
	}

}
