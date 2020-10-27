package br.com.acquirer.resources;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HolderResource {
  @JsonProperty("name")
  @NotNull
  private String name;

  @JsonProperty("bank")
  @NotNull
  private BankResource bank;
}
