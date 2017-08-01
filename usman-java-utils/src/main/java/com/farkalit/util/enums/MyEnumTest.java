/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.enums;

/**
 *
 * @author 72010995
 */
public class MyEnumTest
{

    public static void main(String[] args)
    {
        //otherTest();
      test2();
    }

     private static void test2()
    {
        Character chars;
        String wiChannel = "D";

        chars = wiChannel.charAt(0);
        for (Channel channel : Channel.values())
        {
            System.out.println("channel:" + channel + ", code[" + channel.getCharacter() + "]");
            for (ChannelWS obj : ChannelWS.values())
            {
                if ( (channel.getCharacter() == chars) && channel.name().equals(obj.name()))
                {
                    System.out.println(wiChannel+" matched for:"+obj);
                    System.out.println("{"+chars+"} is matched for:"+channel);
                    return;
                }
             }
        }

    }
     
    private static void test1()
    {
          Character chars;
        String wiChannel = "A";

        chars = wiChannel.charAt(0);

        for (Channel channel : Channel.values())
        {
            System.out.println("channel:" + channel + ", code[" + channel.getCharacter() + "]");
            if (channel.getCharacter() == chars)
            {
                System.out.println("{"+chars+"} is matched for:"+channel);
               // return;
            }
        }

    }
    private static void otherTest()
    {
        EnumVO vo = new EnumVO();
        vo.setEnums(MyEnum.A);
        System.out.println("EnumVO Prints:" + vo.toString());

        //-----------------------------------------------------------//
        MyEnum enums = vo.getEnums();
        EnumSecondVO sec = new EnumSecondVO();
        sec.setMessage("My Test of Enum");
        sec.setCopyEnum(enums);
        System.out.println("EnumSecondVO Prints:" + sec.toString());
    }
}
