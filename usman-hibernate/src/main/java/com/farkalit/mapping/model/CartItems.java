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
public class CartItems
{

    private long id;
    private String itemId;
    private double itemTotal;
    private int quantity;
    private Cart cart;

     //Hibernate requires no-args constructor
    public CartItems()
    {
    }

    public CartItems(String itemId, double total, int qty, Cart c)
    {
        this.itemId = itemId;
        this.itemTotal = total;
        this.quantity = qty;
        this.cart = c;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getItemId()
    {
        return itemId;
    }

    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public double getItemTotal()
    {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal)
    {
        this.itemTotal = itemTotal;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }


}
