package com.example.msbanking.dto.responses;

import com.example.msbanking.enums.EnumCustomerType;

import java.io.Serializable;
import java.util.List;

public class CustomerResponse implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private Integer age;
    private String address;
    private String fin;
    private String voen;
    private EnumCustomerType customerType;
    private List<AccountResponse> accountResponse;

 /*   public CustomerResponse() {
    }
*/
 /*   public CustomerResponse(Customer entity) {

        this.id = entity.getId();
        this.name = entity.getName();
        this.surname = entity.getSurname();
        this.fatherName = entity.getFatherName();
        this.age = entity.getAge();
        this.address = entity.getAddress();
        this.fin = entity.getFin();
        this.voen = entity.getVoen();
        this.customerType = entity.getCustomerType();
        this.account = entity.getAccount();
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getVoen() {
        return voen;
    }

    public void setVoen(String voen) {
        this.voen = voen;
    }

    public EnumCustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(EnumCustomerType customerType) {
        this.customerType = customerType;
    }

    public List<AccountResponse> getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(List<AccountResponse> accountResponse) {
        this.accountResponse = accountResponse;
    }
}
