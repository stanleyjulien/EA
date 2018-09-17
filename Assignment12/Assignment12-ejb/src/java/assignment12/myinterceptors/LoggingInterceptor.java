/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12.myinterceptors;

import assignment12.entity.LogCall;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author midou
 */
@Stateful
public class LoggingInterceptor {
    
    //@Inject
    private LogCall logCall = new LogCall();
    
    @PersistenceContext(unitName = "Assignment12-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    private Logger logger = Logger.getLogger("assignment12.persistences");
    
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
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception
    {
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        /*System.out.println("Logger: "+ic.getTarget().toString());
        System.out.println("Logger Class Name: "+ic.getClass().getName());
        System.out.println("Logger Method Name: "+ic.getMethod().getName());
        System.out.println("Logger Parameters: "+Arrays.toString(ic.getParameters()));
        */
        logCall.setClassName(ic.getTarget().getClass().getName());
        logCall.setMethodName(ic.getMethod().getName());
        logCall.setDescription(Arrays.toString(ic.getParameters()));
        
        em.persist(logCall);
                
        /*for(Object ob : ic.getParameters())
        {
            System.out.println(ob);
        }*/
        //System.out.println("Logger: "+ic);
        try
        {
            return ic.proceed();
        }
        finally
        {
            logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
