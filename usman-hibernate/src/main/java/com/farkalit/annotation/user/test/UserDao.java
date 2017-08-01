/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.annotation.user.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 72010995
 */
public class UserDao
{

    public static void save(SessionFactory factory, User user )
    {
        Session session = factory.openSession();
        Transaction trx = null;
        try
        {

            trx = session.beginTransaction();           
            Integer userID1 = (Integer) session.save(user);
            System.out.println("userID1:"+userID1);
            trx.commit();

        }
        catch (Exception e)
        {
            if (trx != null)
            {
                trx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        System.out.println("Data inserted....");
    }

}
