/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "getTimeAsElapsedResponse", namespace = "http://ts.chapter1.webreading.farkalit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTimeAsElapsedResponse", namespace = "http://ts.chapter1.webreading.farkalit.com/")
public class GetTimeAsElapsedResponse {

    @XmlElement(name = "return", namespace = "")
    private long _return;

    public long getReturn()
    {
        return this._return;
    }

    public void setReturn(long paramLong)
    {
        this._return = paramLong;
    }
}
