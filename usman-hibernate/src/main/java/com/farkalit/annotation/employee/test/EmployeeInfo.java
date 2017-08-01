/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.annotation.employee.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 72010995
 */
@Entity
@Table(name = "employee_info")
public class EmployeeInfo
{

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "education")
    private String education;

    @Column(name = "salary")
    private double salary;

    public EmployeeInfo()
    {
    }

    public EmployeeInfo(String fname, String lname, int age, String sex, String education, double salary)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.sex = sex;
        this.education = education;
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getEducation()
    {
        return education;
    }

    public void setEducation(String education)
    {
        this.education = education;
    }

    @Override
    public String toString()
    {
        return "EmployeeInfo{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex=" + sex + ", education=" + education + ", salary=" + salary + '}';
    }

    
}
