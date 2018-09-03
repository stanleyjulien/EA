/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author midou
 */
public class Main {
    
    public static void main(String[] arg)
    {
        Course eaCourse = new Course("EA5");
        Student jackStudent = new Student("Jack5", eaCourse, 3.6);
        StudentId studentId = new StudentId(123, "Jack", "Blan");
        //Student jackStudent = new Student(studentId, "Jack",eaCourse, 3.6);
        Address a = new Address("Port Charlotte", "FL", 33952);
        History h = new History("Good Student");
        //Student jackStudent = new Student(studentId, "Jack",eaCourse, 3.6, a);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticeLesson3OneToOnePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //em.persist(eaCourse);
        em.persist(jackStudent);
        
        tx.commit();
    }
}
