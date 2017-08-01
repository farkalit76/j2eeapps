/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.db.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class HsqlDbTest {

    public static void main(String[] args) {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
        
        try {
             //Connection c = DriverManager.getConnection("jdbc:hsqldb:file:testdb", "SA", "");//It is working
            //Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
            Connection c = DriverManager.getConnection("jdbc:hsqldb::http://localhost/xdb", "SA", "");
            //For secure connection
            //Connection c = DriverManager.getConnection("jdbc:hsqldb:hsqls://localhost/xdb", "SA", "");
            //Connection c = DriverManager.getConnection("jdbc:hsqldb:https://localhost/xdb", "SA", "");
        } catch (SQLException ex) {
            Logger.getLogger(HsqlDbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
