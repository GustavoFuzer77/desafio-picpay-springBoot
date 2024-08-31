package com.picpay.api.repositories;

import org.springframework.data.repository.ListCrudRepository;
import com.picpay.api.domain.transactions.Transaction;

public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {}
