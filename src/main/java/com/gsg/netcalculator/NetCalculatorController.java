package com.gsg.netcalculator;

import org.springframework.web.bind.annotation.*;


@RestController
public class NetCalculatorController {
    /* API to generate the net amount from the gross for a given country */
    @GetMapping("/get/netvalue")
    @ResponseBody
    public String getNetAmount(@RequestBody NetModel product) {
        return NetCalculatorService.calculateNetValue(product.getGrossAmount(), product.getCountryCode());
    }
}
