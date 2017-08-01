/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.factory;

/**
 *
 * @author fusman
 */
public class Server extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public Server()
    {

    }

    public Server(String ram, String hdd, String cpu)
    {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM()
    {
        return "8 GB";
    }

    @Override
    public String getHDD()
    {
        return "4 TB";
    }

    @Override
    public String getCPU()
    {
        return "2.9 GHz";
    }

}
