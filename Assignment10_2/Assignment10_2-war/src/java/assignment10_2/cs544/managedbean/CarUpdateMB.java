/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10_2.cs544.managedbean;

import assignment10_2.cs544.entity.Car;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

/**
 *
 * @author midou
 */
@Named(value = "carUpdateMB")
@RequestScoped
public class CarUpdateMB {

    //@PersistenceContext(unitName="Assignment10-warPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Car car = new Car();
    private int carId;
    //private Car carToUpdate = null;
    //Car carToUpdate;
    
    public CarUpdateMB() {
        emf = Persistence.createEntityManagerFactory("Assignment10_2-warPU");
        em = emf.createEntityManager();
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
    
    
    public void search()
    {
        Car carToUpdate = em.find(Car.class, carId);
        if(carToUpdate == null)
        {
            System.out.println("Car not found");
            return;
        }
        
        car = carToUpdate;
    }
    
    @Transactional
    public void update()
    {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Car carToUpdate = em.find(Car.class, carId);
        em.lock(carToUpdate, LockModeType.OPTIMISTIC);
        //System.out.println("CarToUpdate id: "+ carToUpdate.getId());
        //System.out.println("Car id: "+ car.getId()+" "+car);
        if(carToUpdate == null)
        {
            System.out.println("Car not found");
            em.close();
            emf.close();
            return;
        }
        carToUpdate.setMake(car.getMake());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setMiles(car.getMiles());
        carToUpdate.setYear(car.getYear());
        carToUpdate.setColor(car.getColor());
        //car = carToUpdate; //To be able to display in to the field
        
        System.out.println("Car to update: "+ car);
        em.persist(carToUpdate);
        tx.commit();
        em.close();
        emf.close();
        System.out.println("Car updated sucessfully");
    }
}
