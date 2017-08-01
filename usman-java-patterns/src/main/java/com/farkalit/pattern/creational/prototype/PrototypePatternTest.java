/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.prototype;

import java.util.List;

/**
 *
 * @author fusman
 */
public class PrototypePatternTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Employees emps = new Employees();
        System.out.println("emps:" + emps.getEmpList().size());
        emps.loadData();
        System.out.println("emps load data:" + emps.getEmpList().size());

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> empList = empsNew.getEmpList();
        empList.add("Usman");
        List<String> empList1 = empsNew1.getEmpList();

        empList1.remove("Raj");
        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + empList);
        System.out.println("empsNew1 List: " + empList1);
    }
}
