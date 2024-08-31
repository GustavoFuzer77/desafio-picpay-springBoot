package com.picpay.api.services.infra;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.api.domain.wallet.Wallet;
import com.picpay.api.repositories.WalletRepository;

@Service
public class WalletServices {

  private final WalletRepository walletRepository;

  public WalletServices(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Transactional
  public Wallet create(Wallet wallet) {
    var newWallet = walletRepository.save(wallet);
    return newWallet;
  }

  public List<Wallet> list() {
    return walletRepository.findAll();
  }
}
