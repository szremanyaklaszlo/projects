package com.training.sportsbetting.service.user.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Currency;

@Service
public class PlayerModelBuilder {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private LocalDate birth;
    private Currency currency;
    private BigDecimal balance;

    public PlayerModelBuilder() {
        super();
    }

    public PlayerModelBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PlayerModelBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PlayerModelBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public PlayerModelBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PlayerModelBuilder setBirth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public PlayerModelBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public PlayerModelBuilder setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public PlayerModel build() {
        return new PlayerModel(firstName, lastName, username, email, birth, currency, balance);
    }

}
