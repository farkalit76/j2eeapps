/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.DoctorDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 72010995
 */
@Repository
public class DoctorDaoImpl implements DoctorDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Doctor> listDoctor()
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Doctor.class, "doctor");
        crit.addOrder(Order.desc("createdDate"));
        List<Doctor> doctors = (List<Doctor>) crit.list();
        return doctors;
    }

    @Override
    public List<Doctor> findDoctors(Doctor doctor)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doctor findDoctorById(long doctorId)
    {
        Doctor doctor = (Doctor) sessionFactory.getCurrentSession().get(Doctor.class, doctorId);
        System.out.println(doctor.toString());

        return doctor;
    }

    @Override
    public AdminResponse createDoctor(Doctor doctor)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(doctor);
        System.out.println("doctor created...");
        AdminResponse response = new AdminResponse(true, 101, "Doctor created.");

        return response;
    }

    @Override
    public AdminResponse updateDoctor(Doctor doctor)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(doctor);
        System.out.println("doctor updated...");
        AdminResponse response = new AdminResponse(true, 102, "doctor updated.");

        return response;
    }

    @Override
    public AdminResponse deleteDoctor(Doctor doctor)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(doctor);
        System.out.println("doctor deleted...");
        AdminResponse response = new AdminResponse(true, 103, "Doctor deleted.");

        return response;
    }

}
