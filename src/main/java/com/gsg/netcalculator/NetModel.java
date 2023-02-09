package com.gsg.netcalculator;
/*
Model class to tell the request format
*/
public class NetModel {

    Double grossAmount;
    String countryCode;
    public NetModel(Double grossAmount, String countryCode) {
        this.grossAmount = grossAmount;
        this.countryCode = countryCode;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
