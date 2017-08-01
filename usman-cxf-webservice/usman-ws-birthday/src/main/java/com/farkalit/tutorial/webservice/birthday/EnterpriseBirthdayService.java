/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.birthday;

import com.farkalit.tutorial.webservice.birthday.api.Birthday;
import com.farkalit.tutorial.webservice.birthday.api.IBirthdayService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author fusman
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@WebService(portName = "BirthdayPort", name = "BirthdayEndpoint", serviceName = "BirthdayService", targetNamespace = "http://tutorial.farkalit.com/ws/birthday")
public class EnterpriseBirthdayService implements IBirthdayService {

    private static final String BIRTHDAY_LIST = "birthdayList";
    private static Map<String, Date> birthdayMap = new HashMap<>();
    private HttpSession session = null;

    /*
     * Handling Session in Web Service. Do the following four steps.
     */
    @Resource   //step-1
    private WebServiceContext webContext;//step-2

    @WebMethod
    @Override
    public String setBirthday(@WebParam(name = "name") String name, @WebParam(name = "date") Date birthdate)
    {
        if( isAuthentic() )
        {
            System.out.println("Hello World JAX-WS - Valid User!");
        }else
        {
            System.err.println("Invalid User!!!");
        }
        //Get birthday session
        if (session == null)
        {
            session = getBirthdaySession();
        }
        List<Birthday> birthdayList = getBirthdayListFromSession(session);
        String success = "Birthdate for name:" + name + " is saved.";
        System.out.println(success);
        birthdayMap.put(name, birthdate);
        birthdayList.add(new Birthday(name, birthdate));
        //Set the birthday list into session
        session.setAttribute(BIRTHDAY_LIST, birthdayList);
        return success;
    }

    @WebMethod
    @Override
    public Date getBirthdate(@WebParam(name = "name") String name)
    {
        if (birthdayMap != null)
        {
            for (Map.Entry<String, Date> entrySet : birthdayMap.entrySet())
            {
                String key = entrySet.getKey();
                Date value = entrySet.getValue();
                if (key != null && key.equalsIgnoreCase(name))
                {
                    System.out.println("Your birhtdate is value:" + value);
                    return value;
                }
                System.out.println("Birthdate NOT found!!!!!");
            }
        }
        return null;
    }

    @WebMethod
    @Override
    public Birthday getBirthdayInfo(@WebParam(name = "name") String name)
    {

        List<Birthday> birthdayList = getBirthdayListFromSession(session);
        if (birthdayList != null)
        {
            for (Birthday birthday : birthdayList)
            {
                if (birthday.getMyName().equalsIgnoreCase(name))
                {
                    System.out.println(birthday.toString());
                    return birthday;
                }
            }
        }
        //set the null data and return it
        return new Birthday("NULL", new Date());
    }

    /**
     *
     * @return @throws WebServiceException
     */
    private HttpSession getBirthdaySession() throws WebServiceException
    {
        MessageContext messageContext = webContext.getMessageContext();//step-3
        session = ((javax.servlet.http.HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST)).getSession();

        if (session == null)
        {
            System.out.println("No HTTP Session found");
            throw new WebServiceException("No HTTP Session found");
        } else
        {
            if (session.isNew())
            {
                System.out.println("HTTP Session is new .....");
            }
        }
        return session;
    }

    /**
     *
     * @param session
     * @return
     */
    private List<Birthday> getBirthdayListFromSession(HttpSession session)
    {
        List<Birthday> birthdayList = null;
        //Get the birthday list from session
        birthdayList = (List<Birthday>) session.getAttribute(BIRTHDAY_LIST);  // Step 4
        if (birthdayList == null)
        {
            System.out.println("birthday list is NULL in the session.");
            birthdayList = new ArrayList<Birthday>();
        } else
        {
            //display all the birthday information
            for (Birthday birthday : birthdayList)
            {
                System.out.println(birthday.toString());
            }
        }
        System.out.println("birthdayList size in the session is:" + birthdayList.size());
        return birthdayList;
    }

    public boolean isAuthentic()
    {
        MessageContext msgCtx = webContext.getMessageContext();//step-3
        //get detail from request headers
        Map http_headers = (Map) msgCtx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";

        if (userList != null)
        {
            //get username
            username = userList.get(0).toString();
        }

        if (passList != null)
        {
            //get password
            password = passList.get(0).toString();
        }

        //Should validate username and password with database
        if (username.equals("usman") && password.equals("password"))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
