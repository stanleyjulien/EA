/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12.managedbean;

import assignment12.entity.Car;
import assignment12.entity.LogCall;
import assignment12.myejb.CarBusiness;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author midou
 */
@Named(value ="carMB")
@RequestScoped
public class CarMB {
    
    private int id;
    private List<LogCall> logs;
    
    @EJB
    CarBusiness carBusiness; //= new CarEjb();
    
    
    Car car; //= new Car();
    
    public CarMB()
    {
        car = new Car();
        logs = new ArrayList<>();
    }
    
    
    public void save()
    {
        //System.out.println("Car Ejb "+carBusiness.getCheck());
        //System.out.println("Car "+car.getModel());
        car = carBusiness.save(car);
    }
    public void search()
    {
        car = carBusiness.search(id);
        //return car;
    }
    public void update()
    {
        System.out.println("Update car in carMB: "+car);
        //car.setMake(make);
        car = carBusiness.update(id, car);
        getCars();
    }
    public void delete()
    {
        car = carBusiness.delete(id);
        getCars();
    }
    public List<Car> getCars()
    {
        return carBusiness.getCars();
    }
    
    public List<LogCall> getLogs()
    {
        return carBusiness.logCars();
    }
    public void clearLogs()
    {
        carBusiness.clearLogs();
        getLogs();
    }
    public void clearCars()
    {
        carBusiness.clearCars();
    }
    public Car getCar()
    {
        return car;
    }

    
    public int getId()
    {
        return id;
    }
    
    

    /*public CarEjb getCarEjb()
    {
    System.out.println(carEjb.getCheck());
    return carEjb;
    }*/
    public void setId(int id) {
        this.id = id;
    }

    public int test() {
        return 2018;
    }
}