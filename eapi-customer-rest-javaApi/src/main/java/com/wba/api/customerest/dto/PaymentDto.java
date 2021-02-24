package com.wba.api.customerest.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 */
public class PaymentDto implements Serializable {

    private String cardType;
    private String creditCard;
    private Integer lastFourDigits;
    private Long expiryMonth;
    private Long expiryYear;
    private String zipCode;
    private Boolean isDefault;

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto that = (PaymentDto) o;
        return Objects.equals(getCardType(), that.getCardType()) && Objects.equals(getCreditCard(), that.getCreditCard()) && Objects.equals(getLastFourDigits(), that.getLastFourDigits()) && Objects.equals(getExpiryMonth(), that.getExpiryMonth()) && Objects.equals(getExpiryYear(), that.getExpiryYear()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(isDefault, that.isDefault);
    }

}
