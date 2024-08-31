package com.picpay.api.domain.wallet;

public enum WalletType {
  COMMON(1), SHOPKEEPER(2);

  private int value;

  private WalletType(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

}
