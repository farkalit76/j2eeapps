/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.history.test;

import com.farkalit.util.HibSessionManager;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 72010995
 */
public class HistoryDao implements History
{

    //Create a single session factory
    private static final SessionFactory factory = HibSessionManager.getSessionFactory();

    @Override
    public ChangeHistory getHistoryById(int id)
    {
        ChangeHistory history = null;
        Session session = null;
        try
        {
            session = factory.openSession();
            Object obj = session.load(ChangeHistory.class, id);
            history = (ChangeHistory) obj;
        }
        catch (HibernateException e)
        {
            System.err.println("Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return history;
    }

    @Override
    public List<ChangeHistory> getHistory()
    {
        List<ChangeHistory> history = new ArrayList<>();
        Session session = null;
        try
        {
            //SessionFactory factory = HibSessionManager.getSessionFactory();
            System.out.println("test-1");
            session = factory.openSession();
            System.out.println("test-2");
            Query query = session.createQuery("from History");
            System.out.println("test-3");
            history = query.list();
            System.out.println("test-4");
        }
        catch (HibernateException e)
        {
            System.err.println("Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return history;
    }

    public static void closeSession()
    {
        HibSessionManager.shutdown();
    }

}
