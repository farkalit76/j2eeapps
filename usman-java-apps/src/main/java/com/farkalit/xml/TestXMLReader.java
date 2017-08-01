/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.xml;

import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 72010995
 */
public class TestXMLReader
{
    private static final String ECIS_URLS_CONFIG_FILENAME = "ecis-urls-config.xml";
    private static EcisUrlsData ecisUrls;
    
    public static void main(String[] args)
    {
        TestXMLReader test = new TestXMLReader();
        ecisUrls = test.loadEcisUrlData();
        for (EcisPlus plus : ecisUrls.getEcisPlus())
        {
            System.out.println("Type:"+plus.getType()+ " Value:"+plus.getValue());
            
        }
    }
    
    private EcisUrlsData loadEcisUrlData()
    {
        // load config from local XML file
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(EcisUrlsData.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream ecisUrlFile = this.getClass().getClassLoader().getResourceAsStream(ECIS_URLS_CONFIG_FILENAME);
            EcisUrlsData ecisItems = (EcisUrlsData) unmarshaller.unmarshal(ecisUrlFile);
            System.out.println("Successfully loaded Ecis Url Data from :"+ ECIS_URLS_CONFIG_FILENAME);
            System.out.println("Ecis Url Data Size :"+ ecisItems.getEcisPlus().size());
            return ecisItems;
        }
        catch (Exception ex)
        {
            System.out.println("Failed to load Demo Ecis Url Data  list from XML file : "+ ECIS_URLS_CONFIG_FILENAME);
            System.out.println("ERROR"+ex.getMessage());
            return null;
        }
    }
}
