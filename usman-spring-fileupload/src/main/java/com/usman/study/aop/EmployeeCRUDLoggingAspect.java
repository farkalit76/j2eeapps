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
public class EmployeeCRUDLoggingAspect
{
   public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logBefore() : " + joinPoint.getSignature().getName());
    }
     
    public void logAfter(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logAfter() : " + joinPoint.getSignature().getName());
    } 
}
