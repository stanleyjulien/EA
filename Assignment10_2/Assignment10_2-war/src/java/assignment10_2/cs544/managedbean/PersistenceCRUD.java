/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10_2.cs544.managedbean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author midou
 */
public class PersistenceCRUD {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersistenceCRUD()
    {
        emf = Persistence.createEntityManagerFactory("Assignment10_2-warPU");
        em = emf.createEntityManager();
    }
    
    
    //public void 
    
}
