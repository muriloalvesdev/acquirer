package br.com.acquirer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentDataTransferObject {

  @JsonProperty("name")
  private String name;

  @JsonProperty("merchant_code")
  private String merchantCode;

  public EstablishmentDataTransferObject(String name, String merchantCode) {
    this.name = name;
    this.merchantCode = merchantCode;
  }

  public String getName() {
    return name;
  }

  public String getMerchantCode() {
    return merchantCode;
  }

  @Override
  public String toString() {
    return "EstablishmentDataTransferObject [name=" + name + ", merchantCode=" + merchantCode + "]";
  }

}
