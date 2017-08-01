/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.jersey.crud;

import com.usman.jersey.jaxb.Todo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author 72010995
 */
public class TodoCrud
{

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public TodoCrud(UriInfo uriInfo, Request request, String id)
    {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration     
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Todo getTodo()
    {
        Todo todo = TodoDao.getInstance().getModel().get(id);
        if (todo == null)
        {
            throw new RuntimeException("Get: Todo with " + id + " not found");
        }
        return todo;
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Todo getTodoHTML()
    {
        Todo todo = TodoDao.getInstance().getModel().get(id);
        if (todo == null)
        {
            throw new RuntimeException("Get: Todo with " + id + " not found");
        }
        return todo;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putTodo(JAXBElement<Todo> todo)
    {
        Todo c = todo.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    public void deleteTodo()
    {
        Todo c = TodoDao.getInstance().getModel().remove(id);
        if (c == null)
        {
            throw new RuntimeException("Delete: Todo with " + id + " not found");
        }
    }

    private Response putAndGetResponse(Todo todo)
    {
        Response res;
        if (TodoDao.getInstance().getModel().containsKey(todo.getId()))
        {
            res = Response.noContent().build();
        }
        else
        {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        TodoDao.getInstance().getModel().put(todo.getId(), todo);
        return res;
    }

}
