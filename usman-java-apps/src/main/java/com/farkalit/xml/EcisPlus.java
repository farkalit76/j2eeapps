/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author 72010995
 */
@XmlAccessorType(XmlAccessType.NONE)
public class EcisPlus
{
            
    @XmlAttribute(name = "type")
    private String type;
    
    @XmlAttribute(name = "value")
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

 
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }   
    
}
