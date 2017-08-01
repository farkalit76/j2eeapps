/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.cache.test;

import com.farkalit.util.HibSessionManager;
import com.farkalit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hibernate second level cache uses a common cache for all the session object of a session factory.
 * It is useful if you have multiple session objects from a session factory.
 *
 * SessionFactory holds the second level cache data. It is global for all the session objects and not enabled by default.
 *
 * Different vendors have provided the implementation of Second Level Cache.
 *
 * EH Cache, * Swarm Cache, * OS Cache,  * JBoss Cache
 * 
 * Each implementation provides different cache usage functionality. There are four ways to use second level cache.
 *
 * read-only: caching will work for read only operation.
 * nonstrict-read-write: caching will work for read and write but one at a time.
 * read-write: caching will work for read and write, can be used simultaneously.
 * transactional: caching will work for transaction.
 *
 * @author 72010995
 */
public class SecondLevelEHCacheTest
{

    //private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args)
    {

        //First time data retrieved from databse.
        Session session1 = sessionFactory.openSession();
        EmpCache emp1 = (EmpCache) session1.load(EmpCache.class, 1);
        System.out.println(emp1.getId() + " " + emp1.getName() + " " + emp1.getSalary());
        session1.close();

        //Check the log, that this data is coming from EHCache and not from database.
        Session session2 = sessionFactory.openSession();
        EmpCache emp2 = (EmpCache) session2.load(EmpCache.class, 1);
        System.out.println(emp2.getId() + " " + emp2.getName() + " " + emp2.getSalary());
        session2.close();

        //HibSessionManager.closeSessionFactory();
        HibernateUtil.closeSessionFactory();
    }
}
