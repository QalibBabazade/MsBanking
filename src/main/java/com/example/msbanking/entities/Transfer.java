package com.example.msbanking.entities;

import com.example.msbanking.enums.CurrencyEnum;
import com.example.msbanking.enums.StatusEnum;
import com.example.msbanking.enums.EnumTransferType;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transfer")
@DynamicInsert
public class Transfer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Long creditorAccountId;
    private Long CreditorCardId;
    private Double creditorAmount;
    @Column(name = "creditor_currency")
    @Enumerated(EnumType.ORDINAL)
    private CurrencyEnum creditorCurrency;
    private Long debitorAccountId;
    private Long debitorCardId;
    private Double debitorAmount;
    @Column(name = "debitor_currency")
    @Enumerated(EnumType.ORDINAL)
    private CurrencyEnum debitorCurrency;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;
    @Column(name = "transfer_type")
    @Enumerated(EnumType.ORDINAL)
    private EnumTransferType transferType;
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

    public Long getCreditorAccountId() {
        return creditorAccountId;
    }

    public void setCreditorAccountId(Long creditorAccountId) {
        this.creditorAccountId = creditorAccountId;
    }

    public Long getCreditorCardId() {
        return CreditorCardId;
    }

    public void setCreditorCardId(Long creditorCardId) {
        CreditorCardId = creditorCardId;
    }

    public Double getCreditorAmount() {
        return creditorAmount;
    }

    public void setCreditorAmount(Double creditorAmount) {
        this.creditorAmount = creditorAmount;
    }

    public CurrencyEnum getCreditorCurrency() {
        return creditorCurrency;
    }

    public void setCreditorCurrency(CurrencyEnum creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
    }

    public Long getDebitorAccountId() {
        return debitorAccountId;
    }

    public void setDebitorAccountId(Long debitorAccountId) {
        this.debitorAccountId = debitorAccountId;
    }

    public Long getDebitorCardId() {
        return debitorCardId;
    }

    public void setDebitorCardId(Long debitorCardId) {
        this.debitorCardId = debitorCardId;
    }

    public Double getDebitorAmount() {
        return debitorAmount;
    }

    public void setDebitorAmount(Double debitorAmount) {
        this.debitorAmount = debitorAmount;
    }

    public CurrencyEnum getDebitorCurrency() {
        return debitorCurrency;
    }

    public void setDebitorCurrency(CurrencyEnum debitorCurrency) {
        this.debitorCurrency = debitorCurrency;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public EnumTransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(EnumTransferType transferType) {
        this.transferType = transferType;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
