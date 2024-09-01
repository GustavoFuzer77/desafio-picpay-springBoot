package com.picpay.api.services.notify;

import org.springframework.stereotype.Service;

import com.picpay.api.domain.transactions.Transaction;

@Service
public class NotificationService {

  private final NotifyProducer notifyProducer;

  public NotificationService(NotifyProducer notifyProducer) {
    this.notifyProducer = notifyProducer;
  }

  public void notify(Transaction transaction) {
    notifyProducer.sendNotification(transaction);
  }

}
