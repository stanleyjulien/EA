/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment15.mylog.mylogclass;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author midou
 */
@Stateless
public class LogControl {
    
    private Logger logger = Logger.getLogger("assignment14");
    
    @AroundInvoke
    private Object logMethod(InvocationContext ic) throws Exception
    {
        String name = "Class name: "+ic.getTarget().getClass().getName()+" | Method: "+ic.getMethod().getName();
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        System.out.println(name);
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
