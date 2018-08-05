/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.assignment6.stanley.carmb;

import edu.mum.assignment6.stanley.model.carmodel.Car;
import edu.mum.assignment6.stanley.model.carmodel.MyCRUD;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


/**
 *
 * @author midou
 */
@Named(value = "carMB")
@RequestScoped
public class CarMB implements Serializable {

    /**
     * Creates a new instance of CarMB
     */
    
    private Car car = new Car();
    
    //@Inject
    private MyCRUD mycrud = new MyCRUD();
    
    public CarMB() {
    
    }

    public Car getCar() {
        return car;
    }

    /*public void setCar(Car car) {
        this.car = car;
    }*/

    /*public MyCRUD getMycrud() {
        return mycrud;
    }*/
    public void save()
    {
        //MyCRUD mycrud = new MyCRUD();
        mycrud.save(car);
    }
    
    public Car delete()
    {
        System.out.println("Id: "+car.getId());
        return mycrud.delete(car.getId());
    }
    /*public void setMycrud(MyCRUD mycrud) {
        this.mycrud = mycrud;
    }*/
    
    
}
