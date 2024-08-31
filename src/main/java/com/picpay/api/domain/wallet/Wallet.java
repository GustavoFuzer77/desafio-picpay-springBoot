package com.picpay.api.domain.wallet;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public record Wallet(
        @Id Long id,
        String fullname,
        Long document,
        String email,
        String password,
        WalletType type,
        BigDecimal balance) {

  public Wallet debit(BigDecimal value) {
    return new Wallet(id, fullname, document, email, password, type, balance.subtract(value));
  }

}
