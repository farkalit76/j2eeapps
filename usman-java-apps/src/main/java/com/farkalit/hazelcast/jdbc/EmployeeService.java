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

/**
 *
 * @author 72010995
 */
public interface EmployeeService
{
    Employee getEmployee(Integer employeeId);

    void removeEmployee(Integer employeeId);

    void addEmployee(Employee employee);

    void addEmployees(Map<Integer, Employee> employees);

    List<Employee> listEmployees();
    
}
