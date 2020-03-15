package br.com.acquirer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcquirerDataTransferObject {

  @JsonProperty("name")
  private String name;

  @JsonProperty("cnpj")
  private String cnpj;

  public AcquirerDataTransferObject(String name, String cnpj) {
    this.name = name;
    this.cnpj = cnpj;
  }

  public String getName() {
    return name;
  }

  public String getCnpj() {
    return cnpj;
  }

  @Override
  public String toString() {
    return "AcquirerDataTransferObject [name=" + name + ", cnpj=" + cnpj + "]";
  }

}
