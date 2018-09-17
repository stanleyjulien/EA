/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12.persistences;

import assignment12.entity.Car;
import assignment12.entity.LogCall;
import assignment12.myinterceptors.LoggingInterceptor;
import java.util.List;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author midou
 */
@Stateful
public class Crud {
    
    //private EntityManagerFactory emf; 
    //@Inject
    @PersistenceContext(unitName = "Assignment12-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    @Interceptors(LoggingInterceptor.class)
    public Car save(Car car)
    {
        
        em.persist(car);
        return car;
        
    }
    public Car search(int id)
    {
        return em.find(Car.class, id);
    }
    public List<Car> getCars()
    {
        Query query = em.createQuery("select c from Car c");
        List<Car> cars = query.getResultList();
        return cars;
    }
    
    
    @Interceptors(LoggingInterceptor.class)
    public Car update(int id, Car car)
    {
        Car getCar = em.find(Car.class, id);
        if(getCar == null)
            return null;
        getCar.setMake(car.getMake());
        getCar.setMiles(car.getMiles());
        getCar.setModel(car.getModel());
        getCar.setColor(car.getColor());
        getCar.setYear(car.getYear());
        System.out.println("Update car in Crud: " + getCar);
        em.persist(getCar);
        return getCar;
            
    }
    
    @Interceptors(LoggingInterceptor.class)
    public Car delete(int id)
    {
        System.out.println("Delete Crud id class:"+ id);
        Car getCar = em.find(Car.class, id);
        
        if(getCar == null)
            return null;
        System.out.println("Delete Crud"+getCar);
        em.remove(getCar);
        return getCar;
    }
    
    @Interceptors(LoggingInterceptor.class)
    public void clearCars()
    {
        Query query = em.createQuery("delete from Car");
        query.executeUpdate();
        
    }
    
    private void start()
    {
        /*emf = Persistence.createEntityManagerFactory("Assignment12-ejbPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();*/
    }
    
    private void close()
    {
        /*emf.close();
        em.close();
        tx = null;
        emf = null;
        em = null;*/
    }
    
}
