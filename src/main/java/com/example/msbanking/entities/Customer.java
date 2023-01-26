package com.example.msbanking.entities;

import com.example.msbanking.enums.EnumCustomerType;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@DynamicInsert
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(length = 20)
    private String fatherName;
    private Integer age;
    @Column(length = 100)
    private String address;
    @Column(length = 7,unique = true)
    private String fin;
    @Column(length = 7)
    private String voen;
    @Column(name="customer_type", columnDefinition = "Integer default '0'")
    @Enumerated(EnumType.ORDINAL)
    private EnumCustomerType customerType;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY , mappedBy = "customer")
    private List<Account> account;
    @ColumnDefault(value = "1")
    private Integer active;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public EnumCustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(EnumCustomerType customerType) {
        this.customerType = customerType;
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


    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date dataDate) {
        this.createDate = dataDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
