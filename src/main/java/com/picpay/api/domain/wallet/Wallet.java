package com.picpay.api.domain.wallet;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("wallets")
public record Wallet(
    @Id Long id,
    String full_name,
    Long document,
    String email,
    String password,
    int type,
    BigDecimal balance) {

  public Wallet debit(BigDecimal value) {
    return new Wallet(id, full_name, document, email, password, type, balance.subtract(value));
  }

  public Wallet credit(BigDecimal value) {
    return new Wallet(id, full_name, document, email, password, type, balance.add(value));
  }

}
