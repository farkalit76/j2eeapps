/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fusman
 */
public class Customer {

    private Person person;
    private int type;
    private String action;

    //Autowired setter method
    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    //Autowired constructor method
    //    @Autowired
    //    public Customer(Person person) {
    //        this.person = person;
    //    }
    
    //Autowired field
    //    @Autowired
    //    private Person person;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Customer{" + "person=" + person + ", type=" + type + ", action=" + action + '}';
    }
}
