package com.picpay.api.repositories;

import org.springframework.data.repository.CrudRepository;
import com.picpay.api.domain.wallet.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long> {}
