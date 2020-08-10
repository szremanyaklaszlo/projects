package com.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.training.sportsbetting.converter.LocalDateAttributeConverter;

@Entity
@Table(name = "player")
public class Player extends User {

    private String name;
    @ColumnDefault(value = "0")
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate birth;

    public Player(String email, String password, String name, BigDecimal balance, Currency currency, LocalDate birth) {
        super();
        super.setEmail(email);
        super.setPassword(password);
        this.name = name;
        this.balance = balance;
        this.currency = currency;
        this.birth = birth;
    }

    public Player() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

}
