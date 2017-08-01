/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.ws.client.test;

import com.usman.springhib.ws.client.EntityEndpointFactory;
import com.usman.springhib.entity.ws.Entity;
import com.usman.springhib.entity.ws.EntityEndpoint;
import com.usman.springhib.entity.ws.GenericException_Exception;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class EntityEndpointFactoryTest
{
    public static void main(String[] args)
    {
        EntityEndpoint endpoint =   EntityEndpointFactory.create();
        try
        {
            Entity entity1 = new Entity();
            entity1.setId("101");
            entity1.setDesc("Des...101");         
            endpoint.insertEntityData(entity1);
            
            List<Entity> listEntityData = endpoint.listEntityData();
            System.out.println("Entity list:"+listEntityData.size());
            for (Entity ents : listEntityData)
            {
                System.out.println("Entity list:"+ents.getId()+","+ents.getDesc());
            }
            Entity entity = endpoint.getEntityData("123");
            System.out.println("Output:"+entity.getId()+":"+entity.getDesc());
        }
        catch (GenericException_Exception ex)
        {
            System.out.println("Error in Client Test:"+ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
}
