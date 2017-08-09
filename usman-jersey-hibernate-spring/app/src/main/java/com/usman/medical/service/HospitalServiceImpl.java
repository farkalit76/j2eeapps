/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.HospitalDao;
import com.usman.medical.data.Hospital;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service
public class HospitalServiceImpl implements HospitalService
{

    @Autowired(required = true)
    private HospitalDao hospitalDao;

    @Override
    @Transactional
    public List<Hospital> getHospitals()
    {
        return hospitalDao.listHospital();
    }

}
