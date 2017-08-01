/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.spring.jdbc;

/**
 *
 * @author 72010995
 */
public class Customer
{

    int custId;
    String name;
    int age;

    public Customer(int id, String name, int age)
    {
        this.custId=id;
        this.name=name;
        this.age=age;
    }
    public int getCustId()
    {
        return custId;
    }

    public void setCustId(int custId)
    {
        this.custId = custId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Id:"+custId+"  name:"+name+"  age:"+age;
    }

    
}
