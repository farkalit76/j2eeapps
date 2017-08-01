/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.dao;

import com.usman.study.model.EmployeeVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 72010995
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
    
    public List<EmployeeVO> getAllEmployees()
    {
        List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
         
        EmployeeVO vo1 = new EmployeeVO();
        vo1.setId(1);
        vo1.setFirstName("Sarwar");
        vo1.setLastName("Imam");
        employees.add(vo1);
         
        EmployeeVO vo2 = new EmployeeVO();
        vo2.setId(2);
        vo2.setFirstName("Nehal");
        vo2.setLastName("Alam");
        employees.add(vo2);
         
        return employees;
    }
}
