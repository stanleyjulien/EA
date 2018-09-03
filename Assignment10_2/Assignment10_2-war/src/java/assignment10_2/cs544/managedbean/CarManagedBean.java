/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10_2.cs544.managedbean;

import assignment10_2.cs544.entity.Car;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author midou
 */
@Named(value = "carManagedBean")
@RequestScoped
public class CarManagedBean {

    
    private Car car;
    
    public CarManagedBean() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public String homePage()
    {
        return "index";
    }
    
    public void delete()
    {
        
    }
    
    public void insert()
    {
        
    }
    
    public void update()
    {
        
    }
}
