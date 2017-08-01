/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.DoctorDao;
import com.usman.medical.api.ICompany;
import com.usman.medical.data.Company;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fusman
 */
@Service
public class CompanyService implements ICompanyService{

    @Autowired(required = true)
    private ICompany intfCompany;

    @Override
    @Transactional
    public List<Company> listCompany()
    {
        return intfCompany.listCompany();
    }
    
}
