/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author fusman
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
            final Properties properties = configuration.getProperties();
            //System.out.println("Hibernate properties loaded"+properties.toString());
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
            System.out.println("Hibernate serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("sessionFactory created....");
            return sessionFactory;
        } catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static void closeSessionFactory()
    {
        if( sessionFactory != null )
        {
            sessionFactory.close();
            System.out.println("sessionFactory closed....");
        }
    }
}
