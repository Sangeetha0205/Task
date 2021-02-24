package com.wba.api.customerest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/15/2021
 */

@Document(collection = "tbf01_patient")
public class PatientModel {

    @Id
    @JsonIgnore
    private String id;

    private String patientId;
    private String firstName;
    private String middleInit;
    private String lastName;
    private String surnameSuffix;
    private String gender;
    private String email;
    private String dob;
    private String phoneNumberAreaCode;
    private String phoneNumber;
    private int    preferredStoreNumber;
    private String lastFilledStoreNumber;
    private String preferredPaymentMethod;
    private String previousFilledLastMile;
    private String addressLine1;
    private String city;
    private String zipCode;
    private String state;
    private String cardType;
    private String creditCard;
    private Integer lastFourDigits;
    private Long    expiryMonth;
    private Long    expiryYear;
    private String isDefault;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInit() {
        return middleInit;
    }

    public void setMiddleInit(String middleInit) {
        this.middleInit = middleInit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurnameSuffix() {
        return surnameSuffix;
    }

    public void setSurnameSuffix(String surnameSuffix) {
        this.surnameSuffix = surnameSuffix;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumberAreaCode() {
        return phoneNumberAreaCode;
    }

    public void setPhoneNumberAreaCode(String phoneNumberAreaCode) {
        this.phoneNumberAreaCode = phoneNumberAreaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPreferredStoreNumber() {
        return preferredStoreNumber;
    }

    public void setPreferredStoreNumber(int preferredStoreNumber) {
        this.preferredStoreNumber = preferredStoreNumber;
    }

    public String getLastFilledStoreNumber() {
        return lastFilledStoreNumber;
    }

    public void setLastFilledStoreNumber(String lastFilledStoreNumber) {
        this.lastFilledStoreNumber = lastFilledStoreNumber;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public String getPreviousFilledLastMile() {
        return previousFilledLastMile;
    }

    public void setPreviousFilledLastMile(String previousFilledLastMile) {
        this.previousFilledLastMile = previousFilledLastMile;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Integer getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(Integer lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public Long getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Long expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Long getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Long expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
