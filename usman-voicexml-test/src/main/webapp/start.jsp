<?xml version="1.0" encoding="UTF-8"?>
<vxml xmlns="http://www.w3.org/2001/vxml" version="2.1" 
      xml:lang="en-US"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.w3.org/2001/vxml http://www.w3.org/TR/voicexml21/vxml.xsd">

    <% System.out.println("testing......");%>

    <form id="main">
        <field name="main_selection">
            <prompt bargein="true" bargeintype="speech" >
                <audio  src="audio/YouShouldReceiveYour.wav">
                    Welcome to Contoso Travel<break/>
                    Say new reservation<break size="small"/> or press 1<break/>
                    Say change reservation<break size="small"/> or press 2<break/>
                    Say restaurant recommendation<break size="small"/> or press 3
                </audio>
            </prompt>

            <grammar version="1.0" root="top" tag-format="semantics/1.0">
                <rule id="top">
                    <item><ruleref uri="#nonsense"/></item>
                    <one-of>
                        <item>new reservation
                            <tag>out="new reservation";</tag></item>

                        <item>change reservation
                            <tag>out="change reservation";</tag></item>

                        <item>restaurant recommendation
                            <tag>out="restaurant recommendation";</tag></item>
                    </one-of>
                    <item><ruleref uri="#nonsense"/></item>
                </rule>
                <rule id="nonsense">
                    <one-of>
                        <item><ruleref special="GARBAGE"/></item>
                        <item><ruleref special="NULL"/></item>
                    </one-of>
                </rule>
            </grammar>

            <grammar mode="dtmf" version="1.0" root="top">
                <rule id="top">
                    <one-of>
                        <item>1</item>
                        <item>2</item>
                        <item>3</item>
                    </one-of>
                </rule>
            </grammar>

            <help>
                <audio src="audio/YouShouldReceiveYour.wav">
                    You should say one of these three phrases exactly.
                    New reservation, change reservation, or
                    restaurant recommendation.
                </audio>
            </help>


            <catch event="noinput nomatch">
                <audio src="audio/YouShouldReceiveYour.wav">
                    Sorry. Didn't get that. Please try again.
                </audio>
                <reprompt/>
            </catch>

            <catch event="noinput nomatch" count="3">
                <audio src="audio/YouShouldReceiveYour.wav">
                    Sorry you're having trouble. Please call back later. Goodbye.
                </audio>
                <exit/>
            </catch>

            <filled>
                <var name="next_destination" expr="' '"/>
                <if cond="main_selection == 'new reservation' ||
                    main_selection == '1'">
                    <assign name="next_destination" expr="'#new_reservation'"/>

                    <else/>
                    <assign name ="next_destination" expr="recording.vxml"/>
                </if>
                <goto expr="next_destination"/>
            </filled>
        </field>
    </form>

    <form id="new_reservation">
        <block>
            <audio src="audio/YouShouldReceiveYour.wav" />
        </block>
    </form>
    
    <form id="confirmation">
        <block>
            <audio src="audio/YouShouldReceiveYour.wav" />
        </block>
    </form>

    <form id="exit">
        <block>
            <exit/>
        </block>
    </form>

</vxml>