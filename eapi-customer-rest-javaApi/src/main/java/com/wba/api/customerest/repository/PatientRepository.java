package com.wba.api.customerest.repository;

import com.wba.api.customerest.model.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/15/2021
 */

@Repository
public interface PatientRepository extends MongoRepository<PatientModel, String>{

    public PatientModel findByPatientId(String patientId);
}
