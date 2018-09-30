/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12.persistences;

import assignment12.entity.LogCall;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author midou
 */
@Stateful
public class LogManager {
    
    @PersistenceContext(unitName = "Assignment12-ejbPU")
    private EntityManager em;
    
    public List<LogCall> logCars()
    {
        Query query = em.createQuery("select l from LogCall l");
        List<LogCall> logs = query.getResultList();
        return logs;
    }
    
    public void clearLogs()
    {
        Query query = em.createQuery("delete from LogCall");
        query.executeUpdate();
        
    }
}
