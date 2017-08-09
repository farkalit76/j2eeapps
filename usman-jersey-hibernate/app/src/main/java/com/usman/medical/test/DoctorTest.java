/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.test;

import com.usman.medical.dao.DoctorDaoImpl;
import com.usman.medical.data.Doctor;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class DoctorTest
{
    public static void main(String[] args)
    {
        //DoctorDao dao = new DoctorDao();
        //runDoctor(dao);
        //close session factory
        //DoctorDao.closeSession();
        
    }
    
     public static void runDoctor( DoctorDaoImpl dao){
       
        Doctor doctor = getDoctor();
        dao.createDoctor(doctor);
        System.out.println("Doctor is created for ID:"+ doctor.getModuleId());
        
        List<Doctor> doctors= dao.listDoctor();
        dao.findDoctorById(doctors.get(0).getModuleId());
         //dao.deleteDoctor(doctors.get(0));
        Iterator<Doctor> iterator = doctors.iterator();
        while(iterator.hasNext()){
           System.out.println("Doctor:"+ iterator.next().toString());
        }
    }
    
    
      private static Doctor getDoctor(){
       
        Doctor doc = new Doctor();
        doc.setModuleId(117);
        doc.setName("APJ Kalam");
        doc.setDegree("MBBS");
        doc.setProfession("General Physian");
        doc.setExperience(15d);
        doc.setAddress("Shaheen Bagh, JMI, Delhi");
        doc.setDateOfBirth(new Date(105, 10, 15));
        return doc;
    }
}
