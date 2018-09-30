/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14.myejb.carejb;

import assignment14.myentity.carentity.Car;
import assignment14.mylog.mylogclass.LogControl;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
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
    
    @Resource
    TimerService timerService;
    
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
    
    public Car delete(int id)
    {
        Car car = em.find(Car.class, id);
        if(car != null)
            em.remove(car);
        return car;
    }
    public Car getCar(int id)
    {
        return em.find(Car.class, id);
    }
    public Car update(int id, Car newCar)
    {
        Car car = em.find(Car.class, id);
        if(car != null)
        {
            car.setModel(newCar.getModel());
            car.setMake(newCar.getMake());
            car.setMiles(newCar.getMiles());
            car.setColor(newCar.getColor());
            car.setYears(newCar.getYears());
            
            em.persist(car);
        }
        return car;
    }
    public List<Car> getCars()
    {
        TypedQuery<Car> query = em.createNamedQuery("numOfCar", Car.class);
        List<Car> cars = query.getResultList();
        return cars;
    }
    
    @Asynchronous
    public void updateAll()
    {
        /*Query query = em.createQuery("update Car c set c.years = c.years+1");
        query.executeUpdate();
        */
        
        Query query = em.createNamedQuery("numOfCar");
        List<Car> cars = query.getResultList();
        for(Car car : cars)
        {
            System.out.println("TimerService: "+timerService);
            int years = car.getYears();
            years = years+1;
            car.setYears(years);
            em.persist(car);
            //timerService.createTimer(1000, car);
            
        }
    }
    
    @Schedule(hour = "*", minute = "*")
    public void showNumOfCar2()
    {
        System.out.println(new Date());
        TypedQuery<Car> query = em.createNamedQuery("numOfCar", Car.class);
        int total = query.getResultList().size();
         
        System.out.println("Total car every minute in database: "+total);
        

    }
    
    public void test()
    {}
    @PreDestroy
    @Interceptors(LogControl.class)
    public void destruction()
    {
        String s = "CarEJB was destroyed success by the container";
        System.out.println(s);
    }
}
