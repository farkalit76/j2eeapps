/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.annotation.employee.test;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 72010995
 */
public class EmployeeInfoDao
{

    /* Method to CREATE an employee in the database */
    public static Integer addEmployee(SessionFactory factory, String fname, String lname, int age, String sex, String education, double salary)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try
        {
            tx = session.beginTransaction();
            EmployeeInfo employee = new EmployeeInfo(fname, lname, age, sex, education, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();

        }
        catch (HibernateException e)
        {
            if (tx != null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        System.out.println("successfully saved");
        return employeeID;
    }


    /* Method to  READ all the employees */
    public static void listEmployees(SessionFactory factory)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator
                    = employees.iterator(); iterator.hasNext();)
            {
                EmployeeInfo employee = (EmployeeInfo) iterator.next();
                System.out.print("Emp ID: " + employee.getId());
                System.out.print("  First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    /* Method to  READ all the employees */
    public static void listEmployeesWithCriteria(SessionFactory factory)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            // List employees = session.createQuery("FROM Employee").list();
            Criteria cr = session.createCriteria(EmployeeInfo.class);
            cr.add(Restrictions.gt("salary", 4000.0));
            cr.add(Restrictions.like("firstName", "Za%"));
            cr.addOrder(Order.desc("age"));
            List employees = cr.list();
            System.out.println("employees count: "+employees.size());
            for (Iterator iterator
                    = employees.iterator(); iterator.hasNext();)
            {
                EmployeeInfo employee = (EmployeeInfo) iterator.next();
                System.out.println(" " + employee.toString());
            }
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public static void updateEmployee(SessionFactory factory, Integer EmployeeID, int salary)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            EmployeeInfo employee
                    = (EmployeeInfo) session.get(EmployeeInfo.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        }
        catch (HibernateException e)
        {
            System.err.println("Error:" + e.getMessage());
            if (tx != null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    public static void updateEmployeeHQL(SessionFactory factory, Integer employeeID, double salary)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();

            String hql = "UPDATE EmployeeInfo set salary = :salary "
                    + "WHERE id = :employee_id";
            Query query = session.createQuery(hql);
            query.setParameter("salary", salary);
            query.setParameter("employee_id", employeeID);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            tx.commit();
        }
        catch (HibernateException e)
        {
            System.err.println("Error:" + e.getMessage());
            if (tx != null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */

    public static void deleteEmployee(SessionFactory factory, Integer EmployeeID)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            EmployeeInfo employee
                    = (EmployeeInfo) session.get(EmployeeInfo.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

}
