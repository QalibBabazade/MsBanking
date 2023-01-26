package com.example.msbanking.dto.requests;

import com.example.msbanking.entities.Account;
import com.example.msbanking.enums.EnumCustomerType;

import java.io.Serializable;
import java.util.List;

public class CustomerRequest implements Serializable {

    private String name;
    private String surname;
    private String fatherName;
    private Integer age;
    private String address;
    private String fin;
    private String voen;
    private EnumCustomerType customerType;
    private List<Account> account;

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

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
