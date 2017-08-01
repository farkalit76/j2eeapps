/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.controller;

import com.usman.study.upload.CSVFileContents;
import com.usman.study.upload.FileUpload;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/files")
public class FileUploadController
{
     private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/display")
    public ModelAndView showEmployee()
    {
        LOG.info("file upload display ");
        ModelAndView model = new ModelAndView("file_upload", "fileUpload", new FileUpload());
        return model;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadCSVFile(@ModelAttribute("fileUpload") FileUpload fileUpload, BindingResult result, Model model)
    {
        LOG.info("file upload started... ");
        try
        {
            if( result.hasErrors()){
                System.out.println("file upload found error. ");
                return "file_upload_success";
            }
            if (fileUpload.getCsvfile().getSize() == 0)
            {
                System.out.println("file upload not seleected, please select a CSV file... ");
            }
            else
            {
                String fileName = "";
                System.out.println("file upload client: " + fileUpload.getClient());
                MultipartFile multipartFile = fileUpload.getCsvfile();
                if (multipartFile != null)
                {
                    fileName = multipartFile.getOriginalFilename();
                    //do whatever you want with uploaded file
                    File multiFile = multipartToFile(multipartFile);
                    //Saved file path: Absolute Path:C:\Farkalit\Tomcat-8.5.0\tomcat-main\bin\OutboundList_Import.csv
                    System.out.println("File Path : " + multiFile.getPath() + ", Absolute Path:" + multiFile.getAbsolutePath());
                    List<CSVFileContents> parseCSVData = parseCSVData(multiFile.getAbsolutePath());
                    System.out.println("File content size : "+parseCSVData.size());
                    for (CSVFileContents content : parseCSVData)
                    {
                        System.out.println(content.toString());
                    }  
                }
                model.addAttribute("fileName", fileName);
                System.out.println("file upload successfully.");
            }
        }
        catch (IllegalStateException | IOException e)
        {
            System.err.println("File uplaod error:" + e.getMessage());
        }
        return "file_upload_success";
    }

    @RequestMapping(value = "/csvDownload")
    public void downloadCSV(HttpServletResponse response) throws IOException
    {
        response.setContentType("text/csv");
        String reportName = "CSV_Download_File.csv";
        response.setHeader("Content-disposition", "attachment;filename=" + reportName);

        ArrayList<String> rows = new ArrayList<>();
        rows.add("Name,Result");
        rows.add("\n");
        for (int i = 0; i < 10; i++)
        {
            rows.add("Java Honk,Success");
            rows.add("\n");
        }
        Iterator<String> iter = rows.iterator();
        while (iter.hasNext())
        {
            String outputString = (String) iter.next();
            response.getOutputStream().print(outputString);
        }

        response.getOutputStream().flush();

    }

    @RequestMapping("/download")
    public void downloadCSVFile(HttpServletResponse response) throws IOException
    {
        LOG.info("file download started... ");
        response.setContentType("text/csv");
        String downloadFileName = "Text_Download_File.csv";
        response.setHeader("Content-disposition", "attachment;filename=" + downloadFileName);

        //set content header
        response.getOutputStream().print(getHeaderNames());
        //set the application data
        List<CSVFileContents> rows = getCSVData();
        Iterator<CSVFileContents> iter = rows.iterator();
        while (iter.hasNext())
        {
            CSVFileContents outputString = (CSVFileContents) iter.next();
            response.getOutputStream().print(readData(outputString));
        }
        response.getOutputStream().flush();
        System.out.println("file download successfully ");
    }

    private List<CSVFileContents> getCSVData()
    {
        CSVFileContents data1 = new CSVFileContents("EPC", "12fd12345", "transcript", "test details", "related work-item refrence");
        CSVFileContents data2 = new CSVFileContents("EPC", "12fd12345", "transcript", "test details", "related work-item refrence");
        CSVFileContents data3 = new CSVFileContents("EPC", "12fd12345", "transcript", "test details", "related work-item refrence");
        CSVFileContents data4 = new CSVFileContents("EPC", "12fd12345", "transcript", "test details", "related work-item refrence");
        CSVFileContents data5 = new CSVFileContents("EPC", "12fd12345", "transcript", "test details", "related work-item refrence");

        List<CSVFileContents> listData = Arrays.asList(data1, data2, data3, data4, data5);
        return listData;
    }

    private String readData(CSVFileContents csvData)
    {
        String STR_COMMA = ",";
        StringBuilder build = new StringBuilder(csvData.getClientName() + STR_COMMA);
        build.append(csvData.getAccountId()).append(STR_COMMA);
        build.append(csvData.getDetails()).append(STR_COMMA);
        build.append(csvData.getTranscript()).append(STR_COMMA);
        build.append(csvData.getReferenceId()).append(STR_COMMA);
        build.append("\n");
        return build.toString();
    }

    private String getHeaderNames()
    {
        return "Client Name, Account Id, Transcript, Details, Reference Id,\n";
    }

    private List<CSVFileContents> parseCSVData(String csvFileName) throws FileNotFoundException, IOException
    {
        List<CSVFileContents> contentList =  new ArrayList<>();
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";
        try
        {
            reader = new BufferedReader(new FileReader(csvFileName));
            while ((line = reader.readLine()) != null)
            {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                CSVFileContents content = new CSVFileContents(country[0], country[1], country[2], country[3], country[4]);
                contentList.add(content);
                //System.out.println("Adhoc Data [client= " + country[0] + ", accountID=" + country[1] + ", transcript=" + country[2] + "]");
            }

        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    System.err.println("File closing error:" + e.getMessage());
                }
            }
        }
        return contentList;
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        //Saved file path: Absolute Path:C:\Farkalit\Tomcat-8.5.0\tomcat-main\bin\OutboundList_Import.csv
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
