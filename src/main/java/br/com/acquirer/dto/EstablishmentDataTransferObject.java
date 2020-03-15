package br.com.acquirer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentDataTransferObject {

  @JsonProperty("name")
  private String name;

  @JsonProperty("merchant_code")
  private String merchantCode;

  @JsonProperty("acquirer_name")
  private String acquirerName;

  @JsonProperty("merchant_discount_rate")
  private String MDR;

  public EstablishmentDataTransferObject(String name, String merchantCode, String acquirerName,
      String MDR) {
    this.name = name;
    this.merchantCode = merchantCode;
    this.acquirerName = acquirerName;
    this.MDR = MDR;
  }

  public String getName() {
    return name;
  }

  public String getMerchantCode() {
    return merchantCode;
  }

  public String getAcquirerName() {
    return acquirerName;
  }

  public String getMDR() {
    return MDR;
  }

  @Override
  public String toString() {
    return "EstablishmentDataTransferObject [name=" + name + ", merchantCode=" + merchantCode
        + ", acquirerName=" + acquirerName + ", MDR=" + MDR + "]";
  }

}
