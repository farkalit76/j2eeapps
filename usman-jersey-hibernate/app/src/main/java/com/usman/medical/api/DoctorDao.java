/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.api;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface DoctorDao
{

    List<Doctor> listDoctor();

    List<Doctor> findDoctors(Doctor doctor);

    Doctor findDoctorById(long doctorId);
    
    AdminResponse createDoctor(Doctor doctor);

    AdminResponse updateDoctor(Doctor doctor);

    AdminResponse deleteDoctor(Doctor doctor);

}
