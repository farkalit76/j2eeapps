/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.DoctorDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service
public class DoctorServiceImpl implements DoctorService
{

    @Autowired(required = true)
    private DoctorDao doctorDao;

    @Override
    @Transactional
    public List<Doctor> listDoctor()
    {
        return doctorDao.listDoctor();
    }

    @Override
    @Transactional
    public List<Doctor> findDoctors(Doctor doctor)
    {
        return doctorDao.findDoctors(doctor);
    }

    @Override
    @Transactional
    public Doctor findDoctorById(long doctorId)
    {
        return doctorDao.findDoctorById(doctorId);
    }

    @Override
    @Transactional
    public AdminResponse createDoctor(Doctor doctor)
    {
        return doctorDao.createDoctor(doctor);
    }

    @Override
    @Transactional
    public AdminResponse updateDoctor(Doctor doctor)
    {
        return doctorDao.updateDoctor(doctor);
    }

    @Override
    @Transactional
    public AdminResponse deleteDoctor(Doctor doctor)
    {
        return doctorDao.deleteDoctor(doctor);
    }

}
