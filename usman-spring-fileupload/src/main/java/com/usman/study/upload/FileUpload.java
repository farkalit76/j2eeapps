/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 72010995
 */
public class FileUpload
{
   
    private String client;
    private MultipartFile csvfile;

    public String getClient()
    {
        return client;
    }

    public void setClient(String client)
    {
        this.client = client;
    }

    public MultipartFile getCsvfile()
    {
        return csvfile;
    }

    public void setCsvfile(MultipartFile file)
    {
        this.csvfile = file;
    }

    @Override
    public String toString()
    {
        return "FileUpload{" + "client=" + client + ", csvfile=" + csvfile + '}';
    }
    
}
