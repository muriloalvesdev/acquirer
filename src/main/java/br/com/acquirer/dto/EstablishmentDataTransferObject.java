package br.com.acquirer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstablishmentDataTransferObject {

  @JsonProperty("name")
  private String name;

  @JsonProperty("merchant_code")
  private String merchantCode;

}
