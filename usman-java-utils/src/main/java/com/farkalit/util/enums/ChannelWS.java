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
public enum ChannelWS
{
    ADHOC_WORK,
    CHAT,
    CIS,
    EMAIL,
    FACEBOOK,
    FAX,
    LINKED_IN,
    MOBILE_APP,
    MOBILE_WEB,
    PAPER_MAIL,
    PHONE,
    SMS,
    TWITTER,
    WEB_MAIL,
    WEB_SITE,
    YOU_TUBE;

    public String value() {
        return name();
    }

    public static ChannelWS fromValue(String v) {
        return valueOf(v);
    }

}
