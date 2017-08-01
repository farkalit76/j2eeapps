/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.test;

import com.farkalit.mapping.model.CustomerTrxn;
import com.farkalit.mapping.model.Customer;
import com.farkalit.util.HibSessionManager;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 72010995
 */
public class OneToOneMappingTest
{

    private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();

    public static void main(String[] args)
    {
       
        try
        {
            Session session = sessionFactory.openSession();
            System.out.println("Session created");
            //start transaction
            Transaction tx = session.beginTransaction();
            CustomerTrxn txn = buildDemoTransaction();
            //Save the Model object
            session.save(txn);
            //Commit transaction
            tx.commit();
            System.out.println("Transaction ID=" + txn.getId());

            //Get Saved Trasaction Data
            printTransactionData(txn.getId(), sessionFactory);

            HibSessionManager.closeSessionFactory();
        }
        catch (Exception e)
        {
            HibSessionManager.closeSessionFactory();
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
             HibSessionManager.closeSessionFactory();
            if (!sessionFactory.isClosed())
            {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }

    }

    private static void printTransactionData(long id, SessionFactory sessionFactory)
    {
        try
        {
            Session session = sessionFactory.openSession();
            //start transaction
            Transaction tx = session.beginTransaction();
            //Save the Model object
            CustomerTrxn txn = (CustomerTrxn) session.get(CustomerTrxn.class, id);
            //Commit transaction
            tx.commit();
            System.out.println("Transaction Details=\n" + txn.toString());

        }
        catch (Exception e)
        {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static CustomerTrxn buildDemoTransaction()
    {
        CustomerTrxn txn = new CustomerTrxn();
        txn.setDate(new Date());
        txn.setTotal(100);

        Customer cust = new Customer();
        cust.setAddress("Delhi NCR, India");
        cust.setEmail("usman@gmail.com");
        cust.setName("Farkalit Usman");

        txn.setCustomer(cust);

        cust.setTrxn(txn);
        return txn;
    }
}
