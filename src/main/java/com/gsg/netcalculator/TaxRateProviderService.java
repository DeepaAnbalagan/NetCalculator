package com.gsg.netcalculator;

import java.util.HashMap;
import java.util.Map;

public class TaxRateProviderService {
  /* Method 1:
  * 1. have a map
  * 2. add the key values
  *
  * Method 2:
  * 1. Return the VAT based on the key
  *
  * Method 3:
  * 1. To Identify if we are supporting a particular country or not
  *
  * */
   static Map<String, Double> vatMap = new HashMap<>();
   // the below block can be created as a service which would update the DB
    static {
        vatMap.put("DE", 0.19); // Germany
        vatMap.put("FR", 0.20); // FRANCE
        vatMap.put("IN", 0.18); // INDIA
        vatMap.put("US", 0.0);  // USA
        vatMap.put("GB", 0.20); // Great Britain
        vatMap.put("TH", 0.07); // Thailand
        vatMap.put("CN", 0.13); // China
        vatMap.put("AU", 0.10); // Australia
        vatMap.put("CA", 0.05);
        vatMap.put("NZ", 0.13);
        vatMap.put("HK", 0.0);
        vatMap.put("JP", 0.10);
        vatMap.put("SG", 0.20);
        vatMap.put("ID", 0.11);
        vatMap.put("MY", 0.165);
        vatMap.put("VN", 0.10);
        vatMap.put("IT", 0.22);
        vatMap.put("PK", 0.17);
        vatMap.put("AE", 0.05);
        vatMap.put("TR", 0.18);

    }
    /* returns vat value for the given country
    * Note: this can be rewritten as a service once we move to a DB */
    public static Double vatBasedOnCountry(String countryCode){
            return vatMap.get(countryCode);
    }
    /* returns the response if we support a particular country or not */
    public static Boolean isCountrySupported(String countryCode){
        if(vatMap.containsKey(countryCode)){
            return true;
        }
        return false;
    }

}
