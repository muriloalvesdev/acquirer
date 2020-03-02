package br.com.acquirer.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acquirer.resources.BankResource;

public class HolderResource {

  @JsonProperty("name")
  private String name;

  @JsonProperty("bank")
  private BankResource bank;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankResource getBank() {
    return bank;
  }

  public void setBank(BankResource bank) {
    this.bank = bank;
  }

  @Override
  public String toString() {
    return "HolderResource [name=" + name + ", bank=" + bank + "]";
  }

}
