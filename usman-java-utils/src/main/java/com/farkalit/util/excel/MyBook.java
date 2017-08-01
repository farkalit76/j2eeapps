/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.excel;

import java.util.Date;

/**
 *
 * @author 72010995
 */
public class MyBook
{
    private int id;
    private String name;
    private String author;
    private double price;
    private long pages;
    private Date printDate;

    public MyBook(int id, String name, String author)
    {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public long getPages()
    {
        return pages;
    }

    public void setPages(long pages)
    {
        this.pages = pages;
    }

    public Date getPrintDate()
    {
        return printDate;
    }

    public void setPrintDate(Date printDate)
    {
        this.printDate = printDate;
    }

    
    @Override
    public String toString()
    {
        return "MyBook{" + "id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", pages=" + pages + ", printDate=" + printDate + '}';
    }
    
    
}
