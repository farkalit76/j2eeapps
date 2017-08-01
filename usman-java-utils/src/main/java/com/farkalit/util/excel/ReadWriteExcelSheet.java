/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 72010995
 */
public class ReadWriteExcelSheet
{

    public static void main(String[] args)
    {
        try
        {
            //readXlsx();
            writeExcel();
            //test();
        }
        catch (Throwable ex)
        {
            ex.printStackTrace();
        }
    }

    public static void readExcel() throws FileNotFoundException, IOException
    {
        File myFile = new File("F://test/ExcelBook1.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        // Finds the workbook instance for XLSX file 
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        // Return first sheet from the XLSX workbook 
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        // Get iterator to all the rows in current sheet 
        Iterator<Row> rowIterator = mySheet.iterator();
        // Traversing over each row of XLSX file 
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            // For each row, iterate through each columns 
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:
                }
            }
            System.out.println("");
        }
    }

    public static void writeExcel() throws FileNotFoundException, IOException
    {

//        try
//        {
        SXSSFWorkbook myWorkBook = new SXSSFWorkbook(10); // keep 10 rows in memory, exceeding rows will be flushed to disk
        Sheet mySheet = myWorkBook.createSheet("test");
        // Now, let's write some data into our XLSX file
        Map<String, Object[]> data = new HashMap<>();
        data.put("7", new Object[]
        {
            8d, "Sonya", "75K", "SALES", "Rupert"
        });
        data.put("8", new Object[]
        {
            8d, "Kris", "85K", "SALES", "Rupert"
        });
        data.put("9", new Object[]
        {
            9d, "Dave", "90K", "SALES", "Rupert"
        });

        // Set to Iterate and add rows into XLS file
        Set<String> newRows = data.keySet();

        // get the last row number to append new data          
        int rownum = mySheet.getLastRowNum();

        for (String key : newRows)
        {

            // Creating a new Row in existing XLSX sheet
            Row row = mySheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                {
                    cell.setCellValue((String) obj);
                }
                else if (obj instanceof Boolean)
                {
                    cell.setCellValue((Boolean) obj);
                }
                else if (obj instanceof Date)
                {
                    cell.setCellValue((Date) obj);
                }
                else if (obj instanceof Double)
                {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        // open an OutputStream to save written data into XLSX file
        FileOutputStream os = new FileOutputStream("F://test/ExcelWrite.xlsx");
        myWorkBook.write(os);
        System.out.println("Writing on XLSX file Finished ...");

    }

    public static void updateExcel() throws FileNotFoundException, IOException
    {
        //        try
//        {
        File myFile = new File("F://test/ExcelBook1.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        // Finds the workbook instance for XLSX file 
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        // Return first sheet from the XLSX workbook 
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        // Now, let's write some data into our XLSX file
        Map<String, Object[]> data = new HashMap<>();
        data.put("7", new Object[]
        {
            8d, "Sonya", "75K", "SALES", "Rupert"
        });
        data.put("8", new Object[]
        {
            8d, "Kris", "85K", "SALES", "Rupert"
        });
        data.put("9", new Object[]
        {
            9d, "Dave", "90K", "SALES", "Rupert"
        });

        // Set to Iterate and add rows into XLS file
        Set<String> newRows = data.keySet();

        // get the last row number to append new data          
        int rownum = mySheet.getLastRowNum();

        for (String key : newRows)
        {

            // Creating a new Row in existing XLSX sheet
            Row row = mySheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                {
                    cell.setCellValue((String) obj);
                }
                else if (obj instanceof Boolean)
                {
                    cell.setCellValue((Boolean) obj);
                }
                else if (obj instanceof Date)
                {
                    cell.setCellValue((Date) obj);
                }
                else if (obj instanceof Double)
                {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        // open an OutputStream to save written data into XLSX file
        FileOutputStream os = new FileOutputStream(myFile);
        myWorkBook.write(os);
        System.out.println("Writing on XLSX file Finished ...");
    }
}
