/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.model;

import java.util.Date;

/**
 *
 * @author 72010995
 */
public class CustomerTrxn
{

    private long id;
    private Date date;
    private double total;
    private Customer customer;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    @Override
    public String toString()
    {
        return id + ", " + total + ", " + customer.getName() + ", " + customer.getEmail() + ", " + customer.getAddress();
    }

}
