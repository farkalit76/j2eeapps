/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util;

import com.farkalit.interceptor.test.MyInterceptor;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author 72010995
 */
public class HibSessionManager
{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            System.out.println("SessionFactory started to build.....");
            Configuration conf = new Configuration();
            /* 
            * Set the my interceptor 
            */
            //conf.setInterceptor(new MyInterceptor());//Optional
            // Create the SessionFactory from hibernate.cfg.xml
            conf.configure("hibernate.cfg.xml");
            return conf.buildSessionFactory();
        }
        catch (HibernateException ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("HibernateException:::SessionFactory creation failed." + ex.getMessage());
            System.err.println("HibernateException:::SessionFactory creation failed." + ex.getLocalizedMessage());
            System.err.println("HibernateException:::SessionFactory creation failed." + ex.getCause());
            ex.printStackTrace();
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
        System.out.println(">>>>>>>>>>SessionFactory going to close");
        getSessionFactory().close();
    }
    
    public static void closeSessionFactory(){
        if( sessionFactory != null ){
            sessionFactory.close();
            System.out.println(">>>>>SessionFactory closed>>>>>>>");
        }
    }
}
