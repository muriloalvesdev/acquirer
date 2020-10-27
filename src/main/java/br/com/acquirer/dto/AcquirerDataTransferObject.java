package br.com.acquirer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AcquirerDataTransferObject {
  @JsonProperty("name")
  private String name;

  @JsonProperty("cnpj")
  private String cnpj;
}
