/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 72010995
 */
@XmlRootElement(name = "ecisUrls")
@XmlAccessorType(XmlAccessType.NONE)
public class EcisUrlsData
{

    @XmlElement(name = "ecisPlus")
    private List<EcisPlus> ecisPlus;

    public List<EcisPlus> getEcisPlus()
    {
        return ecisPlus;
    }

    public void setEcisPlus(List<EcisPlus> ecisPlus)
    {
        this.ecisPlus = ecisPlus;
    }

}
