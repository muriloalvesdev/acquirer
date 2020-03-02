package br.com.acquirer.domain.utils;

import java.util.Arrays;

import br.com.acquirer.service.exception.AcquirerNameNotFoundException;

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
      throws AcquirerNameNotFoundException {
    return Arrays.asList(AcquirerName.values()).stream()
        .filter(acquirer -> acquirer.getAcquirerName().equals(acquirerName.toUpperCase()))
        .findFirst().orElseThrow(() -> new AcquirerNameNotFoundException(
            "Acquirer informed [ " + acquirerName + " ]" + "not found!"));
  }
}
