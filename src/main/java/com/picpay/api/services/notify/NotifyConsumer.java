package com.picpay.api.services.notify;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.picpay.api.domain.notification.Notificantion;
import com.picpay.api.exceptions.NotificationException;

@Service
public class NotifyConsumer {

  private RestClient restClient;

  public NotifyConsumer(RestClient.Builder restClient) {
    this.restClient = restClient
        .baseUrl("https://util.devi.tools/api/v1/notify")
        .build();
  }

  @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio")
  public void receiveNotification(Transaction transaction) {

    ResponseEntity<Notificantion> response = restClient.get().retrieve().toEntity(Notificantion.class);

    if (response.getStatusCode().isError() || response.getBody() == null || !response.getBody().message()) {
      throw new NotificationException("Error to send notification");
    }

  }

}
