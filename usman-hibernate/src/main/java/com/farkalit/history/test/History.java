/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.history.test;

import java.util.List;

/**
 *
 * @author 72010995
 */
public interface History
{
    ChangeHistory getHistoryById(int id);
    List<ChangeHistory> getHistory();
}
