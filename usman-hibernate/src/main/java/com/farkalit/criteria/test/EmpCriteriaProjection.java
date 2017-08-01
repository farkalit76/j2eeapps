/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.criteria.test;

import com.farkalit.emp.test.Employee;
import com.farkalit.util.HibSessionManager;
import com.farkalit.util.IdGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fusman
 */
public class EmpCriteriaProjection {

    //Create a single session factory
    private static final SessionFactory factory = HibSessionManager.getSessionFactory();
    
    public static void main(String[] args) {
        try {

            EmpCriteriaProjection ME = new EmpCriteriaProjection();
            
            /* Add few employee records in database */
            String datejoin = "2015-02-22";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Integer empID1 = ME.addEmployee("Zara", "Ali", 34, 'M', 12000,"MTech",sdf.parse(datejoin));
            Integer empID2 = ME.addEmployee("Daisy", "Das",34, 'M', 15000,"MCA",sdf.parse(datejoin));
            Integer empID3 = ME.addEmployee("John", "Paul", 34, 'M',15000,"BTEch", sdf.parse(datejoin));
            Integer empID4 = ME.addEmployee("Mohd", "Yasee", 34, 'M',13000,"BCA", sdf.parse(datejoin));
            
            /* List down all the employees */
            ME.listEmployees();
            
            /* Print Total employee's count */
            ME.countEmployee();
            
            /* Print Toatl salary */
            ME.totalSalary();
            
            //Close Session Factory
            HibSessionManager.shutdown();
        } catch (Exception ex) {
            System.out.println("Test Error:"+ex.getMessage());
        }
    }
    /* Method to CREATE an employee in the database */

    public Integer addEmployee(String fname, String lname,int age, char sex, double salary, String education, Date jDate) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname,age, sex, salary,education,jDate);
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

    /* Method to  READ all the employees having salary more than 2000 */
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // Add restriction.
            cr.add(Restrictions.gt("salary", 12000.0));
            List employees = cr.list();

            for (Iterator itr = employees.iterator(); itr.hasNext();) {
                Employee employee = (Employee) itr.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.print("  Age: " + employee.getAge());
                System.out.print("  Education: " + employee.getEducation());
                System.out.print("  J Date: " + employee.getJoiningDate());
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
    /* Method to print total number of records */

    public void countEmployee() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);

            // To get total row count.
            cr.setProjection(Projections.rowCount());
            List rowCount = cr.list();

            System.out.println("Total Coint: " + rowCount.get(0));
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
    /* Method to print sum of salaries */

    public void totalSalary() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);

            // To get total salary.
            cr.setProjection(Projections.sum("salary"));
            List totalSalary = cr.list();

            System.out.println("Total Salary: " + totalSalary.get(0));
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
