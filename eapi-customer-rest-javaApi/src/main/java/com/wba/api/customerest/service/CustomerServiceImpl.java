package com.wba.api.customerest.service;

import com.mongodb.MongoException;
import com.wba.api.customerest.constant.EapiErrorEnum;
import com.wba.api.customerest.dto.PatientDto;
import com.wba.api.customerest.dto.PaymentDto;
import com.wba.api.customerest.dto.ShippingAddressDto;
import com.wba.api.customerest.model.PatientModel;
import com.wba.api.customerest.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 */

@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    PatientRepository patientRepository;

    /**
     * Method for finding patient records by ID
     */
    public PatientDto getPatientById(String patientId) {

        try {

            LOGGER.info("MongoDb connection was successfull ...");

            PatientModel patientModel = patientRepository.findByPatientId(patientId);

            if (patientModel == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, EapiErrorEnum.ERRROR404.getMessage());
            return generateResponseDto(patientModel);

        } catch (MongoException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, EapiErrorEnum.ERRROR503.getMessage());
        } catch (ResponseStatusException responseStatusException) {
            throw responseStatusException;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, EapiErrorEnum.ERRROR500.getMessage());
        }
    }

    /**
     * This method is responsible for mapping MongoDb model to response Dto
     */
    public PatientDto generateResponseDto(Object result) {

        LOGGER.info("Building response data for getPatientById API....");

        ModelMapper modelMapper = new ModelMapper(); // building patient model using model mapper helper class
        PatientDto patientDto = modelMapper.map(result, PatientDto.class);
        PaymentDto paymentDto = modelMapper.map(result, PaymentDto.class);

        ShippingAddressDto shippingAddressDto = modelMapper.map(result, ShippingAddressDto.class);
        patientDto.setCustomerShippingAddress(shippingAddressDto);
        patientDto.getProfilePaymentDetails().add(paymentDto);

        LOGGER.info("API body for getPatientById api was successfully build....delegating response to controller...");
        return patientDto;

    }

}
