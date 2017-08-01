/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.jdbc.sp;

import com.farkalit.jdbc.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class GNGDailyCallList
{

    private static Connection conn = null;
    private static ResultSet rset = null;
    private static CallableStatement cstat = null;
    private static int totalRecords = 0;

    private static final List<String> dataList = new ArrayList<>();

    public static void main(String[] args)
    {
        //String startDate = "2015-11-14 13:00:00";
        //String endDate   = "2015-11-14 15:00:00";
        String startDate = "2015-11-16 11:00:00";
        String endDate = "2015-11-17 00:00:00";
        long startTime = System.currentTimeMillis();
        getGNGSurveyData(startDate, endDate);
        System.out.println("Elapsed Time:" + (startTime - System.currentTimeMillis()) / 1000 + " seconds");
    }

    public static void getGNGSurveyData(String startDate, String endDate)
    {
        try
        {
            conn = DBConnection.getConnection();
            cstat = conn.prepareCall("{call logdb.GNG_JD_SURVEY_LOOPER(?,?)}");
            cstat.setString(1, startDate);
            cstat.setString(2, endDate);

            boolean isResultSet = cstat.execute();
            // First ReulstSet object
            if (!isResultSet)
            {
                System.out.println("The first result is not a ResultSet.");
            }
            else
            {
                System.out.println("Hour [" + 0 + "]");
                System.out.println("First ResultSet of the table:");
                rset = cstat.executeQuery();
                printResultSet(rset);
                rset.close();
            }

            //Retrieve for next twelve hours
            for (int h = 1; h <= 13; h++)
            {
                System.out.println("Hour [" + h + "]");
                // Move to the next result
                isResultSet = cstat.getMoreResults();
                if (!isResultSet)
                {
                    System.out.println("The next result is not a ResultSet.");
                }
                else
                {
                    // Next ReulstSet object
                    System.out.println("Next ResultSet of the table:");
                    rset = cstat.getResultSet();
                    printResultSet(rset);
                    rset.close();
                }
            }
            //Create CSV file:
            CSVFileUtil.generateCsvFile(dataList);
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

    public static int printResultSet(ResultSet result) throws SQLException
    {
        int count = 0;
        while (result.next())
        {
            count++;
            //Retrieve by column name
            String lastName = (result.getString("last_name") != null) ? result.getString("last_name") : "";
            String firstName = (result.getString("first_name") != null) ? result.getString("first_name") : "";
            String exceptionReason = (result.getString("exception_reason") != null) ? result.getString("exception_reason") : "";
            final String CHECK = "please_check_name_when_>=1_and_remove_this_column_when_done";
            String pleaseCheck = (result.getString(CHECK) != null) ? result.getString(CHECK) : "";

            StringBuilder build = new StringBuilder();
            build.append(result.getString("session_id")).append(",");
            build.append(lastName).append(",");
            build.append(firstName).append(",");
            build.append(result.getString("customer_phone_number")).append(",");
            build.append(result.getString("contact_date")).append(",");
            build.append(result.getString("call_center")).append(",");
            build.append(result.getString("reason_for_call")).append(",");
            build.append(result.getString("call_type")).append(",");
            build.append(result.getString("exception_record")).append(",");
            build.append(exceptionReason).append(",");
            build.append(pleaseCheck).append(",");
            build.append("\n");

            dataList.add(build.toString());
            //Display values
            // System.out.print("[" + count + "] ID: " + result.toString());
        }
        totalRecords += count;
        System.out.println("Count:" + count + ",total record count:" + totalRecords);
        return count;
    }

}
