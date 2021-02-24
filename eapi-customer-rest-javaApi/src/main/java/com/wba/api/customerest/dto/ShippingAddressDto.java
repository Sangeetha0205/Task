package com.wba.api.customerest.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 */
public class ShippingAddressDto implements Serializable {

   private String addressLine1;
   private String city;
   private String zipCode;
   private String state;

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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ShippingAddressDto that = (ShippingAddressDto) o;
      return Objects.equals(getAddressLine1(), that.getAddressLine1()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(getState(), that.getState());
   }
}
