package com.usman.liferay.spring.portlet;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Portlet implementation class SpringPortlet
 */

@Controller("spring")
@RequestMapping(value = "VIEW")
public class SpringPortletController {

	// private Log log =
	// LogFactoryUtil.getLog(HelloWorldController.class.getName());

	@RenderMapping
	public String viewHomePage(RenderRequest request, RenderResponse response) {

		System.out.println("#####################Calling viewHomePage##################################");

		return "view";

	}
}
