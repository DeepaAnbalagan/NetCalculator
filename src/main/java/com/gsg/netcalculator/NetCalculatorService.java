package com.gsg.netcalculator;

public class NetCalculatorService {
    /* 1. Method 1:
    1. get the input from controller
    2. call the taxRate service and get the tax rate
    3. calculate the net and return
     */
    public static String calculateNetValue(Double grossAmount, String countryCode) {
        Double netAmount, vat;
        Boolean countrySupported = TaxRateProviderService.isCountrySupported(countryCode);
        if (countrySupported) {
            vat = TaxRateProviderService.vatBasedOnCountry(countryCode);
            netAmount = grossAmount - (grossAmount * vat);
            return netAmount.toString();
        } else {
            return "Country is not supported";
        }
    }
}
