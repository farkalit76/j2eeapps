/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.aop;

import org.aspectj.lang.JoinPoint;

/**
 *
 * @author 72010995
 */
public class EmployeeCRUDTransactionAspect
{
    public void getEmployeeById(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDTransactionAspect.getEmployeeById() : "
                + joinPoint.getSignature().getName());
    }
}
