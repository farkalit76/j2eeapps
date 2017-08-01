/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.history.test;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class HistoryClient
{
    public static void main(String[] args)
    {
        HistoryDao dao = new HistoryDao();
        runHistory(dao);
        //close session factory
        HistoryDao.closeSession();
    }
    
    public static void runHistory(HistoryDao dao)
    {
        ChangeHistory history = dao.getHistoryById(1);
        System.out.println("History:" + history.toString());

        List<ChangeHistory> history1 = dao.getHistory();
        System.out.println("history1:" + history1.size());
        Iterator<ChangeHistory> iterator = history1.iterator();
        while (iterator.hasNext())
        {
            System.out.println("...History:" + iterator.next().toString());
        }
    }
}
