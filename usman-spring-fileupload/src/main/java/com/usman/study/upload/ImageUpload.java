/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fusman
 */
public class ImageUpload {

    private String client;
    private MultipartFile imagefile;

    public String getClient()
    {
        return client;
    }

    public void setClient(String client)
    {
        this.client = client;
    }

    public MultipartFile getImagefile()
    {
        return imagefile;
    }

    public void setImagefile(MultipartFile imagefile)
    {
        this.imagefile = imagefile;
    }

    @Override
    public String toString()
    {
        return "FileUpload{" + "client=" + client + ", imagefile=" + imagefile + '}';
    }
}
