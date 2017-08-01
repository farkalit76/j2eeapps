/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.comparator;

import java.util.Comparator;

/**
 *
 * @author fusman
 */
public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2)
    {
        return emp1.getSalary() - emp2.getSalary();
    }
}
