package com.example.msbanking.enums;

public enum EnumCustomerType {
   FIZIKI(0), HUQUQI(1);

   private Integer value;

  private EnumCustomerType(Integer value) {
      this.value = value;
   }

   public Integer getValue() {
       return value;
   }
}
