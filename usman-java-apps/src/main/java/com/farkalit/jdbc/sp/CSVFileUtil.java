/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.jdbc.sp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class CSVFileUtil
{

    private static final String fileHeader = "session_id,last_name,first_name,customer_phone_number,contact_date,call_center,ason_for_call,call_type,exception_record,exception_reason,please_check_name_when_>=1_and_remove_this_column_when_done" + "\n";

    public static void main(String[] args)
    {
        List<String> dataList = new ArrayList<>();
        dataList.add(fileHeader);
        String builder = "Usman,39,\n";
        String builder2 = "Usmani,29,\n";
        String builder3 = "Usmaniii,38,\n";
        dataList.add(builder);
        dataList.add(builder2);
        dataList.add(builder3);
        generateCsvFile(dataList);
    }

    public static void generateCsvFile(List<String> dataList)
    {
        System.out.println("CSV file creation started...");
        try
        {
            String fileName = getFileName();
            System.out.println("csv file name:" + fileName);
            System.out.println("dataList size:" + dataList.size());
            FileWriter writer = new FileWriter(fileName);
            writer.append(fileHeader);
            for (String row : dataList)
            {
                writer.append(row);
            }
            //generate whatever data you want
            writer.flush();
            writer.close();
            System.out.println("CSV file created!!!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String getFileName()
    {
        Calendar cal = Calendar.getInstance();
        String date = "" + cal.get(Calendar.DATE) + (cal.get(Calendar.MONTH) + 1) + cal.get(Calendar.YEAR) + "_"
                + cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND);
        return "F:\\GNG_JD_Survey_" + date + ".csv";
    }

}
