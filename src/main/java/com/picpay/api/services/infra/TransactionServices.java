package com.picpay.api.services.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.api.domain.transactions.Transaction;
import com.picpay.api.domain.wallet.Wallet;
import com.picpay.api.domain.wallet.WalletType;
import com.picpay.api.exceptions.InvalidTransactionException;
import com.picpay.api.repositories.TransactionRepository;
import com.picpay.api.repositories.WalletRepository;
import com.picpay.api.services.auth.AuthorizeService;
import com.picpay.api.services.notify.NotificationService;

@Service
public class TransactionServices {

  private final TransactionRepository transactionRepository;
  private final WalletRepository walletRepository;
  private final AuthorizeService authorizeService;
  private final NotificationService notificationService;

  // creating a dependency injection and also to perform inversion of control. You
  // can change the transaction method in the future without changing the code
  // below.
  public TransactionServices(TransactionRepository transactionRepository, WalletRepository walletRepository,
      AuthorizeService authorizeService, NotificationService notificationService) {
    this.transactionRepository = transactionRepository;
    this.walletRepository = walletRepository;
    this.authorizeService = authorizeService;
    this.notificationService = notificationService;
  }

  private void validate(Transaction transaction) {
    walletRepository.findById(transaction.payee())
        .flatMap(payee -> getValidPayerWallet(transaction))
        .orElseThrow(() -> {
          throw new InvalidTransactionException(
              "Invalid transaction: payer and payee cannot be the same, insufficient balance, or incorrect wallet type %s"
                  .formatted(transaction));
        });
  }

  @Transactional
  public Transaction createTransaction(Transaction transaction) {
    // three points to validate:
    // first: the payer is not the payee
    // second: the payer must have sufficient balance
    // third: the payer MUST be a COMUM wallet type

    // 1 - validate
    validate(transaction);
    // 2- create the transaction
    var newTransaction = transactionRepository.save(transaction);
    // 3 - get the wallet and debit and credit
    var getWalletPayer = walletRepository.findById(transaction.payer()).get();
    var getWalletPayee = walletRepository.findById(transaction.payee()).get();
    walletRepository.save(getWalletPayer.debit(transaction.value()));
    walletRepository.save(getWalletPayee.credit(transaction.value()));

    // 4 - call external services
    // 1° authorize transaction (if possible)
    authorizeService.authorize(transaction);
    // 2° notify transactions
    notificationService.notify(transaction);

    return newTransaction;
  }

  private Optional<Wallet> getValidPayerWallet(Transaction transaction) {
    return walletRepository.findById(transaction.payer())
        .filter(payer -> payer.type() == WalletType.COMUM.getValue()
            && payer.balance().compareTo(transaction.value()) >= 0
            && !payer.id().equals(transaction.payee()));
  }

  public List<Transaction> list() {
    return transactionRepository.findAll();
  }
}
