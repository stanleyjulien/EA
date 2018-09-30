/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14.mytimer.cartimer;

import assignment14.myentity.carentity.Car;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author midou
 */
@Stateless
public class CarTimer {
    
    @PersistenceContext(unitName = "Assignment14-ejbPU")
    private EntityManager em;
    
    /*@Schedule(minute = "1")
    public void showNumOfCar()
    {
        TypedQuery<Car> query = em.createNamedQuery("numOfCar", Car.class);
        int total = query.getMaxResults();
        int total2 = query.getFirstResult();
        
        System.out.println("Total car every minute in database: "+total2);        
        //System.out.println("Total car every minute in database: "+total2);

    }*/
}
