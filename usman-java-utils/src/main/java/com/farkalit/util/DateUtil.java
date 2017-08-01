/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */

package com.farkalit.util;

import java.util.Date;

/**
 *
 * @author 72010995
 */
public class DateUtil {
    
    public static void main(String[] args) {
        
        convertDate("06/17/2015 12:00 AM");//MM/dd/YYYY HH:MM am
        convertDate("06/27/2015");//MM/dd/YYYY
    }
    
    public static Date convertDate(String strDate){
        
        System.out.println("Date Formated:"+ new Date(strDate));
        return null;
    }
}
