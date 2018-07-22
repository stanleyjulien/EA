/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymain;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import myentity.Laptop;
import myentity.Notebook;
import myentity.Student;
import myentity.Teacher;

/**
 *
 * @author midou
 */
public class MainTest {
    
    
    public static void main(String[] arg)
    {
        Student student1 = new Student("Jack", 3.4);
        Student student2 = new Student("John", 3.2);
        Student student3 = new Student("Jill", 3.6);
        Teacher teacher1 = new Teacher("Jim", 45000);
        Teacher teacher2 = new Teacher("Jasmin", 46000);
        
        
        //Create EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment4PU");
        EntityManager em = emf.createEntityManager();
        
        //Create Transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Persist object
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(teacher1);
        em.persist(teacher2);
        
        //Commit the transaction
        tx.commit();
        
        Laptop laptop1 = new Laptop("Dell");
        Laptop laptop2 = new Laptop("Mac");
        
        Notebook notebook1 = new Notebook(100);
        Notebook notebook2 = new Notebook(120);
        Notebook notebook3 = new Notebook(60);
        Notebook notebook4 = new Notebook(200);
        Notebook notebook5 = new Notebook(50);
        Notebook notebook6 = new Notebook(300);
        
        student1.setNotebook(Arrays.asList(notebook1, notebook2, notebook3));
        student2.setNotebook(Arrays.asList(notebook4, notebook5));
        student3.setNotebook(Arrays.asList(notebook6));
        teacher1.setLaptop(laptop1);
        teacher2.setLaptop(laptop2);
        
        //Persist object
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(teacher1);
        em.persist(teacher2);
        
        //Commit the transaction
        tx.commit();
        
        
        //Close the ressource
        em.close();
        emf.close();
        
    }
}
