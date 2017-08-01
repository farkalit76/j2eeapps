/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 72010995
 */
public class HsqlDBTest
{

    public static void main(String[] args)
    {

        try
        {
            //Class.forName("org.hsqldb.jdbcDriver");
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            System.out.println("Driver is ready...");
            Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa", "");
        }
        catch (Exception e)
        {   
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }

    }
}
