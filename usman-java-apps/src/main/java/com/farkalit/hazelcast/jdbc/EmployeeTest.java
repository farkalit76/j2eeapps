/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 *
 * @author 72010995
 */
public class EmployeeTest
{

    public static final int INSERT_COUNT = 10;

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Hazel-Config.xml");
        // ApplicationContext ctx= new ClassPathXmlApplicationContext("Spring-Hazel-Config.xml");
        try
        {
            Map<Integer, Employee> employees = createEmployeesMap(100);

            //MYSQL SERVICE
            EmployeeService jdbcEmployeeService = (EmployeeService) ctx.getBean("JDBCEmployeeService");

            StopWatch stopWatch;
            stopWatch = new StopWatch();
//        stopWatch.start();
//        jdbcEmployeeService.addEmployees(employees);
//        stopWatch.stop();
//        printTimes(jdbcEmployeeService, stopWatch);

            //stopWatch = new StopWatch();
            stopWatch.start();
            List<Employee> jdbcempList = jdbcEmployeeService.listEmployees();
            System.out.println("jdbcempList:" + jdbcempList.size());
            stopWatch.stop();
            printTimes(jdbcEmployeeService, stopWatch);

            //Hazelcast SERVICE
            EmployeeService hazelcastEmployeeService = (EmployeeService) ctx.getBean("HazelcastEmployeeService");
            //stopWatch = new StopWatch();
//            stopWatch.start();
           hazelcastEmployeeService.addEmployees(employees);
//            stopWatch.stop();
            printTimes(hazelcastEmployeeService, stopWatch);

            stopWatch = new StopWatch();
            stopWatch.start();
            List<Employee> empList = hazelcastEmployeeService.listEmployees();
            System.out.println("empList:" + empList.size());
            stopWatch.stop();
            printTimes(hazelcastEmployeeService, stopWatch);

            ((HazelcastEmployeeService) hazelcastEmployeeService).shutDown();

            ctx.close();
        }
        catch (Exception e)
        {
            ctx.close();
            System.err.println("Error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Map<Integer, Employee> createEmployeesMap(int startingID)
    {

        Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
        for (int i = 0; i < INSERT_COUNT; i++)
        {
            Employee employee = new Employee(startingID + i, "hazelcast_" + i, "Developer");
            employees.put(i, employee);
        }
        return employees;
    }

    private static void printTimes(EmployeeService employeeService, StopWatch stopWatch)
    {
        System.out.println(employeeService.getClass().getCanonicalName() + " total time = " + stopWatch.getTotalTimeSeconds() + " (secs)");
        System.out.println(employeeService.getClass().getCanonicalName() + " avg time = " + stopWatch.getTotalTimeMillis() / stopWatch.getTaskCount() + " (ms)");
    }
}
