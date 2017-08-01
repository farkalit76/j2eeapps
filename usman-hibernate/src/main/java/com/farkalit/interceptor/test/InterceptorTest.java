/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.interceptor.test;

import com.farkalit.emp.test.Employee;
import com.farkalit.util.HibSessionManager;
import com.farkalit.util.IdGenerator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fusman
 */
public class InterceptorTest {

    //Create a single session factory
    private static final SessionFactory factory = HibSessionManager.getSessionFactory();
    //private static SessionFactory factory;

    public static void main(String[] args) {

//        try {
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }

        try {
            InterceptorTest ME = new InterceptorTest();

            /* Add few employee records in database */
            String datejoin = "2015-05-11";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Integer empID1 = ME.addEmployee("Zara", "Ali", 34, 'M', 112000, "MTech", sdf.parse(datejoin));
            Integer empID2 = ME.addEmployee("Daisy", "Das", 34, 'M', 125000, "MCA", sdf.parse(datejoin));
            Integer empID3 = ME.addEmployee("John", "Paul", 34, 'M', 115000, "BTEch", sdf.parse(datejoin));

            /* List down all the employees */
            ME.listEmployees();

            /* Update employee's records */
            ME.updateEmployee(empID1, 5000);

            /* Delete an employee from the database */
            ME.deleteEmployee(empID2);

            /* List down new list of the employees */
            ME.listEmployees();

            //Close Session Factory
            HibSessionManager.shutdown();

        } catch (ParseException ex) {
            System.out.println("Interceptor Error:" + ex.getMessage());
        }
    }
    /* Method to CREATE an employee in the database */

    public Integer addEmployee(String fname, String lname, int age, char sex, double salary, String education, Date jDate) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, age, sex, salary, education, jDate);
            employee.setId(IdGenerator.getRandomNum());//Generate new ID
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }
    /* Method to  READ all the employees */

    public void listEmployees() {
        //Session session = factory.openSession(new MyInterceptor());//Interceptor is set in the HibSessionManager
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator itr  = employees.iterator(); itr.hasNext();) {
                Employee employee = (Employee) itr.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to UPDATE salary for an employee */

    public void updateEmployee(Integer EmployeeID, int salary) {
        //Session session = factory.openSession(new MyInterceptor());//Interceptor is set in the HibSessionManager
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee
                    = (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */

    public void deleteEmployee(Integer EmployeeID) {
        //Session session = factory.openSession(new MyInterceptor());//Interceptor is set in the HibSessionManager
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee
                    = (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
