/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexampractice1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author midou
 */
public class MidtermExamPractice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User john = new User("John", "a@gm.com");
        User jack = new User("Jack", "l@gm.com");
        User job = new User("Job", "m@gm.com");
        User jean = new User("Jean", "b@gm.com");

        Roles r1 = new Roles("Administrator", "Admin");
        Roles r2 = new Roles("Simple User", "Simple");
        Roles r3 = new Roles("Creator User", "Creator");
        
        john.addRoles(r1);
        john.addRoles(r2);
        john.addRoles(r3);
        
        jack.addRoles(r1);
        jack.addRoles(r2);
        
        job.addRoles(r3);
        jean.addRoles(r3);
        
        r1.addUser(jean);
        r2.addUser(jack);
        r3.addUser(job);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MidtermExamPractice1PU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(john);
        em.persist(jack);
        em.persist(job);
        em.persist(jean);
        /*em.persist(r1);
        em.persist(r2);
        em.persist(r3);*/
        tx.commit();              
    }
    
}
