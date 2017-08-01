<?xml version="1.0" encoding="UTF-8"?>
<vxml xmlns="http://www.w3.org/2001/vxml" version="2.1"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.w3.org/2001/vxml http://www.w3.org/TR/voicexml21/vxml.xsd">

    <%
        String ans = request.getParameter("ans");
        boolean isAnsweringMachine = ("t".equals(ans));
         String contx = request.getContextPath();
         System.out.print("contx:"+contx);
    %>

    <form id="main">
        <block>
            <% if (isAnsweringMachine) { %>
            <audio src="audio/Global_Option0.wav"/>
            <% }
            else
            { %>
            <audio src="audio/Greeting_Option1.wav"/>
            <% }%>
            
<!--            <submit method="post" namelist="ani callId dnis sessionId station uui" next="jsp/common/startCall" />-->
            <submit method="post" namelist="ani callId dnis sessionId station uui" next="jsp/startCall" />
        </block>
    </form>
</vxml>