/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.aop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class EmployeeManagerImpl implements EmployeeManager
{
    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        System.out.println("Method getEmployeeById() called");
        return new EmployeeDTO();
    }
 
    @Override
    public List<EmployeeDTO> getAllEmployee() {
        System.out.println("Method getAllEmployee() called");
        return new ArrayList<>();
    }
 
    @Override
    public void createEmployee(EmployeeDTO employee) {
        System.out.println("Method createEmployee() called");
    }
 
    @Override
    public void deleteEmployee(Integer employeeId) {
        System.out.println("Method deleteEmployee() called");
    }
 
    @Override
    public void updateEmployee(EmployeeDTO employee) {
        System.out.println("Method updateEmployee() called");
    }
}
