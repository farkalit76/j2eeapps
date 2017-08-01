/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.library.test;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 72010995
 */
public class BookCatalog implements Serializable
{

    private long id;
    private String name;
    private String author;
    private double price;
    private Date printingYear;
    private int pages;
    private int available;

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

    public Date getPrintingYear()
    {
        return printingYear;
    }

    public void setPrintingYear(Date printingYear)
    {
        this.printingYear = printingYear;
    }

    public int getPages()
    {
        return pages;
    }

    public void setPages(int pages)
    {
        this.pages = pages;
    }

    public int getAvailable()
    {
        return available;
    }

    public void setAvailable(int available)
    {
        this.available = available;
    }

    @Override
    public String toString()
    {
        return "BookCatalog{" + "id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", printingYear=" + printingYear + ", pages=" + pages + ", available=" + available + '}';
    }
    
    

}
