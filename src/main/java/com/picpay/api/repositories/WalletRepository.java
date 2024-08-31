package com.picpay.api.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.picpay.api.domain.wallet.Wallet;

public interface WalletRepository extends ListCrudRepository<Wallet, Long> {
}
