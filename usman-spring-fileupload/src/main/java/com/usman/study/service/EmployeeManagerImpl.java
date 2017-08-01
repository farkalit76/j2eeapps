/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.service;

import com.usman.study.model.EmployeeVO;
import com.usman.study.dao.EmployeeDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service
public class EmployeeManagerImpl implements EmployeeManager
{

    @Autowired
    EmployeeDAO dao;
     
    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }
    
}
