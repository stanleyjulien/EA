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
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author midou
 */
@Named(value = "carDeleteMB")
@RequestScoped
public class CarDeleteMB {

    //@PersistenceContext(unitName="Assignment10-warPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private Car car = new Car();
    private int carId ;
    private List<Car> cars = new ArrayList<>();
    
    public CarDeleteMB() {
        //cars = getCars();
        emf = Persistence.createEntityManagerFactory("Assignment10_2-warPU");
        em = emf.createEntityManager();
    }
    public Car getCar()
    {
        return car;
    }
    
    public int getCarId()
    {
        return carId;
    }
    
    public void setCarId(int carId)
    {
        this.carId = carId;
    }
    
    //@Transactional
    public void delete()
    {
        Car carToDelete;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //emf = Persistence.createEntityManagerFactory("Assignment10_2-warPU");
        //em = emf.createEntityManager();
        System.out.print("Inside delete. CarId: "+ carId);
        carToDelete = em.find(Car.class, carId);
        System.out.println("Car to delete: "+ carToDelete);
        em.lock(carToDelete, LockModeType.OPTIMISTIC);
        System.out.println("CarToDelete: "+carToDelete);
        if(carToDelete == null)
        {
            //tx = null;
            //em.close();
            //emf.close();
            return ;
        }
        
        
        em.remove(carToDelete);
        tx.commit();
        getCars();
        //em.close();
        //emf.close();
    }
    
    public List<Car> getCars()
    {
        //EntityTransaction tx = em.getTransaction();
        //tx.begin();
        String jpql = "Select c from Car c";
        TypedQuery<Car> query = em.createQuery(jpql, Car.class);
        cars = query.getResultList();
        //tx.commit();
        //em.close();
        //emf.close();
        return cars;
    }
    

}
