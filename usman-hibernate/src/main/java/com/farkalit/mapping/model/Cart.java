/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.model;

import java.util.Set;

/**
 *
 * @author 72010995
 */
public class Cart
{

    private long id;
    private double total;
    private String name;
    private Set<CartItems> items;
    

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<CartItems> getItems()
    {
        return items;
    }

    public void setItems(Set<CartItems> items)
    {
        this.items = items;
    }

}
