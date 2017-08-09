/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class CommonUtils
{

    public static List<KeyValues> getDepartments()
    {
        List<KeyValues> depts = new ArrayList<KeyValues>();

        for (Departments dept : Departments.values())
        {
            depts.add(new KeyValues(dept.getKey(), dept.getValue()));
        }
        return depts;

    }

    public static List<KeyValues> getFeeTypes()
    {
        List<KeyValues> fees = new ArrayList<KeyValues>();

        for (FeeTypes fee : FeeTypes.values())
        {
            fees.add(new KeyValues(fee.getKey(), fee.getValue()));
        }
        return fees;

    }

    public static List<KeyValues> getSexTypes()
    {
        List<KeyValues> sexs = new ArrayList<KeyValues>();

        for (SexData sex : SexData.values())
        {
            sexs.add(new KeyValues(String.valueOf(sex.getKey()), sex.getValue()));
        }
        return sexs;

    }
}
