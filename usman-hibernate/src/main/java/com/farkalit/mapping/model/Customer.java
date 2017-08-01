/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.model;

/**
 *
 * @author 72010995
 */
public class Customer
{

    private long id;
    private String name;
    private String email;
    private String address;

    private CustomerTrxn trxn;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public CustomerTrxn getTrxn()
    {
        return trxn;
    }

    public void setTrxn(CustomerTrxn trxn)
    {
        this.trxn = trxn;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", trxn=" + trxn + '}';
    }

}
