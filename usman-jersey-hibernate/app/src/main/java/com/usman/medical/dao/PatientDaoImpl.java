/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.PatientDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Patient;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 72010995
 */
@Repository
public class PatientDaoImpl implements PatientDao
{

    //Create a single session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Patient> listPatient()
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Patient.class, "patient");
        crit.addOrder(Order.desc("createdDate"));
        List<Patient> patients = (List<Patient>) crit.list();
        return patients;
    }

    @Override
    public List<Patient> findPatient(Patient patient)
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Patient.class, "patient");
        if (patient != null)
        {
            if (patient.getModuleId() != 0)
            {
                crit.add(Restrictions.idEq(patient.getModuleId()));
            }
            if (patient.getName() != null && !patient.getName().equals(""))
            {
                crit.add(Restrictions.like("name", patient.getName()));
            }
            if (patient.getAddress() != null && !patient.getAddress().equals(""))
            {
                crit.add(Restrictions.like("address", "%" + patient.getAddress() + "%"));
            }

            if (patient.getPhone() != null && !patient.getPhone().equals(""))
            {
                crit.add(Restrictions.like("phone", patient.getPhone()));
            }
        }

        List<Patient> patients = (List<Patient>) crit.list();
        return patients;
    }

    @Override
    public Patient findPatientById(long patientId)
    {
        Session session = sessionFactory.getCurrentSession();

        Patient patient = (Patient) session.get(Patient.class, patientId);
        System.out.println(patient.toString());
        return patient;
    }

    @Override
    public AdminResponse createPatient(Patient patient)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(patient);
        System.out.println("patient created...");
        AdminResponse response = new AdminResponse(true, 101, "patient created.");

        return response;
    }

    @Override
    public AdminResponse updatePatient(Patient patient)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(patient);
        System.out.println("patient updated...");
        AdminResponse response = new AdminResponse(true, 102, "patient updated.");

        return response;
    }

    @Override
    public AdminResponse deletePatient(Patient patient)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(patient);
        System.out.println("patient deleted...");
        AdminResponse response = new AdminResponse(true, 103, "patient deleted.");

        return response;
    }

}
