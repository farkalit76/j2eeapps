<?xml version="1.0"?>
<vxml xmlns="http://www.w3.org/2001/vxml" version="2.1"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.w3.org/2001/vxml http://www.w3.org/TR/voicexml21/vxml.xsd">

    <%
        String ans = request.getParameter("ans");
        //String ans = "t";
        boolean isAnsweringMachine = ("t".equals(ans));
    %>
    <% System.out.println("-----start call ans :" + ans);%>
      <% System.out.println("-----start call bool :" + isAnsweringMachine);%>
    <form id="td">

        <% if (isAnsweringMachine) { %>

        <block>
            <audio src="audio/StartCall_ThisCallMayBe.wav"/>
        </block>

        <% } else { %>
        <field name="rating">
            <prompt timeout="10s">
                <block>
                    <audio src="audio/SubmitFormRequest_YouShouldReceiveYour.wav"/>
                </block>
            </prompt>
            <dtmf>
                1 | 2 | 3 | 4 | 5
            </dtmf>
            <filled>
                <submit next="recordrating.jsp" namelist="rating"/>
            </filled>
        </field>

        <% }%>
    </form>
</vxml>