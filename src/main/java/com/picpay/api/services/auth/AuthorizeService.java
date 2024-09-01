package com.picpay.api.services.auth;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestClient;

import com.picpay.api.domain.transactions.Transaction;
import com.picpay.api.exceptions.UnauthorizedTransactionException;

@Service
public class AuthorizeService {

  private static final Logger log = LoggerFactory.getLogger(AuthorizeService.class);
  private final Random random;

  public AuthorizeService() {
    this.random = new Random();
  }

  public void authorize(Transaction transaction) {

    log.info("authorizing transaction {}...");

    int randomNumber = random.nextInt(5) + 1;
    String fakeResponse;

    if (randomNumber == 1) {
      fakeResponse = "{\"message\": \"não autorizado\"}";
    } else {
      fakeResponse = "{\"message\": \"autorizado\"}";
    }

    boolean response = Authorization.isAuthorized(fakeResponse);
    // boolean response = new Authorization().isAuthorized(fakeResponse);

    if (!response) {
      throw new UnauthorizedTransactionException("Error: Unauthorized transaction");
    }

    log.info("transaction authorized!");

  }
}
