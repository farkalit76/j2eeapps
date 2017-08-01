/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.telephony.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author fusman
 */
@Component
public class EmailScheduledTasks 
{
    
    private static final Logger LOG = LoggerFactory.getLogger(EmailScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public void checkMail() 
    {
        LOG.info("First:The time is now {}", dateFormat.format(new Date()));
        for (int i = 0; i < 100; i++)
        {
            double sqr = Math.sqrt(i);
            double abs = Math.abs(sqr);
            double exp = Math.exp(sqr);
            System.out.println("Number {"+i+" }: SQR:"+ sqr +", ABS:"+abs+",EXP:"+exp);
        }
        
        LOG.info("Last:The time is now {}", dateFormat.format(new Date()));
    }
}
