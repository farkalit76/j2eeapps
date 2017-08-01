/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.dao;

import com.usman.study.model.EmployeeVO;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
}
