/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10_2.cs544.managedbean;

import assignment10_2.cs544.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author midou
 */
@Named(value = "carListMB")
@RequestScoped
public class CarListMB {

    //@PersistenceContext(unitName = "Assignment10-warPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private Car car = new Car();
    private List<Car> cars = new ArrayList<>();
    
    public CarListMB() {
        
        emf = Persistence.createEntityManagerFactory("Assignment10_2-warPU");
        em = emf.createEntityManager();
    }
    
    public List<Car> getCars()
    {
        //EntityTransaction tx = em.getTransaction();
        //tx.begin();
        String jpql = "Select c From Car c";
        TypedQuery<Car> query = em.createQuery(jpql, Car.class);
        cars = query.getResultList();
        //em.close();
        //emf.close();
        return cars;
    }
    
    public Car car()
    {
        return car;
    }
    
    
}
