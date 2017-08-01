/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.birthday.api;

import java.util.Date;

/**
 *
 * @author fusman
 */
public interface IBirthdayService {
    
    String setBirthday(String name, Date birthdate);
    
    Date getBirthdate(String name);
    
    Birthday getBirthdayInfo(String name);
}
