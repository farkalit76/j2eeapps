/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.emp.test;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 72010995
 */
public class Employee implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private char sex;
    private String education;
    private double salary;
    private Date joiningDate;

    public Employee() {
    }

    public Employee(String fname, String lname, int age, char sex, double salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }
    
    public Employee(String fname, String lname, int age, char sex, double salary, String education, Date jDate) {
        this(fname,lname,age,sex,salary);
        this.education=education;
        this.joiningDate=jDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {

        StringBuilder buff = new StringBuilder("Employee:[");
        buff.append(id).append("|");
        buff.append(firstName).append("|");
        buff.append(lastName).append("|");
        buff.append(age).append("|");
        buff.append(sex).append("|");
        buff.append(education).append("|");
        buff.append(salary).append("|");
        buff.append(joiningDate).append("]");
        return buff.toString();
    }

}
