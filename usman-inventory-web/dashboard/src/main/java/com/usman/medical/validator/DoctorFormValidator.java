/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.validator;

import com.usman.medical.data.Doctor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author fusman
 */
@Component
public class DoctorFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Doctor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        System.out.println("validator....");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required","Please enter your name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "degree", "degree.required","Please enter your degree");
        Doctor doctor = (Doctor) target;
        //validate something else
    }

}
