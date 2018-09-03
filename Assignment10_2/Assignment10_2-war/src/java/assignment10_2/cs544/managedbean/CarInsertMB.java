/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10_2.cs544.managedbean;

import assignment10_2.cs544.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author midou
 */
@Named(value = "carInsertMB")
@RequestScoped
public class CarInsertMB {

    //@PersistenceContext(unitName = "Assignment10-warPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Car car = new Car();
    List<Car> cars = new ArrayList<>();
    
    public CarInsertMB() {
        emf = Persistence.createEntityManagerFactory("Assignment10_2-warPU");
        em = emf.createEntityManager();
    }
    
    //@Transactional
    public void insert()
    {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("Test car before: "+car);
        em.persist(car);
        tx.commit();
        System.out.println("Test car after: "+car);
        em.close();
        emf.close();
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public List<Car> gerCars()
    {
        return cars;
    }
}
