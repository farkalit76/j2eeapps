/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.nativesql.test;

import com.farkalit.emp.test.Employee;
import com.farkalit.util.HibSessionManager;
import com.farkalit.util.IdGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author fusman
 */
public class NativeSQLTest {

    //Create a single session factory
    private static final SessionFactory factory = HibSessionManager.getSessionFactory();

    public static void main(String[] args) {
        try {

            NativeSQLTest ME = new NativeSQLTest();

            /* Add few employee records in database */
            String datejoin = "2015-09-15";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //emp.setJoiningDate(sdf.parse(datejoin));
            Integer empID1 = ME.addEmployee("Zara", "Ali", 34, 'M', 12000, "MTech", sdf.parse(datejoin));
            Integer empID2 = ME.addEmployee("Daisy", "Das", 34, 'M', 15000, "MCA", sdf.parse(datejoin));
            Integer empID3 = ME.addEmployee("John", "Paul", 34, 'M', 15000, "BTEch", sdf.parse(datejoin));
            Integer empID4 = ME.addEmployee("Mohd", "Yasee", 34, 'M', 13000, "BCA", sdf.parse(datejoin));

            /* List down employees and their salary using Scalar Query */
            ME.listEmployeesScalar();

            /* List down complete employees information using Entity Query */
            ME.listEmployeesEntity();

            //Close Session Factory
            HibSessionManager.shutdown();
        } catch (Exception ex) {
            System.out.println("Test NativeSQL Error:" + ex.getMessage());
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

    /* Method to  READ all the employees using Scalar Query */
    public void listEmployeesScalar() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT firstName, salary FROM EMPLOYEE";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List data = query.list();

            for (Object object : data) {
                Map row = (Map) object;
                System.out.print("First Name: " + row.get("firstName"));
                System.out.println(", Salary: " + row.get("salary"));
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

    /* Method to  READ all the employees using Entity Query */
    public void listEmployeesEntity() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM EMPLOYEE";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Employee.class);
            List employees = query.list();

            for (Iterator itr = employees.iterator(); itr.hasNext();) {
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
}
