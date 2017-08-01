/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.interceptor.test;

import com.farkalit.emp.test.Employee;
import java.io.Serializable;
import java.util.Iterator;
import org.hibernate.type.Type;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;

/**
 * Set this line in HibSessionManager//conf.setInterceptor(new
 * MyInterceptor());//Optional
 *
 * @author fusman
 */
public class MyInterceptor extends EmptyInterceptor {

    private int updates;
    private int creates;
    private int loads;

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void onDelete(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        // do nothing
    }

    // This method is called when Employee object gets updated.
    public boolean onFlushDirty(Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof Employee) {
            System.out.println("onFlushDirty:Update Operation");
            return true;
        }
        return false;
    }

    public boolean onLoad(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        // do nothing
        return true;
    }

    // This method is called when Employee object gets created.
    public boolean onSave(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof Employee) {
            System.out.println("onSave:Create Operation");
            return true;
        }
        return false;
    }

    //called before commit into database
    public void preFlush(Iterator iterator) {
        System.out.println("preFlush");
    }

    //called after committed into database
    public void postFlush(Iterator iterator) {
        System.out.println("postFlush");
    }
}
