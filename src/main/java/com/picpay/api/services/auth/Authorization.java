package com.picpay.api.services.auth;

public record Authorization() {

  public static boolean isAuthorized(String message) {
    return message.equals("autorizado");
  }

}