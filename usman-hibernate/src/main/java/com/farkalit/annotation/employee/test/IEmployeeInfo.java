/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.annotation.employee.test;

/**
 *
 * @author 72010995
 */
public interface IEmployeeInfo
{
     public Integer addEmployee(EmployeeInfo employee);
     public void listEmployees();
     public void updateEmployee(Integer employeeID, int salary);
     public void deleteEmployee(Integer employeeID);
}
