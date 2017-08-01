/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.test;

import com.usman.medical.dao.PatientDaoImpl;
import com.usman.medical.data.Patient;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class PatientTest
{

    public static void main(String[] args)
    {
        //PatientDao dao = new PatientDao();
        //runPatient(dao);
        //searchPatient(dao);
        //close session factory
        //PatientDao.closeSession();

    }

    public static void searchPatient(PatientDaoImpl dao)
    {

        Patient patient = new Patient();
        patient.setAddress("Masjid");     
        List<Patient> patients =  dao.findPatient(patient);   
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext())
        {
            System.out.println("Results:" + iterator.next().toString());
        }
    }
    
    public static void runPatient(PatientDaoImpl dao)
    {

        Patient patient = getPatient();
        dao.createPatient(patient);
        System.out.println("Doctor is created for ID:" + patient.getModuleId());

        List<Patient> patients = dao.listPatient();
        dao.findPatientById(patients.get(0).getModuleId());
        //dao.deletePatient(patients.get(0));
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext())
        {
            System.out.println("patients:" + iterator.next().toString());
        }
    }

    private static Patient getPatient()
    {

        Patient doc = new Patient();
        doc.setModuleId(117);
        doc.setName("APJ Kalam");
        doc.setAge(23);
        doc.setAddress("Shaheen Bagh, JMI, Delhi");
        doc.setPhone("2234325235");
        doc.setEmail("far@gmail.com");
        return doc;
    }

}
