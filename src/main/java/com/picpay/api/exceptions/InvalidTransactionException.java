package com.picpay.api.exceptions;

public class InvalidTransactionException extends RuntimeException {

  public InvalidTransactionException(String message){
    super(message);
  }

}
