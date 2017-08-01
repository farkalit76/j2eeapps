/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.jersey.crud;

import com.usman.jersey.jaxb.Todo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 72010995
 */
public class TodoDao
{

    //create singleton instance;
    private static TodoDao instance;

    public static synchronized TodoDao getInstance()
    {
        if (instance == null)
        {
            instance = new TodoDao();
        }
        return instance;
    }

    private Map<String, Todo> contentProvider = new HashMap<String, Todo>();

    private TodoDao()
    {

        Todo todo = new Todo("1", "Learn REST");
        todo.setDescription("Read http://www.usman.com/tutorials/REST/article.html");
        contentProvider.put("1", todo);
        
        todo = new Todo("2", "Do something");
        todo.setDescription("Read complete http://www.usman.com");
        contentProvider.put("2", todo);

    }

    public Map<String, Todo> getModel()
    {
        return contentProvider;
    }
}
