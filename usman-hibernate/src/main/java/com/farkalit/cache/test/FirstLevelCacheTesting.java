/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.cache.test;

import com.farkalit.library.test.Student;
import com.farkalit.util.HibSessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * First Level Cache: Hibernate first level cache is associated with the Session object. 
 * Hibernate first level cache is enabled by default and there is no way to disable it. 
 * However hibernate provides methods through which we can delete selected objects 
 * from the cache or clear the cache completely.
 * Any object cached in a session will not be visible to other sessions and when the 
 * session is closed, all the cached objects will also be lost.
 * 
 * @author 72010995
 */
public class FirstLevelCacheTesting
{

    private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();

    public static void main(String[] args)
    {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = (Student) session.get(Student.class, 1);

        System.out.println("\n student:" + student.toString());
                
        student.setLastName("Usmani"); //update name by setting value: it will update data as session is open
         
        student = (Student) session.get(Student.class, 1); //It will retrieve data from cache. See the LOG that hibernate query not run 

        System.out.println("\n second retrieval of student:" + student.toString());
        
        session.evict(student);
        student = (Student) session.get(Student.class, 1);

        System.out.println("\n third retrieval of student after evict:" + student.toString());
        
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        Student student2 = (Student) session2.get(Student.class, 1);
        System.out.println("\n\nStudent2:" + student2.toString());
        session2.close();

        //See the diffrence of get() and load() methods
        
        System.out.println("\n\n Diffrence of get() and load()");
        Session session3 = sessionFactory.openSession();
        session3.beginTransaction();

        student = (Student) session3.load(Student.class, 1);
        System.out.println("\n\nData retrieved as a virtual memory....but no query printed in log.");
        if( student != null ){
            System.out.println("\n Now it will print the log when student data actually retrieved:" + student.toString());
        }
        tx.commit();
        
        HibSessionManager.closeSessionFactory();
    }
}
