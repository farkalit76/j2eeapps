/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.cache.test;

import java.io.Serializable;

/**
 *
 * @author 72010995
 */
public class EmpCache implements Serializable
{

    private int id;
    private String name;
    private float salary;

    public EmpCache()
    {
    }

    public EmpCache(String name, float salary)
    {
        super();
        this.name = name;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getSalary()
    {
        return salary;
    }

    public void setSalary(float salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "EmpCache{" + "id=" + id + ", name=" + name + ", salary=" + salary + '}';
    }

    
}
