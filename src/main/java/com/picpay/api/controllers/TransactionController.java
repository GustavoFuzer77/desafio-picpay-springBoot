package com.picpay.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.api.domain.transactions.Transaction;
import com.picpay.api.services.infra.TransactionServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("transaction")
public class TransactionController {

  private final TransactionServices transactionServices;

  public TransactionController(TransactionServices transactionServices) {
    this.transactionServices = transactionServices;
  }

  @PostMapping
  public Transaction create(@RequestBody Transaction transaction) {
    return transactionServices.createTransaction(transaction);
  }

  @GetMapping
  public List<Transaction> getAllTransaction() {
    return transactionServices.list();
  }

}
