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
public class LibraryInfo implements Serializable
{
    private int id;
    private String name;
    private String address;
    private Date established;
    private String founder;

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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Date getEstablished()
    {
        return established;
    }

    public void setEstablished(Date established)
    {
        this.established = established;
    }

    public String getFounder()
    {
        return founder;
    }

    public void setFounder(String founder)
    {
        this.founder = founder;
    }

    @Override
    public String toString()
    {
        StringBuilder build = new StringBuilder("Library: [");
        build.append(id).append("|");
        build.append(name).append("|");
        build.append(address).append("|");
        build.append(established).append("|");
        build.append(founder).append("|");
        
        return build.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
