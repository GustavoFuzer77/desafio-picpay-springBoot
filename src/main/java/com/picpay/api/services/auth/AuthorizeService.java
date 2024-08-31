package com.picpay.api.services.auth;

import java.util.Random;

import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestClient;

import com.picpay.api.domain.transactions.Transaction;
import com.picpay.api.exceptions.UnauthorizedTransactionException;

@Service
public class AuthorizeService {
  private final Random random;

  public AuthorizeService() {
    this.random = new Random();
  }

  public void authorize(Transaction transaction) {

    int randomNumber = random.nextInt(5) + 1;
    String fakeResponse;

    if (randomNumber == 1) {
      fakeResponse = "{\"message\": \"autorizado\"}";
    } else {
      fakeResponse = "{\"message\": \"não autorizado\"}";
    }

    boolean response = Authorization.isAuthorized(fakeResponse);
    // boolean response = new Authorization().isAuthorized(fakeResponse);

    if (!response) {
      throw new UnauthorizedTransactionException("Error: Unauthorized transaction");
    }

  }
}
