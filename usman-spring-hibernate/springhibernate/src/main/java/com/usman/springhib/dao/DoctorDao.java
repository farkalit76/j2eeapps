/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.dao;


import com.usman.springhib.api.IDoctor;
import com.usman.springhib.model.Doctor;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 72010995
 */
public class DoctorDao implements IDoctor
{

    private SessionFactory sessionFactory;

    public DoctorDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Doctor> listDoctor()
    {
        //List<Doctor> doctors = new ArrayList<>();
        Session session = null;
            //session = factory.openSession();
            session = sessionFactory.getCurrentSession();
//            Query query = session.createQuery("from Doctor");
//            doctors = query.list();
         List<Doctor>   doctors = (List<Doctor>) session.createCriteria(Doctor.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return doctors;
    }

//    @Override
//    public List<Doctor> findDoctors(Doctor doctor)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//     @Override
//      @Transactional
//    public Doctor findDoctorById(long doctorId)
//    {
//        Doctor doctor = new Doctor();
//        Session session = null;
//        try
//        {
//            //session = factory.openSession();
//            session = sessionFactory.getCurrentSession();
//            Transaction tranx = session.beginTransaction();
//            doctor = (Doctor) session.get(Doctor.class, doctorId);
//            System.out.println(doctor.toString());
//            tranx.commit();
//
//        }
//        catch (HibernateException e)
//        {
//            System.err.println("Error:" + e.getMessage());
//        }
//        finally
//        {
//            if (session != null)
//            {
//                session.close();
//            }
//        }
//        return doctor;
//    }
//
//    @Override
//     @Transactional
//    public AdminResponse createDoctor(Doctor doctor)
//    {
//        AdminResponse response = null;
//        Session session = null;
//        try
//        {
//            //session = factory.openSession();
//            session = sessionFactory.getCurrentSession();
//            //Open transaction
//            Transaction trans = session.beginTransaction();
//            session.persist(doctor);
//            trans.commit();//close transaction
//            System.out.println("doctor created...");
//            response = new AdminResponse(true, 101, "Doctor created.");
//        }
//        catch (HibernateException e)
//        {
//            System.err.println("Error:" + e.getMessage());
//            response = new AdminResponse(false, 401, "Doctor not created.");
//        }
//        finally
//        {
//            if (session != null)
//            {
//                session.close();
//            }
//        }
//        return response;
//    }
//
//    @Override
//     @Transactional
//    public AdminResponse updateDoctor(Doctor doctor)
//    {
//        AdminResponse response = null;
//        Session session = null;
//        try
//        {
//            //session = factory.openSession();
//            session = sessionFactory.getCurrentSession();
//            //Open transaction
//            Transaction trans = session.beginTransaction();
//            session.update(doctor);
//            trans.commit();//close transaction
//            System.out.println("doctor updated...");
//            response = new AdminResponse(true, 102, "doctor updated.");
//
//        }
//        catch (HibernateException e)
//        {
//            System.err.println("Update doctor Error:" + e.getMessage());
//            response = new AdminResponse(false, 401, "doctor not updated.");
//        }
//        finally
//        {
//            if (session != null)
//            {
//                session.close();
//            }
//        }
//        return response;
//    }
//
//    @Override
//     @Transactional
//    public AdminResponse deleteDoctor(Doctor doctor)
//    {
//        AdminResponse response = null;
//        Session session = null;
//        try
//        {
//            //session = factory.openSession();
//            session = sessionFactory.getCurrentSession();
//            //Open transaction
//            Transaction trans = session.beginTransaction();
//            session.delete(doctor);
//            trans.commit();//close transaction
//            System.out.println("doctor deleted...");
//            response = new AdminResponse(true, 103, "Doctor deleted.");
//        }
//        catch (HibernateException e)
//        {
//            System.err.println("Delete doctor Error:" + e.getMessage());
//            response = new AdminResponse(false, 401, "Doctor not deleted.");
//        }
//        finally
//        {
//            if (session != null)
//            {
//                session.close();
//            }
//        }
//        return response;
//    }

//    public static void closeSession()
//    {
//        HibSessionManager.shutdown();
//    }
}
