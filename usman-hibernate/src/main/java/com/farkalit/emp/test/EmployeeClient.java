/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.emp.test;

import com.farkalit.util.IdGenerator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class EmployeeClient
{

    public static void main(String[] args)
    {
        try {
            EmployeeDao dao = new EmployeeDao();
            runEmployee(dao);
            //close session factory
            EmployeeDao.closeSession();
        } catch (Exception ex) {
            System.err.println("Error inserting:"+ex.getMessage());
        }
    }
    
    public static void runEmployee( EmployeeDao dao) throws Exception{
       
        Employee emp = getEmployee();
        dao.create(emp);
        System.out.println("Employee is created for ID:"+ emp.getId());
        
        List<Employee> employees= dao.getEmployee();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
           System.out.println("Employee:"+ iterator.next().toString());
        }
    }
    
    private static Employee getEmployee() throws ParseException{
       
        Employee emp = new Employee();
        emp.setId(IdGenerator.getRandomNum());
        emp.setFirstName("Akbar");
        emp.setLastName("Ali");
        emp.setSex('M');
        emp.setAge(50);
        emp.setEducation("PHD");
        emp.setSalary(40000.00);
        String datejoin = "2015-02-22";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        emp.setJoiningDate(sdf.parse(datejoin));
        return emp;
    }
    
}
