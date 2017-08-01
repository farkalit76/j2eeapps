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
public enum CommercialClass {

    COMMERCIAL("C", "Commercial"),
    STATE_OF_CALIFORNIA("CA", "State of California"),
    COMMERCIAL_FIXED_CHARGES("CF", "Commercial Fixed Charges"),
    COMMERCIAL_OWNER("CO", "Commercial - Owner"),
    COMMERCIAL_RENTER("CT", "Commercial - Renter"),
    KEY_ACCOUNT_GOVERMENT("GK", "Key Account - Goverment"),
    REFUSE_ONLY_COMMERCIAL("RC", "Refuse Only - Commercial"),
    CITY_OF_REDDING("RD", "City of Redding"),
    SEWER_ONLY_COMMERCIAL("SC","Sewer Only Commercial"),
    SHASTA_COUNTY("SH","Shasta County"),
    USA_FEDERAL("US", "USA Federal"),
    STORM_DRAIN_ONLY_COMMERCIAL("XC","Storm Drain Only - Commercial");

    private String code;
    
    private String description;

    private CommercialClass(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}

