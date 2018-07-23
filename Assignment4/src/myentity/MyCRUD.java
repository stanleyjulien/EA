/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author midou
 */
public class MyCRUD {
    EntityManagerFactory emf ;
    EntityManager em;
    
    public MyCRUD()
    {
        emf = Persistence.createEntityManagerFactory("Assignment4PU");
        em = emf.createEntityManager();
    }
    
    public boolean deleteStudent(int studentId, EntityManager em, EntityTransaction tx)
    {
        boolean b = false;
        Student student = new Student();
        student.setId(studentId);
        //System.out.println(em.contains(student));
        if(em.contains(student) == true)
        {
            tx.begin();
            em.remove(student);
            tx.commit();
            b = true;
        }
        
        //em.close();
        
        //b = em.contains(studentId);
        return b;
    }
    
    public boolean deleteStudent(int id)
    {
        boolean exist = false;
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student student = em.find(Student.class, id);
        System.out.println(em.find(Student.class, id));
        //if(em.find(Student.class, id)!= null)
        if(student != null)
        {
            exist = true;
            em.remove(student);
        }
        tx.commit();
        
        em.close();
        emf.close();
        
        em = null;
        emf = null;
        return exist;
    }
}
