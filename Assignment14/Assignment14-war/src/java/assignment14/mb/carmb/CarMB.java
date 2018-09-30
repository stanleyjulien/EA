/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14.mb.carmb;

import assignment14.myejb.carejb.CarEJB;
import assignment14.myentity.carentity.Car;
import assignment15.mylog.mylogclass.LogControl;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author midou
 */
@Named(value = "carMB")
@RequestScoped
public class CarMB {
    
    //@Inject
    private Car car;
    
    @EJB
    private CarEJB carEJB;
    
    public Car getCar() {
        if(car == null)
        {
            return car = new Car();
        }
        return car;
    }
    
    //Action method
    @Interceptors(LogControl.class)
    public void create()
    {
        carEJB.create(car);
    }
    
    public void updateAll()
    {
        carEJB.updateAll();
    }
    
    public String getCarPage()
    {
        return "carPage";
    }
}
