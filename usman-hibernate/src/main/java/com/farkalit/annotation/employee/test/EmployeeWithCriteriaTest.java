/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.annotation.employee.test;

import com.farkalit.util.HibSessionManagerTest;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 72010995
 */
public class EmployeeWithCriteriaTest
{

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeWithCriteriaTest.class);
    private static SessionFactory factory;

    public static void main(String[] args)
    {
        LOG.info("ManageEmployee started....");
        factory = HibSessionManagerTest.getSessionFactory();
        try
        {
            /* Add few employee records in database */
            Integer empID1 = EmployeeInfoDao.addEmployee(factory, "Zara", "Ali", 30, "M", "MSC", 1000);
            System.out.println("Emp ID:" + empID1);
            //Integer empID2 = EmployeeDao.addEmployee(factory, "Daisy", "Das", 30, "M", "MSC", 5000);
            //Integer empID3 = CrudEmployee.addEmployee(factory, "John", "Paul", 30, "M", "MSC", 10000);

            /* List down all the employees */
            //EmployeeDao.listEmployees(factory);

            /* Update employee's records */
            EmployeeInfoDao.updateEmployee(factory, 4, 5000);

            EmployeeInfoDao.updateEmployeeHQL(factory, 10, 4000.0);

            /* Delete an employee from the database */
            //EmployeeDao.deleteEmployee(factory, empID2);

            /* List down new list of the employees */
            // EmployeeDao.listEmployees(factory);
            EmployeeInfoDao.listEmployeesWithCriteria(factory);
            LOG.info("ManageEmployee Completed.");

        }
        catch (Exception e)
        {
            System.err.println("Error:" + e.getMessage());
        }
        finally
        {
            factory.close();
        }
        System.out.println("Test Done.........");
    }

}
