/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.cache.test;

import com.farkalit.emp.test.Employee;
import com.farkalit.util.HibSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * First Level Cache: Hibernate first level cache is associated with the Session object. 
 * Hibernate first level cache is enabled by default and there is no way to disable it. 
 * However hibernate provides methods through which we can delete selected objects 
 * from the cache or clear the cache completely.
 * Any object cached in a session will not be visible to other sessions and when the 
 * session is closed, all the cached objects will also be lost.
 * 
 * @author 72010995
 */
public class FirstLevelCacheExample
{

    private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();

    public static void main(String[] args)
    {

        try
        {

            //Session session = sessionFactory.getCurrentSession();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            //Get employee with id=1
            System.out.println("\n Fetch Employee data for id=1");
            Employee emp = (Employee) session.load(Employee.class, 1);
            printData(emp, 1);

            //waiting for sometime to change the data in backend
            Thread.sleep(3000);

            //Fetch same data again, check logs that no query fired
            System.out.println("\n  Fetch same data again, check logs that no query fired.");
            Employee emp1 = (Employee) session.load(Employee.class, 1);
            printData(emp1, 2);

            //Create new session
            Session newSession = sessionFactory.openSession();
            //Get employee with id=1, notice the logs for query
            System.out.println("\n\n Create new session \n Get employee with id=1, notice the logs for query");
            Employee emp2 = (Employee) newSession.load(Employee.class, 1);
            printData(emp2, 3);

        //START: evict example to remove specific object from hibernate first level cache
            //Get employee with id=2, first time hence query in logs
            System.out.println("\n Get employee with id=2, first time hence query in logs");
            Employee emp3 = (Employee) session.load(Employee.class, 2);
            printData(emp3, 4);

            //evict the first employee object with id=1
            System.out.println("\n evict the first employee object with id=1");
            session.evict(emp);
            System.out.println("Session Contains Employee with id=1?" + session.contains(emp));

            //since object is removed from first level cache, you will see query in logs
            System.out.println("\n since object is removed from first level cache for id=1, you will see query in logs");
            Employee emp4 = (Employee) session.load(Employee.class, 1);
            printData(emp4, 5);

            //this object is still present, so you won't see query in logs
            System.out.println("\n this object is still present, so you won't see query in logs");
            Employee emp5 = (Employee) session.load(Employee.class, 2);
            printData(emp5, 6);
       //END: evict example

            //START: clear example to remove everything from first level cache
            System.out.println("\n clear example to remove everything from first level cache");
            session.clear();
            
            System.out.println("\n Get employee object with id=1");
            Employee emp6 = (Employee) session.load(Employee.class, 1);
            printData(emp6, 7);
            
            System.out.println("\n Get employee object with id=2");
            Employee emp7 = (Employee) session.load(Employee.class, 2);
            printData(emp7, 8);

            System.out.println("Session Contains Employee with id=2?" + session.contains(emp7));

            tx.commit();

            HibSessionManager.closeSessionFactory();
        }
        catch (HibernateException | InterruptedException e)
        {
            System.err.println("Error:"+e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printData(Employee emp, int count)
    {
        System.out.println(count + "::Id=" + emp.getId()+ ", First Name=" + emp.getFirstName() + ", Education=" + emp.getEducation());
    }

}
