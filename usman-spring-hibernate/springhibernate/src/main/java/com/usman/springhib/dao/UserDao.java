/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.dao;

import com.usman.springhib.model.User;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface UserDao
{
    public List<User> list();
}
