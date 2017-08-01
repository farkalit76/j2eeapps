/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.aop;

import java.util.List;

/**
 *
 * @author 72010995
 */
public interface EmployeeManager
{
    public EmployeeDTO getEmployeeById(Integer employeeId);
 
    public List<EmployeeDTO> getAllEmployee();
 
    public void createEmployee(EmployeeDTO employee);
 
    public void deleteEmployee(Integer employeeId);
 
    public void updateEmployee(EmployeeDTO employee);
}
