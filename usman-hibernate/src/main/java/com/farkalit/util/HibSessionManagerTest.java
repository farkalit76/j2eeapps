/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * It will connect to Test schema from MySQL database
 * @author 72010995
 */
public class HibSessionManagerTest
{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            System.out.println("SessionFactoryTest started to build.....");
            Configuration conf = new Configuration();
            // Create the SessionFactory from hibernate_test.cfg.xml for test schema
            conf.configure("hibernate_test.cfg.xml");
            return conf.buildSessionFactory();
        }
        catch (HibernateException ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("HibernateException:::SessionFactory creation failed." + ex.getMessage());
            System.err.println("HibernateException:::SessionFactory creation failed." + ex.getLocalizedMessage());
            System.err.println("HibernateException:::SessionFactory creation failed." + ex.getCause());
            return null;
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        // Close caches and connection pools
        System.out.println(">>>>>>>>>>SessionFactoryTest going to close");
        getSessionFactory().close();
    }
    
    public static void closeSession(SessionFactory session){
        if( session != null ){
            session.close();
        }
    }
}
