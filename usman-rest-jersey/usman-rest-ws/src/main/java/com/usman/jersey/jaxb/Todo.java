/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.jersey.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
 *
 * @author 72010995
 */
@XmlRootElement
public class Todo
{

    private String id;
    private String summary;
    private String description;

    public Todo()
    {

    }

    public Todo(String id, String summary)
    {
        this.id = id;
        this.summary = summary;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
