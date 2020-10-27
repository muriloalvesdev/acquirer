package br.com.acquirer.domain.utils;

import java.security.InvalidParameterException;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AcquirerName {
  CIELO("CIELO"), REDE("REDE");

  private String acquirerName;

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
