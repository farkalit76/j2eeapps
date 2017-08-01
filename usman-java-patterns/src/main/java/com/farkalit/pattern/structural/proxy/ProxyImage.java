/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

/**
 *
 * @author 72010995
 */
public class ProxyImage implements Image
{

    private String fileName;
    private RealImage realImage;
    
    public ProxyImage(String fileName)
    {
        this.fileName=fileName;
    }
     
    @Override
    public void display()
    {
        if(realImage == null){
         realImage = new RealImage(fileName);
      }
      realImage.display();
    }
    
}
