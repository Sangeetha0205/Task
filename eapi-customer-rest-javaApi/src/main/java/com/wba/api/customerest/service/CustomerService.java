package com.wba.api.customerest.service;

import com.wba.api.customerest.dto.PatientDto;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 */

public interface CustomerService{

    PatientDto getPatientById(String patientId);

}
