/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console.car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.sql.RowSetEvent; //javax.sql package for JDBC API


/**
 *
 * @author midou
 */
public class CarMain {
    
    public static void main(String[] args)
    {
        Car mercedes = new Car();
        mercedes.setMake("Mercedes");
        mercedes.setModel("Benz");
        mercedes.setYear(2018);
        mercedes.setColor("Blue");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticePU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(mercedes);
        tx.commit();
        
        em.close();
        emf.close();
    }
}
