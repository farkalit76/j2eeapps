/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.data;

/**
 *
 * @author 72010995
 */
public class Patient extends Admin
{

    private String name;
    private Integer age;
    private String address;
    private String phone;
    private String email;
    private Character sex;
    private String description;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Character getSex()
    {
        return sex;
    }

    public void setSex(Character sex)
    {
        this.sex = sex;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return super.toString()+"Patient{" + "name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + ", email=" + email + ", sex=" + sex + ", description=" + description + '}';
    }

 

}
