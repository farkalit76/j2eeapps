/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.usman.study.controller;

import java.util.Date;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
public class AjaxTestController
{

    @RequestMapping("/ajax")
    public ModelAndView helloAjaxTest()
    {
        System.out.println("ajax display " );
        return new ModelAndView("ajax", "message", "Usman Spring MVC with Ajax and JQuery Demo..");
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody
    String getTime()
    {
    System.out.println("ajaxtest display " );
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from AjaxTestController.." + new Date().toString());
        return result;
    }

}
