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
    private EntityTransaction tx;
    
    public MyCRUD()
    {
        emf = Persistence.createEntityManagerFactory("Assignment6-warPU");
        em = emf.createEntityManager();
    }
    
    public Car search(int id)
    {
        Car carFind = em.find(Car.class, id);
        //tx = em.getTransaction();
        //tx.begin();
        
        //tx.commit();
        close();
        return carFind;
    }
    
    public void save(Car car)
    {
        tx = em.getTransaction();
        tx.begin();
        em.persist(car);
        tx.commit();
        
        close();
        
    }
    
    public Car update(Car car)
    {
        Car carUpdated = em.find(Car.class, car.getId());
        System.out.println(carUpdated);
        System.out.println(carUpdated.getMake());
        //System.out.println("tx: "+tx);
        tx = em.getTransaction();
        tx.begin();
        //tx.commit();
        //carUpdated = em.find(Car.class, id);
        System.out.println(carUpdated);
        if(carUpdated != null)
        {
            System.out.println(car.getColor());
            em.merge(car);
            //em.persist(car);
            //em.persist(carUpdated);
        }
        tx.commit();
        close();
        
        return carUpdated;
    }
    
    public Car delete(int id)
    {
        Car carDeleted;
        tx = em.getTransaction();
        tx.begin();
        
        carDeleted = em.find(Car.class, id);
        System.out.println("Car delete: "+carDeleted);
        if(carDeleted != null)
        {
            em.remove(carDeleted);
        }
        tx.commit();
        close();
        return carDeleted;
        
    }
    
    public void close()
    {
        em.close();
        emf.close();
        tx = null;
        em = null;
        emf = null;
    }
}
