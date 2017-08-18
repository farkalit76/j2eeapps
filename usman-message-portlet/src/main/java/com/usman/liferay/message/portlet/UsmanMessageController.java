package com.usman.liferay.message.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.usman.liferay.message.model.Message;

/**
 * Portlet implementation class UsmanMessageController
 */
@Controller
@RequestMapping(value = "VIEW")
public class UsmanMessageController {

	private static final String MESSAGE_ENTRIES = "messages";
	ArrayList<Message> messages = new ArrayList<Message>();

	// @RenderMapping
	// Default page
	@RequestMapping
	public String viewMessagePage(Model model, RenderRequest request, RenderResponse response, PortletSession session) {

		System.out.println("########## Calling viewMessagePage################");

		//ModelAndView model = new ModelAndView("view");
		PortletPreferences prefs = request.getPreferences();
		String[] messageEntries = prefs.getValues(MESSAGE_ENTRIES, new String[1]);

		if (messageEntries != null) {

			List<Message> entries = parseEntries(messageEntries);
			
			model.addAttribute("entries", entries);
			//request.setAttribute("entries", entries);
		}
		boolean flag= model.containsAttribute(MESSAGE_ENTRIES);
		System.out.println("flag:"+flag);
		//ArrayList<Message> attribute = (ArrayList<Message>)session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE);
		if (session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE) != null) {
			
			model.addAttribute(MESSAGE_ENTRIES, session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE));
			session.removeAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE);
			System.out.println("date from session message entires:............");
			request.setAttribute(MESSAGE_ENTRIES, session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE));
		}

		// super.render(request, response);

		//return model;
		return "view";
		
	}

	@RequestMapping(params = "render=open-message")
	public String openMessagePage(Model model,RenderRequest request, RenderResponse response, PortletSession session) {

		System.out.println("############Calling openMessagePage###########");

		if (session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE) != null) {
			model.addAttribute(MESSAGE_ENTRIES, session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE));
			session.removeAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE);
			System.out.println("Session contains Message data.....");
		}
		
		return "editpage";
	}

	// Action must not return any value. It will return to default method
	// directly.
	@RequestMapping(params = "action=create-message")
	public void createMessage(Model model, ActionRequest request, ActionResponse response, PortletSession session) {

		System.out.println("############Calling createMessage############");

		try {

			PortletPreferences prefs = (PortletPreferences) request.getPreferences();

			String[] messageEntries = prefs.getValues(MESSAGE_ENTRIES, new String[1]);

			ArrayList<String> entries = new ArrayList<String>();
			

			if (messageEntries != null) {

				entries = new ArrayList<String>(Arrays.asList(prefs.getValues(MESSAGE_ENTRIES, new String[1])));

			}

//			String userName = ParamUtil.getString(request, "name");
//			String message = ParamUtil.getString(request, "message");
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			String userName = uploadRequest.getParameter("name");
			String message = uploadRequest.getParameter("message");
			
			System.out.println("Feteched name:"+userName+"::message:"+message);
			String entry = userName + "^" + message;

			
			entries.add(entry);
			
			//messages.add(new Message(userName, message));
			
			model.addAttribute(MESSAGE_ENTRIES, messages);
			if (session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE) != null) {
				messages = (ArrayList<Message>) session.getAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE);
				model.addAttribute(MESSAGE_ENTRIES, messages.add(new Message(userName, message)) );
				//session.removeAttribute(MESSAGE_ENTRIES, PortletSession.PORTLET_SCOPE);
				System.out.println("Session contains Message data.....");
			}
			
			session.setAttribute(MESSAGE_ENTRIES, messages.add(new Message(userName, message)), PortletSession.PORTLET_SCOPE);

			String[] array = entries.toArray(new String[entries.size()]);

			prefs.setValues(MESSAGE_ENTRIES, array);

			try {

				prefs.store();

			} catch (IOException ex) {

				System.err.println("IOE:" + ex.getMessage());

			} catch (ValidatorException ex) {

				System.err.println("ValidatorE:" + ex.getMessage());

			}
			System.out.println("addEntry finished....");

		} catch (ReadOnlyException ex) {

			System.err.println("ROE" + ex.getMessage());

		}

		// return "view";
	}

	@RequestMapping(params = "render=cancel-message")
	public String cancelMessagePage(Model model, RenderResponse response) {
		System.out.println("#########Calling cancelMessagePage#############");
		model.addAttribute("message", new Message());
		return "view";
	}

	private List<Message> parseEntries(String[] messageEntries) {

		ArrayList<Message> entries = new ArrayList<Message>();

		for (String entry : messageEntries) {
			String[] parts = entry.split("\\^", 2);
			//System.out.println("name:"+parts[0] +", message:"+parts[1]);
			Message gbEntry = new Message(parts[0], parts[1]);
			entries.add(gbEntry);
		}

		return entries;
	}

}
