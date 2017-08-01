/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.hazelcast.core.MapStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 72010995
 */
public class HazelcastEmployeeDAO implements MapStore<Integer, Employee>
{

    @Autowired
    private JDBCEmployeeDAO employeeDAO;

    @Override
    public void store(Integer integer, Employee employee)
    {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void storeAll(Map<Integer, Employee> map)
    {

        for (Map.Entry<Integer, Employee> mapEntry : map.entrySet())
        {
            store(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    @Override
    public void delete(Integer integer)
    {

    }

    @Override
    public void deleteAll(Collection<Integer> collection)
    {

    }

    @Override
    public Employee load(Integer employeeId)
    {
        Employee emp = null;
        try
        {
            emp = employeeDAO.getEmployee(employeeId);
            if (emp == null)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error:"+e.getMessage());
            return null;
        }
        return emp;
    }

    @Override
    public Map<Integer, Employee> loadAll(Collection<Integer> collection)
    {
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        List<Employee> employees = employeeDAO.listEmployees();
        for (Employee employee : employees)
        {
            employeeMap.put(employee.getId(), employee);
        }
        return employeeMap;
    }

    @Override
    public Set<Integer> loadAllKeys()
    {
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        List<Employee> employees = employeeDAO.listEmployees();
        for (Employee employee : employees)
        {
            employeeMap.put(employee.getId(), employee);
        }
        return employeeMap.keySet();
    }
}
