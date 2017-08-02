/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.jaxb;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author fusman
 */
@XmlType
public class Person {

    private String name;
    private int age;
    private String gender;
// constructors

    public Person()
    {
    }

    public Person(String name, int age, String gender)
    {
        setName(name);
        setAge(age);
        setGender(gender);
    }
// properties: name, age, gender

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name
                = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age
                = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
}
