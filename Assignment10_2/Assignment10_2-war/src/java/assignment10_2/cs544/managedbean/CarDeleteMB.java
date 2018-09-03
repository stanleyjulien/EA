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
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
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
    private EntityManager em;
    
    private Car car = new Car();
    private int carId = 0;
    private List<Car> cars = new ArrayList<>();
    
    public CarDeleteMB() {
        //cars = getCars();
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
    
    @Transactional
    public void delete()
    {
        Car carToDelete = em.find(Car.class, carId);
        em.lock(carToDelete, LockModeType.OPTIMISTIC);
        System.out.println("CarToDelete: "+carToDelete);
        if(carToDelete == null)
            return ;
        
        
        
        em.remove(carToDelete);
        getCars();
    }
    
    public List<Car> getCars()
    {
        String jpql = "Select c from Car c";
        TypedQuery<Car> query = em.createQuery(jpql, Car.class);
        cars = query.getResultList();
        return cars;
    }
    

}
