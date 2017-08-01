/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.clone;

/**
 *
 * @author 72010995
 */
public class Activity extends Header
{

    private Short code;
    private Header header;

    public Activity()
    {
        super();
    }

    public Activity(Activity clone)
    {
        super(clone);
        this.code = clone.code;
    }

    public Activity(Header clone)
    {
        super(clone);
        this.header = new Header(clone);
    }

    public Short getCode()
    {
        return code;
    }

    public void setCode(Short code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "This activity has header :" + header;
    }

}
