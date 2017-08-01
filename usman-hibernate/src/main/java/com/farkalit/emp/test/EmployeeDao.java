/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.emp.test;

import com.farkalit.util.HibSessionManager;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 72010995
 */
public class EmployeeDao implements EmployeeIntf
{
    //Create a single session factory
    private static final SessionFactory factory = HibSessionManager.getSessionFactory();
        
    @Override
    public void create(Employee employee)
    {
        Session session = null;
        try
        {
            session = factory.openSession();
            //Open transaction
            Transaction trans = session.beginTransaction();
            session.persist(employee);
            trans.commit();//close transaction
            System.out.println("Employee created...");
        }
        catch (HibernateException e)
        {
            System.err.println("Error:"+e.getMessage());
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
    }

    
    @Override
    public List<Employee> getEmployee()
    {
        List<Employee> employees = new ArrayList<>();
        Session session = null;
        try
        {
            session = factory.openSession();
            Query query = session.createQuery("from Employee");
            employees = query.list();
        }
        catch (HibernateException e)
        {
            System.err.println("Error:"+e.getMessage());
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return employees;

    }
    
    
    public static void closeSession(){
        HibSessionManager.shutdown();
    }

}
