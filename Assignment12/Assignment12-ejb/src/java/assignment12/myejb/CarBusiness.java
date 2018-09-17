/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12.myejb;

import assignment12.entity.Car;
import assignment12.entity.LogCall;
import assignment12.myinterceptors.LoggingInterceptor;
import assignment12.persistences.Crud;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author midou
 */
@Stateful
public class CarBusiness {
    
    private int check = 85;
    
    @EJB
    private Crud crud ; //= new Crud();
    @EJB
    private LoggingInterceptor logging;
    @PersistenceContext(unitName = "Assignment12-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    public CarBusiness()
    {
        //crud = new Crud();
    }
    
    //private Car car;
    
    public Car save(Car car)
    {
        return crud.save(car);
        
        /*System.out.println("Inside Car Business class "+ car.getModel());
        System.out.println("Entity Manager: "+em);
        em.persist(car);*/
    }
    public Car search(int id)
    {
        return crud.search(id);
    }
    public Car update(int id, Car car)
    {
        return crud.update(id, car);
    }
    public Car delete(int id)
    {
        return crud.delete(id);
    }
    public void clearCars()
    {
        crud.clearCars();
    }
    public void clearLogs()
    {
        logging.clearLogs();
    }
    public List<Car> getCars()
    {
        return crud.getCars();
    }
    
    public List<LogCall> logCars()
    {
        return logging.logCars();
    }
    
    public int getCheck()
    {
        return check;
    }
}
