package com.wba.api.customerest.controller;

import com.wba.api.customerest.dto.PatientDto;
import com.wba.api.customerest.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 */

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerRestController.class);

    @PostMapping(value = "/v1/pharmacy/patient/findBy", produces = "application/json")
    public @ResponseBody  PatientDto getPatientById(@RequestParam String patientId) {

        LOGGER.info("Hitting '/v1/pharmacy/patient' api.....");
        return customerService.getPatientById(patientId);
    }
}
