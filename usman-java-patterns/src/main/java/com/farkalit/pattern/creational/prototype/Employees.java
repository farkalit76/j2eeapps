/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Prototype design pattern is used when the Object creation is a costly affair 
 * and requires a lot of time and resources and you have a similar object already existing.
 * 
 * Suppose we have an Object that loads data from database. Now we need to modify
 * this data in our program multiple times, so it’s not a good idea to create the 
 * Object using new keyword and load all the data again from database.

 * The better approach would be to clone the existing object into a new object 
 * and then do the data manipulation.
 * 
 * @author fusman
 */
public class Employees implements Cloneable {

    private List<String> empList;

    public Employees() {
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        //read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String emp1 : this.getEmpList()) {
            temp.add(emp1);
        }
        return new Employees(temp);
    }

}
