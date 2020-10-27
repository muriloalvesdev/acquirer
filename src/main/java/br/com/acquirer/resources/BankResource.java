package br.com.acquirer.resources;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankResource {
  @JsonProperty("amount_sale")
  @NotNull
  private String amountSale;

  @JsonProperty("card")
  @NotNull
  private CardsDataTransferObject card;
}
