<?xml version="1.0" encoding="UTF-8"?>
<vxml xmlns="http://www.w3.org/2001/vxml" version="2.1"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.w3.org/2001/vxml http://www.w3.org/TR/voicexml21/vxml.xsd">

    <%  
    String ans = request.getParameter("ans");
    boolean isAnsweringMachine = ("tt".equals(ans));
    %>
    <form id="td">

        <% if (isAnsweringMachine) { %>

        <block>
            <audio src="audio/Global_Option0.wav"/>
        </block>

        <% } else { %>
        <field name="rating">
            <prompt timeout="10s">
                <block>
                    <audio src="audio/Greeting_Option1.wav"/>
                </block>
            </prompt>
            <dtmf>
                1 | 2 | 3 | 4 | 5
            </dtmf>
            <filled>
                <submit next="recordrating.jsp" namelist="rating"/>
            </filled>
        </field>

        <% } %>
    </form>
</vxml>