<?xml version="1.0" encoding="UTF-8"?>
<vxml xmlns="http://www.w3.org/2001/vxml" version="2.1"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.w3.org/2001/vxml http://www.w3.org/TR/voicexml21/vxml.xsd">

    <%
        String key = request.getParameter("rating");
        int ratetotal = 1;
        Integer RateTotal = (Integer) application.getAttribute("rate" + key);
        if (RateTotal != null) {
            ratetotal = RateTotal.intValue() + 1;
        }
        application.setAttribute("rate" + key, new Integer(ratetotal));
    %>
    <% System.out.println("----- key :" + key);%>
    <% System.out.println("-----RateTotal :" + RateTotal);%>
    <form id="td">
        <block>
            <audio src="audio/SubmitFormRequest_ThankYou.wav"/>
        </block>
    </form>
</vxml>