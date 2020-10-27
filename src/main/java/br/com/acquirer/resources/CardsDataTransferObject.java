package br.com.acquirer.resources;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardsDataTransferObject {
  @JsonProperty("security_code")
  @NotNull
  private String securityCode;

  @JsonProperty("card_number")
  @NotNull
  private String cardNumber;

  @JsonProperty("validate")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private String validate;
}
