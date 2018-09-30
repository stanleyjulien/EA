/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14.myejb.carejb;

import assignment14.myentity.carentity.Car;
import assignment14.mylog.mylogclass.LogControl;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author midou
 */
@Stateless
public class CarEJB {
    
    @PersistenceContext(unitName = "Assignment14-ejbPU")
    private EntityManager em;
    
    
    @PostConstruct
    @Interceptors(LogControl.class)
    public void init()
    {
        String s = "CarEJB called or created successfully by the container";
        System.out.println(s);
    }
    
    @Interceptors(LogControl.class)
    public Car create(Car car)
    {
        em.persist(car);
        return car;
    }
    
    @Asynchronous
    public void updateAll()
    {
        Query query = em.createQuery("update Car c set c.years = c.years+1");
        query.executeUpdate();
    }
    
    @Schedule(hour = "*", minute = "*")
    public void showNumOfCar2()
    {
        System.out.println(new Date());
        TypedQuery<Car> query = em.createNamedQuery("numOfCar", Car.class);
        int total = query.getResultList().size();
         
        System.out.println("Total car every minute in database: "+total);
        

    }
    
    @PreDestroy
    @Interceptors(LogControl.class)
    public void destruction()
    {
        String s = "CarEJB was destroyed success by the container";
        System.out.println(s);
    }
}
