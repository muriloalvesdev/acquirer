package br.com.acquirer.domain.utils;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum AcquirerName {
  CIELO("CIELO"), REDE("REDE");

  private String acquirerName;

  private AcquirerName(String acquirerName) {
    this.acquirerName = acquirerName;
  }

  private String getAcquirerName() {
    return acquirerName;
  }

  public static AcquirerName getAndValidateAcquirerName(String acquirerName)
      throws InvalidParameterException {
    return Arrays.asList(AcquirerName.values()).stream()
        .filter(acquirer -> acquirer.getAcquirerName().equals(acquirerName.toUpperCase()))
        .findFirst().orElseThrow(() -> new InvalidParameterException(
            "Acquirer informed [ " + acquirerName + " ]" + "not found!"));
  }
}
