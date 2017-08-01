/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.spring;

/**
 *
 * @author fusman
 */
public class EmployeeDI {

    private int id;
    private String name;
    private Address address;

    public EmployeeDI() {
        System.out.println("Empty constructor.");
    }

    public EmployeeDI(int id) {
        this.id = id;
    }

    public EmployeeDI(String name) {
        this.name = name;
    }

    public EmployeeDI(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EmployeeDI(int id, String name, Address address) {
        this(id, name);
        this.address = address;
    }

    void show() {
        System.out.println("Employee Id:" + id + " and name: " + name);
    }

    void showAll() {
        System.out.println("Employee Id:" + id + " and name: " + name);
        System.out.println(address.toString());
    }
}
