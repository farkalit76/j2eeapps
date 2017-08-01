/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.cache.test;

import com.farkalit.emp.test.Employee;
import com.farkalit.util.HibSessionManager;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Query Cache: Hibernate can also cache result set of a query. 
 * Hibernate Query Cache doesn’t cache the state of the actual entities in the cache; 
 * it caches only identifier values and results of value type. 
 * So it should always be used in conjunction with the second-level cache.
 * 
 * @author 72010995
 */
public class QueryCacheTest
{

    private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();

    public static void main(String[] args)
    {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee p where p.id=1");
        //Set the Query Cache true to enable it.
        //Alternatively we can add the below line to the hibernate.cfg.xml file
        //<property name="hibernate.cache.use_query_cache">true</property>
        query.setCacheable(true);
        Iterator it = query.list().iterator();
        while (it.hasNext())
        {
            Employee p = (Employee) it.next();
            System.out.println(p.getFirstName());
        }
        query = session.createQuery("from Employee p where p.id=1");
          //Set the Query Cache true to enable it.
        query.setCacheable(true);
        it = query.list().iterator();
        while (it.hasNext())
        {
            Employee p = (Employee) it.next();
            System.out.println(p.getFirstName());
        }
        tx.commit();
        session.close();
    }
}
