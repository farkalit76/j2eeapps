/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 72010995
 */
public class DbSample
{

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rset = null;

    public static void main(String[] args)
    {
        getData();
        insertData();
    }
    
    /**
     * This test is from flowdb database.
     */
    public static void getData()
    {
        //String SQL = "select * from change_history where id=5";
        String SQL = "select * from change_history";
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rset = stmt.executeQuery(SQL);

            while (rset.next())
            {
                //Retrieve by column name
                int id = rset.getInt("ID");
                String name = rset.getString("UserName");
                String reason = rset.getString("CHANGE_REASON");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print(", reason: " + reason);
                System.out.println();

            }
        }
        catch (SQLException e)
        {
            System.err.println("Error while data retrieving....");
        }
        finally
        {
            DBConnection.closeConnection(conn);
        }
    }

     public static void insertData()
    {
        int pk = +(int)(Math.random()*99);
        String SQL = "insert into change_history values("+pk+", 'Ahmad-"+pk+"', 'Let me know about you')";
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            boolean flag =stmt.execute(SQL);
            System.out.println("flag:"+flag);
            if (!flag)
            {
                System.out.println("Data inserted...");
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error while data inserting...."+e.getMessage());
        }
        finally
        {
            DBConnection.closeConnection(conn);
        }
    }

}
