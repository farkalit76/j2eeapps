/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.attach;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService(serviceName = "SkiImageService", targetNamespace = "http://chapter3.webreading.farkalit.com/attach")
@HandlerChain(file = "attach-handler-chain.xml") // for message tracking
public class SkiImageService {

    // Returns one image given the image's name.
    @WebMethod
    public Image getImage(String name)
    {
        return createImage(name);
    }
    // Returns a list of all available images.

    @WebMethod
    public List<Image> getImages()
    {
        return createImageList();
    }

    public SkiImageService()
    {
        photos = new HashMap<String, String>();
        photos.put("nordic", "nordic.jpg");
        photos.put("alpine", "alpine.jpg");
        photos.put("telemk", "telemk.jpg");
        default_key = "nordic";
    }
    // Create a named image from the raw bytes.

    private Image createImage(String name)
    {
        byte[] bytes = getRawBytes(name);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Iterator iterators = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader iterator = (ImageReader) iterators.next();
        try
        {
            ImageInputStream iis = ImageIO.createImageInputStream(in);
            iterator.setInput(iis, true);
            return iterator.read(0);
        } catch (IOException e)
        {
            System.err.println(e);
            return null;
        }
    }
    // Create a list of all available images.

    private List<Image> createImageList()
    {
        List<Image> list = new ArrayList<Image>();
        Set<String> key_set = photos.keySet();
        for (String key : key_set)
        {
            Image image = createImage(key);
            if (image != null)
            {
                list.add(image);
            }
        }
        return list;
    }
    // Read the bytes from the file for one image.

    private byte[] getRawBytes(String name)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try
        {
            String cwd = System.getProperty("user.dir");
            String sep = System.getProperty("file.separator");
            String base_name = cwd + sep + "jpegs" + sep;
            String file_name = base_name + name + ".jpg";
            System.out.println("file_name:"+file_name);
            FileInputStream in = new FileInputStream(file_name);
            // Send default image if there's none with this name.
            if (in == null)
            {
                in = new FileInputStream(base_name + "nordic.jpg");
            }
            byte[] buffer = new byte[2048];
            int n = 0;
            while ((n = in.read(buffer)) != -1)
            {
                out.write(buffer, 0, n); // append  to ByteArrayOutputStream
                in.close();
            }
        } catch (IOException e)
        {
            System.err.println(e);
        }
        return out.toByteArray();
    }
    private static final String[] names =
    {
        "nordic.jpg", "tele.jpg", "alpine.jpg"
    };
    private Map<String, String> photos;
    private String default_key;
}
