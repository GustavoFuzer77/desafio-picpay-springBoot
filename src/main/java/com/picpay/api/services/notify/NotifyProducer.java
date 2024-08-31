package com.picpay.api.services.notify;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.picpay.api.domain.transactions.Transaction;

@Service
public class NotifyProducer {
  private final KafkaTemplate<String, Transaction> kafkaTemplate;

  public NotifyProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendNotification(Transaction transaction) {
    kafkaTemplate.send("transaction-notification", transaction);
  }

}
