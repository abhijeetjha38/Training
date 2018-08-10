package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.dal.MysqlProductDAO;
import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;
@Component("service")
public class ProductService {
	ProductDAO dao ;//= new MysqlProductDAO();
	
	public ProductDAO getDao() {
		return dao;
	}
	@Autowired
	public void setDao(ProductDAO dao) {
		System.out.println("From within service. Got object of Dao");
		this.dao = dao;
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void changePrice(int id, float newPrice) {
		dao.changePrice(id, newPrice);
	}

	public Product findOne(int id) {
		return dao.findOne(id);
	}



	public List<Product> findAll() {
		return dao.findAll();
	}
	public Product addNew(Product p) {
		if( p.getPrice() * p.getQoh() >= 10000) {
			return dao.addNew(p);
		}
		else
		{
			// we need to provide businees failure cases !! 
			// returning null is not a wise choice here coz the UI man doesn't get to know that
			// where this error came from . either db is down or service fails 
			// this can be called from any position antm , bank, mobile app
			// so we want a reusable service layer 
			// if any error then error should be returned at ui client calling it !! 
			throw new InsufficientValueException("the value price *qoh must be at least 10k");
		}
	}
	
	
}
