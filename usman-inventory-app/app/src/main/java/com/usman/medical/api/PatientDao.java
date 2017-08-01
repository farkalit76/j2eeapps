/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.api;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Patient;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface PatientDao
{

    List<Patient> listPatient();

    List<Patient> findPatient(Patient patient);
    
    Patient findPatientById(long patientId);

    AdminResponse createPatient(Patient patient);

    AdminResponse updatePatient(Patient patient);

    AdminResponse deletePatient(Patient patient);

}
