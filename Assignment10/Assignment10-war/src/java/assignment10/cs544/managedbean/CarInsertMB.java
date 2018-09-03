/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10.cs544.managedbean;

import assignment10.cs544.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author midou
 */
@Named(value = "carInsertMB")
@RequestScoped
public class CarInsertMB {

    @PersistenceContext(unitName = "Assignment10-warPU")
    EntityManager em;
    private Car car = new Car();
    List<Car> cars = new ArrayList<>();
    
    public CarInsertMB() {
    }
    
    @Transactional
    public void insert()
    {
        System.out.println("Test car before: "+car);
        em.persist(car);
        System.out.println("Test car after: "+car);
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
