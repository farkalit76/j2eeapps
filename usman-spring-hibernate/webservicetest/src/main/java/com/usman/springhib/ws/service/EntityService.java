/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.ws.service;

import com.usman.springhib.ws.exception.GenericException;
import com.usman.springhib.ws.model.Entity;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface EntityService
{

    List<Entity> listEntityData() throws GenericException;
    Entity getEntityData(String id) throws GenericException;
    void insertEntityData(Entity entity) throws GenericException;
    //@WebMethod(operationName = "getEntityData") //Indicates a webservice method.
    //public Entity getEntityData(@WebParam(name = "id") String id) throws GenericException; //Indicates a parameter used in the operations, argument to be displayed on the WSDL.
}
