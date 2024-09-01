package com.picpay.api.services.notify;

import java.util.Random;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.picpay.api.domain.transactions.Transaction;
import com.picpay.api.exceptions.NotificationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotifyConsumer {

  private static final Logger log = LoggerFactory.getLogger(NotifyConsumer.class);
  private final Random random;

  public NotifyConsumer() {
    this.random = new Random();
  }

  @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio")
  public void receiveNotification(Transaction transaction) {
    log.info("Notifying transaction {}...", transaction);

    int randomNumber = random.nextInt(5) + 1; 
    boolean notificationSuccess = randomNumber != 1; 
    
    if (!notificationSuccess) {
      throw new NotificationException("Error to send notification");
    }

    log.info("Notification has been sent successfully.");
  }
}
