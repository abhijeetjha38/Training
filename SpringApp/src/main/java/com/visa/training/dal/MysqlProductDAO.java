package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Product;
//import com.visa.training.util.JpaUtil;
// if only @Transactional then transaction applied to all the classes which is  not good 
// otherwise add (propagation="xyz")
@Component("mydao")
@Transactional()    // i am telling spring that please tc of all my transactions 
public class MysqlProductDAO implements ProductDAO {
	/* (non-Javadoc)
	 * @see com.visa.training.dal.ProductDAO#delete(int)
	 */
	@Autowired
	EntityManager em ; // no entity manager factory is a bean
	@Override
	public void delete(int id) {
		//EntityManager em = JpaUtil.getEmf().createEntityManager();
		// here since the object is in persistent state untill transaction commited 
		// remember herre transaction is already there 
		// in which ever layer we put transactional it starts and end there 
		
		Product p = em.find(Product.class,id) ;    // data type,  id .. .class for data type
		//EntityTransaction tx = em.getTransaction();
	//	tx.begin();
		em.remove(p);
		//tx.commit();
		//em.close();
	}
	/* (non-Javadoc)
	 * @see com.visa.training.dal.ProductDAO#changePrice(int, float)
	 */
	@Override
	public void changePrice(int id, float newPrice) {
		//EntityManager em = JpaUtil.getEmf().createEntityManager();
		//EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class,id) ;    // data type,  id .. .class for data type .. if we are not able to find the object null will be returned and null pointer exception 
	//	tx.begin();
		p.setPrice(newPrice);
	//	tx.commit();
		//em.close();
		
	}
	/* (non-Javadoc)
	 * @see com.visa.training.dal.ProductDAO#findOne(int)
	 */
	@Override
	public Product findOne(int id) {
		//EntityManager em = JpaUtil.getEmf().createEntityManager();
		Product p = em.find(Product.class,id) ;    // data type,  id .. .class for data type
		//em.close() ;
		return p ;
	}
	/* (non-Javadoc)
	 * @see com.visa.training.dal.ProductDAO#addNew(com.visa.training.domain.Product)
	 */
	@Override
	public Product addNew(Product P) {
	//	EntityManagerFactory emf = JpaUtil.getEmf();
		//EntityManager em  = emf.createEntityManager(); // this has a db connection and its costly 
		// begin transaction 
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		em.persist(P);
		//tx.commit();
		//em.close();
		return P;
		
	}
	/* (non-Javadoc)
	 * @see com.visa.training.dal.ProductDAO#findAll()
	 */
	@Override
	public List<Product> findAll(){
        //EntityManager em = JpaUtil.getEmf().createEntityManager();
        
        Query q= em.createQuery("select p from Product p ");
        List<Product> ll= q.getResultList();
        //em.close();
        return ll;
    }

}
