/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.assignment6.stanley.model.carmodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

/**
 *
 * @author midou
 */
public class MyCRUD {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public MyCRUD()
    {
        emf = Persistence.createEntityManagerFactory("Assignment6-warPU");
        em = emf.createEntityManager();
    }
    
    public void save(Car car)
    {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(car);
        tx.commit();
        
        em.close();
        emf.close();
        em = null;
        emf = null;
    }
}
