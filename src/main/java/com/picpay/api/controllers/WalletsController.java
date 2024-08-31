package com.picpay.api.controllers;

import java.util.List;

// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.api.domain.wallet.Wallet;
import com.picpay.api.services.infra.WalletServices;

@RestController
@RequestMapping("wallet")
public class WalletsController {

  private final WalletServices walletServices;

  public WalletsController(WalletServices walletServices) {
    this.walletServices = walletServices;
  }

  @PostMapping
  public Wallet create(@RequestBody Wallet wallet) {

    if (wallet.id() != null) {
      throw new IllegalArgumentException("ID should be null for new entities.");
    }

    return walletServices.create(wallet);
  }

  @GetMapping
  public List<Wallet> getAllTransaction() {
    return walletServices.list();
  }

}
