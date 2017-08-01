/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 72010995
 */
public class JavaFileWriter {

    public static void main(String args[]) {
        createResultFile();
    }

    private static void createResultFile() {
        boolean fileFlag = true;
        try {
            // Create file 
            int jobId = 112;
            String timestamp = getTimeStamp();
            String fileName = "DCWResult_" + timestamp + "_" + jobId + ".csv";
            File file = new File(fileName);

            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
                fileFlag = false;
            }

            FileWriter fstream = new FileWriter(file.getName(), true);

            BufferedWriter out = new BufferedWriter(fstream);
            if (!fileFlag) {
                out.write(getFileHaeder());
            }
            out.write(getResultValues());
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Create File Error: " + e.getMessage());
        }

    }

    private static String getFileHaeder() {
        //Set header
        StringBuilder buffer = new StringBuilder();
        buffer.append("user_contact_id,phone_number1,time_zone,alertType,productId,consumerId,mediaType,contact_attempt_time,last_completion_code").append("\n");
        return buffer.toString();
    }

    private static String getResultValues() {

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            //Set file values
            buffer.append("216264").append(",");
            buffer.append("2145761103").append(",");
            buffer.append("EST5EDT").append(",");
            buffer.append("REMINDER").append(",");
            buffer.append("00010977079 2671 R1ZPN COLL").append(",");
            buffer.append("0056594 $332.71 $478.79").append(",");
            buffer.append("VOICE").append(",");
            buffer.append("28-09-2016  11:43:23").append(",");
            buffer.append("TRANSFER_TO_IVR").append("\n");
        }
        return buffer.toString();
    }

    private static String getTimeStamp() {
        Date date = new Date();
        //SimpleDateFormat fmt = new SimpleDateFormat("MMddyyyy_HHmmss.SSS");
        SimpleDateFormat fmt = new SimpleDateFormat("MMddyyyy");
        String timestamp = fmt.format(date);
        System.out.println("timestamp:" + timestamp);
        return timestamp;
    }

}
