/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */

package com.farkalit.util;

import java.util.Locale;

/**
 *
 * @author 72010995
 */
public class JavaLocaleTest
{
    public static void main(String[] args)
    {
        System.out.println("Format: "+ JavaLocaleTest.formatAsLocale("en_UK"));
    }
    
    protected static String formatAsLocale(String data)
    {
        if (data == null)
        {
            return "Unknown";
        }

        // split by underscore
        String[] parts = data.trim().split("_");
        StringBuilder localeStr = new StringBuilder();

        if (parts.length > 0)
        {
            // first part, language
            Locale langLocale = new Locale(parts[0]);
            localeStr.append(langLocale.getDisplayLanguage());
        }
        if (parts.length > 1)
        {
            // second part, Country
            Locale countryLocale = new Locale(parts[0], parts[1]);
            localeStr.append(", ").append(countryLocale.getDisplayCountry());
        }

        return localeStr.toString();
    }
    
//     public String formatData(String data, String dataType)
//    {
//        // if data is null, return empty string. If dataType is null, return unformatted
//        if (data == null)
//        {
//            return "";
//        }
//        String trimmedData = data.trim();
//        if (dataType == null)
//        {
//            return trimmedData;
//        }
//
//        // try to identify by known types
//        DataFormattingType dfType;
//        try
//        {
//            dfType = DataFormattingType.fromValue(dataType.trim());
//        }
//        catch (Exception ex)
//        {
//            // not a known type, so just return unformatted
//            return trimmedData;
//        }
//
//        // format the types we can handle
//        switch (dfType)
//        {
//            case PHONENUMBER:
//                return formatAsPhoneNumber(trimmedData);
//            case LOCALE:
//                return formatAsLocale(trimmedData);
//            default:
//                // return unformatted
//                return trimmedData;
//        }
//    }
}
