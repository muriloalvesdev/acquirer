package br.com.acquirer.resources;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InfoTransactionResource {
  @JsonProperty("summary_sale")
  @NotNull
  private SummarySaleResource summarySale;
}
