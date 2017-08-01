/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service("JDBCEmployeeService")
public class JDBCEmployeeService implements EmployeeService
{

    @Autowired
    private JDBCEmployeeDAO employeeDAO;

    @Override
    public Employee getEmployee(Integer employeeId)
    {
        return employeeDAO.getEmployee(employeeId);
    }

    @Override
    public void removeEmployee(Integer employeeId)
    {
        employeeDAO.removeEmployee(employeeId);
    }

    @Override
    public void addEmployee(Employee employee)
    {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void addEmployees(Map<Integer, Employee> employees)
    {
        for (Employee employee : employees.values())
        {
            employeeDAO.addEmployee(employee);
        }
    }

    @Override
    public List<Employee> listEmployees()
    {
        return employeeDAO.listEmployees();
    }
}
