/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.memory;

/**
 *
 * @author fusman
 */
public class Student {

    private String name;
    private Integer age;

    public Student(){}
    
    public Student(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public Integer getAge()
    {
        return 10;
    }
}
