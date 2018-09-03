/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentbook;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author midou
 */
public class Main {
    
    public static void main(String[] arg)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticeOneToManyPU");
        EntityManager em = emf.createEntityManager();
        
        Student jack = new Student("Jack");
        Student jean = new Student("Jean");
        Book javaEE = new Book("Java EE", 575);  
        //jack.addBook(javaEE);
        //Book jsf = new Book("Java Server Faces", 300);
        //jack.addBook(jsf);
        jean.addBook(javaEE);
        
        /*EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(javaEE);
        //em.persist(jsf);
        //em.persist(jack);
        em.persist(jean);
        
        
        tx.commit();
        */
        
        //JPQL
       
        /*TypedQuery<Book> query = 
                em.createQuery("select b from Book b"
                        + " inner join ", Book.class);
        List<Book> books = query.getResultList();
        System.out.println( books);
        
        for(Book b : books)
        {
            System.out.println( b);
        }
        */
        //JPQL
        Query query = em.createQuery("select s from Student.books s ");
        //query.setParameter(1,"Java EE");
        
        List<Book> books = query.getResultList();
        for(Book book : books)
        {
            System.out.println(book);
        }
        /*
        TypedQuery<Student> query = em.createQuery("Select c from Student c where c.name = :n ", Student.class);
        query.setParameter("n", "Jack");
        List<Student> students = query.getResultList();
        
        for(Student s : students)
        {
            System.out.println(s);
            for(Book b : s.getBooks())
            {
                System.out.println(b);
            }
        }
        
        */
        //NamedQuery
        /*TypedQuery<Book> query = em.createNamedQuery("allBook", Book.class);
        List<Book> books = query.getResultList();
        
        for(Book b : books)
        {
            System.out.println( b);
        }
        */
        
        //NativeQuery
        /*
        Query query = em.createNativeQuery("select * from book",Book.class);
        List<Book> books = query.getResultList();
        
        for(Book b : books)
        {
            System.out.println( b);
        }
        */
        
        //CriteriaBuilder builder = em.getCriteriatBuilder();
    }
}
