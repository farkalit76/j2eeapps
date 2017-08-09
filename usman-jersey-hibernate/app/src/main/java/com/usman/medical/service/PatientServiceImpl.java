/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.PatientDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Patient;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service
public class PatientServiceImpl implements PatientService
{

    @Autowired(required = true)
    private PatientDao patientDao;
    
    @Override
    @Transactional
    public List<Patient> listPatient()
    {
        return patientDao.listPatient();
    }

    @Override
    @Transactional
    public List<Patient> findPatient(Patient patient)
    {
        return patientDao.findPatient(patient);
    }

    @Override
    @Transactional
    public Patient findPatientById(long patientId)
    {
        return patientDao.findPatientById(patientId);
    }

    @Override
    @Transactional
    public AdminResponse createPatient(Patient patient)
    {
        return patientDao.createPatient(patient);
    }

    @Override
    @Transactional
    public AdminResponse updatePatient(Patient patient)
    {
        return patientDao.updatePatient(patient);
    }

    @Override
    @Transactional
    public AdminResponse deletePatient(Patient patient)
    {
        return patientDao.deletePatient(patient);
    }
    
}
