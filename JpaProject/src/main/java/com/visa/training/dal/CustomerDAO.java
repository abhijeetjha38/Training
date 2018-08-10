package com.visa.training.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.visa.training.domain.Customer;
import com.visa.training.util.JpaUtil;

public class CustomerDAO {

    
    public void delete(int id)
    {
        EntityManager em= JpaUtil.getEmf().createEntityManager();
        Customer p= em.find(Customer.class, id);
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        em.remove(p); // does insert into the table // persistent state
        tx.commit();
        em.close(); //return back transaction
        
    }
    
    public void changeName(int id, String newName)
    {
        EntityManager em= JpaUtil.getEmf().createEntityManager();
        Customer p= em.find(Customer.class, id);
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        p.setFirstname(newName);
        //em.remove(p); // does insert into the table // persistent state
        tx.commit();
        em.close(); //return back transaction //detached
        
    }
    
    public Customer findOne(int id)
    {
        EntityManager em= JpaUtil.getEmf().createEntityManager();
        Customer p= em.find(Customer.class, id);
        em.close();
        return p;
        
    }
    public Customer addNew(Customer p){ //transient
        
        EntityManagerFactory emf = JpaUtil.getEmf();
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        em.persist(p); // does insert into the table // persistent state
        tx.commit();
        em.close(); // bcz it was an expensive operation to have it long //detached
        
        return p; //returning a detahced object
    }
}
