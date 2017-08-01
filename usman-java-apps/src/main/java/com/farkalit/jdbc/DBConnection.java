/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class DBConnection
{

//    private static final String USER = "flowdba";
//    private static final String PASS = "d49351247f";
//    private static final String URLs = "jdbc:mysql://vdalvwappd023:3306/flowdb";

    
    private static final String USER = "root";
    private static final String PASS = "root";
    //private static final String URLs = "jdbc:mysql://IND-FULP-0040:3306/usmandb";
    private static final String URLs = "jdbc:mysql://localhost:3306/usmandb";
    
    //Production Server
    //    private static final String USER = "dchadha";
    //    private static final String PASS = "dchadha1";
//    private static final String USER = "fusman";
//    private static final String PASS = "fusman1";
//    private static final String URLs = "jdbc:mysql://VDALVWAPPP015.vertex.shared:3306/logdb?zeroDateTimeBehavior=convertToNull";
//    
    
    public DBConnection()
    {
    }

    public static void getDiverInstance()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        catch (InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection()
    {
        Connection conn = null;
        try
        {
            getDiverInstance();
            conn = DriverManager.getConnection(URLs, USER, PASS);
            System.out.println("DB Connection is ready.");
        }
        catch (SQLException ex)
        {
            System.err.println("Connection Error:"+ ex.getMessage());
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeConnection(Connection conn)
    {
        try
        {
            conn.close();
            System.out.println("DB Connection closed");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conn != null)
            {
                conn = null;
            }
        }
    }

    public static void main(String[] args)
    {
        Connection conn = DBConnection.getConnection();
        System.out.println("Connection ready");
        DBConnection.closeConnection(conn);
        System.out.println("Connection closed..");
    }
}
