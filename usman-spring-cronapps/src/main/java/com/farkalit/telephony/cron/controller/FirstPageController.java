/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.telephony.cron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/first")
public class FirstPageController
{

    @RequestMapping("/start")
    public ModelAndView showEmployee()
    {
        System.out.println("start display ");
        ModelAndView model = new ModelAndView("start-page");
        return model;

    }
    
}
