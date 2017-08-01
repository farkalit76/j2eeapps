/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.ws.service;

import com.usman.springhib.ws.exception.GenericException;
import com.usman.springhib.ws.model.Entity;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author 72010995
 */
@WebService(portName = "EntityPort", name = "EntityEndpoint", serviceName = "EntityService", targetNamespace = "http://springhib.usman.com/entity/ws")
public class EntityServiceImpl implements EntityService
{
    private List<Entity> entityList = new ArrayList<Entity>();

    @WebMethod(operationName = "listEntityData")
    public List<Entity> listEntityData() throws GenericException
    {
        System.out.println("List size is:"+entityList.size());
        return entityList;
    }

    @WebMethod(operationName = "getEntityData")
    public Entity getEntityData(@WebParam(name = "id") String id) throws GenericException
    {
        Entity entity = new Entity();
        entity.setId("123");
        entity.setDesc("Hello World, Web Services");
        return entity;
    }

    @WebMethod(operationName = "insertEntityData")
    public void insertEntityData(@WebParam(name = "entity")Entity entity) throws GenericException
    {
        System.out.println("New Entity:"+entity.toString());
        entityList.add(entity);
        System.out.println("New Entity Added, New list size is:"+entityList.size());
    }
}
