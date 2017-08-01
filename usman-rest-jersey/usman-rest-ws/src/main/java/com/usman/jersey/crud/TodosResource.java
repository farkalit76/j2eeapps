/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.jersey.crud;

import com.usman.jersey.jaxb.Todo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author 72010995
 */
// Will map the resource to the URL todos
@Path("/todos")
public class TodosResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of todos to the user in the browser
    @GET
    @Path("list")
    @Produces({MediaType.TEXT_XML})
    public List<Todo> getTodosBrowser()
    {
        List<Todo> todos = new ArrayList<Todo>();
        todos.addAll(TodoDao.getInstance().getModel().values());
        return todos;
    }

    // Return the list of todos for applications
    @GET
    @Path("listall")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Todo> getTodos()
    {
        List<Todo> todos = new ArrayList<Todo>();
        todos.addAll(TodoDao.getInstance().getModel().values());
        return todos;
    }

    // retuns the number of todos
    // Use http://localhost:8080/UsmanRESTTest/rest/todos/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String getCount()
    {
        int count = TodoDao.getInstance().getModel().size();
        return String.valueOf(count);
    }

    //http://localhost:8030/usman-rest-ws/createtodo.jsp
    @POST
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("create")
    public void newTodo(@FormParam("id") String id,
            @FormParam("summary") String summary,
            @FormParam("description") String description,
            @Context HttpServletRequest servletRequest,
            @Context HttpServletResponse servletResponse) throws IOException, ServletException
    {
        System.out.println("Todo create started... for id:" + id + ", summary:" + summary + ", description" + description);
        Todo todo = new Todo(id, summary);
        if (description != null)
        {
            todo.setDescription(description);
        }
        System.out.println("Todo create started...2");
        TodoDao instance = TodoDao.getInstance();
        instance.getModel().put(id, todo);
        System.out.println("Todo create started...3");
        Todo newTodo = instance.getModel().get(id);
        String result = "";
        if (newTodo != null)
        {
            result = "Id:" + newTodo.getId() + ", Summary:" + newTodo.getSummary() + ", Description:" + newTodo.getDescription();
            System.out.println(result);
        }
  
        
//        //Need to modify so that its response value should be cleaned.
          servletRequest.setAttribute("NEWTODO", result);
//        RequestDispatcher requestDispatcher = null;
//        requestDispatcher = servletRequest.getRequestDispatcher("../../createtodo.jsp");
//        requestDispatcher.forward(servletRequest, servletResponse);
        
       //servletResponse.sendRedirect("../../create_todo.html");
       servletResponse.sendRedirect("../../createtodo.jsp");
    }

    // Defines that the next path parameter after todos is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/UsmanRESTTest/rest/todos/1
    // 1 will be treaded as parameter todo and passed to TodoResource
    @Path("{todo}")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public TodoCrud getTodo(@PathParam("todo") String id)
    {
        return new TodoCrud(uriInfo, request, id);
    }
}
