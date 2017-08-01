/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.jdbc.sp;

import com.farkalit.jdbc.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 72010995
 */
public class TestStoreProcedure
{

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rset = null;

    public static void main(String[] args)
    {
        //getDataByQuery();
        //getEmpByStoreProcedure();
        getCatalogByStoreProcedure();
    }

    public static void getCatalogByStoreProcedure()
    {
        CallableStatement cstat = null;
        try
        {
            Date date = new Date(2010-1900,10-1,15);
            System.out.println("date:"+date);
            conn = DBConnection.getConnection();
            cstat = conn.prepareCall("{call show_catalog(?,?)}");
            cstat.setDouble(1, 400);
             //cstat.setDate(2, date);
            cstat.setString(2, "2010-11-12 11:00:00");
            rset = cstat.executeQuery();

            while (rset.next())
            {
                //Retrieve by column name
                int id = rset.getInt("ID");
                String fname = rset.getString("name");
                Double price = rset.getDouble("price");
                Date pYear = rset.getDate("printing_year");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + fname);
                System.out.print(", Price: " + price);
                System.out.print(", Printing Year: " + pYear);
                System.out.println();

            }
        }
        catch (SQLException e)
        {
            System.err.println("Error while data retrieving....");
            e.printStackTrace();
        }
        finally
        {
            DBConnection.closeConnection(conn);
        }
    }
    
        
//    //@Override
//    public List<GNGCallData> getCallDataTest(String startDate, String endDate)
//    {
//        String callStoreProcedure = "CALL show_catalog(:bookPrice, :printYear)";
//        final Session session = sessionFactory.getCurrentSession();
//        // Query query = session.createSQLQuery(callStoreProcedure).setResultTransformer(Transformers.aliasToBean(GNGCallData.class));
//        Query query = session.createSQLQuery(callStoreProcedure);
//        query.setDouble("bookPrice", 400);
//        query.setString("printYear", "2010-11-12 11:00:00");
//
//        List list = query.list();
//
//        if (list != null && !list.isEmpty())
//        {
//            for (Object data : list)
//            {
//                System.out.println("data:" + data.toString());
//            }
//        }
//        return callDataList;
//    }

    public static void getEmpByStoreProcedure()
    {
        CallableStatement cstat = null;
        try
        {
            conn = DBConnection.getConnection();

            cstat = conn.prepareCall("{call show_employee()}");
            rset = cstat.executeQuery();

            while (rset.next())
            {
                //Retrieve by column name
                int id = rset.getInt("ID");
                String fname = rset.getString("firstName");
                String lname = rset.getString("lastName");
                String education = rset.getString("education");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", firstName: " + fname);
                System.out.print(", lastName: " + lname);
                System.out.print(", education: " + education);
                System.out.println();

            }
        }
        catch (SQLException e)
        {
            System.err.println("Error while data retrieving....");
            e.printStackTrace();
        }
        finally
        {
            DBConnection.closeConnection(conn);
        }
    }

    public static void getDataByQuery()
    {
        String SQL = "SELECT  emp.id, emp.firstName, emp.lastName "
                + "FROM    EMPLOYEE emp";
        try
        {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rset = stmt.executeQuery(SQL);

            while (rset.next())
            {
                //Retrieve by column name
                int id = rset.getInt("ID");
                String type = rset.getString("firstName");
                String time = rset.getString("lastName");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", firstName: " + type);
                System.out.print(", lastName: " + time);
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
}
