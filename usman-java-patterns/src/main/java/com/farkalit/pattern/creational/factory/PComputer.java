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
public class PComputer extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public PComputer()
    {
    }

    public PComputer(String ram, String hdd, String cpu)
    {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM()
    {
        return "2 GB";
    }

    @Override
    public String getHDD()
    {
        return "500 GB";
    }

    @Override
    public String getCPU()
    {
        return "2.5 G";
    }

}
