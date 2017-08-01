/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.validator;

import com.usman.medical.data.Customer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author fusman
 */
@Component
public class CustomerFormValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String ID_PATTERN = "[0-9]+";
    private static final String STRING_PATTERN = "[a-zA-Z]+";
    private static final String MOBILE_PATTERN = "[0-9]{10}";
    private static final String DECIMAL_PATTERN = "\\d+(\\.\\d{1,2})?";

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        System.out.println("customer validator....");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Please enter your name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "degree", "degree.required", "Please enter your email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "degree.address", "Please enter your address");
        Customer customer = (Customer) target;
        //validate something else
        // email validation in spring  
        if (!(customer.getDegree() != null && customer.getDegree().isEmpty()))
        {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(customer.getDegree());
            if (!matcher.matches())
            {
                errors.rejectValue("degree", "degree.incorrect", "Enter a correct email");
            }
        }
//        if ( customer.getExperience()!= null )
//        {
//            //String.valueOf(customer.getExperience())
//            pattern = Pattern.compile(DECIMAL_PATTERN);
//            matcher = pattern.matcher(""+customer.getExperience());
//            if (!matcher.matches())
//            {
//                //errors.rejectValue("experience", "degree.experience", "Enter correct experience");
//            }
//        }
    }
}
