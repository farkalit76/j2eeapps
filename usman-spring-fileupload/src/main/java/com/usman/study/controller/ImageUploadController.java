/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.controller;

import com.usman.study.upload.ImageUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
 * @author fusman
 */
@Controller
@RequestMapping("/image")
public class ImageUploadController {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    // save uploaded file to this folder
    private static String UPLOADED_FOLDER = "F://temp//";

    @RequestMapping("/display")
    public ModelAndView showLoadPage()
    {
        LOG.info("Image upload page displaying");
        ModelAndView model = new ModelAndView("image_upload", "imageUpload", new ImageUpload());
        return model;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadImageFile(@ModelAttribute("imageUpload") ImageUpload imageUpload, BindingResult result, Model model)
    {
        LOG.info("file upload started... ");
        try
        {
            if (result.hasErrors())
            {
                System.out.println("Image upload found error. ");
                return "image_upload_success";
            }
            if (imageUpload.getImagefile().getSize() == 0)
            {
                System.out.println("Image to upload not selected, please select an Image (jpg, gif,png) file... ");
            } else
            {
                String fileName = "";
                System.out.println("Image upload client: " + imageUpload.getClient());
                MultipartFile multipartFile = imageUpload.getImagefile();
                if (multipartFile != null)
                {
                    fileName = multipartFile.getOriginalFilename();

                    if (fileName.endsWith(".jpg") || fileName.endsWith(".JPG")
                            || fileName.endsWith(".png") || fileName.endsWith(".PNG")
                            || fileName.endsWith(".gif") || fileName.endsWith(".GIF"))
                    {
                        //do whatever you want with uploaded file
                        //File multiFile = multipartToFile(multipartFile);
                        // Saved file: Absolute Path:C:\Farkalit\Tomcat-8.5.0\tomcat-main\bin\Usman-20151027.jpg
                        // System.out.println("File Path : " + multiFile.getPath() + ", Absolute Path:" + multiFile.getAbsolutePath());

                        System.out.println("File name:" + fileName);
                        byte[] bytes = multipartFile.getBytes();
                        Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
                        Files.write(path, bytes);
                        System.out.println("File saved successfully at:" + path.toAbsolutePath());

                    } else
                    {
                        System.out.println("Image file not selected, Please select an Image (jpg, gif,png) file... ");
                        return "image_upload";
                    }

                }
                model.addAttribute("fileName", fileName);
                System.out.println("file upload successfully.");
            }
        } catch (IllegalStateException | IOException e)
        {
            System.err.println("File uplaod error:" + e.getMessage());
        }
        return "image_upload_success";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadImage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        System.out.println("downloadImage type started... ");
        String successPage ="image_upload_success";
        try
        {
            int BUFFER_SIZE = 4096;
            //String filePath = "//WEB-INF//images//multichannel_overview.jpg";
            String filePath = "//WEB-INF//images//multichannel_overview.jpg";
            // get the absolute path of the application
            ServletContext context = request.getSession().getServletContext();
            //URL resource = context.getRealPath("");
//            String appPath = context.getContextPath();
//            // construct the complete absolute path of the file
//            String fullPath = appPath + filePath;
            
            URL resource = context.getResource("/");
            String fullPath =  resource.getPath()+filePath;
            File downloadFile = new File(fullPath);
            FileInputStream inputStream = new FileInputStream(downloadFile);

            // get MIME type of the file
            String mimeType = context.getMimeType(fullPath);

            if (mimeType == null)
            {
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
            // check the mime type
            System.out.println("MIME type: " + mimeType);
            // set content attributes for the response
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());

            // set headers for the response
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);

            // get output stream of the response
            OutputStream outStream = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;

            // write bytes read from the input stream into the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1)
            {
                outStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outStream.close();
        } catch (FileNotFoundException e)
        {
            System.err.println("File Not found error:" + e.getMessage());
        } catch (IOException e)
        {
            System.err.println("File uplaod error:" + e.getMessage());
        }

    }

//    @RequestMapping("/photo1")
//    public void photo(HttpServletResponse response) throws IOException
//    {
//        response.setContentType("image/jpeg");
//        InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg");
//        IOUtils.copy(in, response.getOutputStream());
//    }
    private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        //Saved file path: Absolute Path:C:\Farkalit\Tomcat-8.5.0\tomcat-main\bin\OutboundList_Import.csv
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
