package com.picpay.api.services.auth;

public record Authorization() {

  public static boolean isAuthorized(String jsonResponse) {
    String trimmedResponse = jsonResponse.trim();
    String message = "";

    if (trimmedResponse.startsWith("{") && trimmedResponse.endsWith("}")) {
      trimmedResponse = trimmedResponse.substring(1, trimmedResponse.length() - 1);
      String[] keyValuePair = trimmedResponse.split(":");

      if (keyValuePair.length == 2) {
        String key = keyValuePair[0].trim().replace("\"", "");
        String value = keyValuePair[1].trim().replace("\"", "");

        if ("message".equals(key)) {
          message = value;
        }
      }
    }

    return "autorizado".equals(message);
  }

}