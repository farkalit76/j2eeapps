package com.usman.springhib.ws.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 72010995
 */
public class Entity
{
    private String id;
    private String desc;

    public Entity(){}
    
    public Entity(String id, String desc)
    {
        this.id = id;
        this.desc = desc;
    }

    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return "Entity{" + "id=" + id + ", desc=" + desc + '}';
    }
    
    
}
