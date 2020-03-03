package br.com.acquirer.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankResource {

  @JsonProperty("amount_sale")
  private String amountSale;

  @JsonProperty("card")
  private CardsDataTransferObject card;

  public String getAmountSale() {
    return amountSale;
  }

  public void setAmountSale(String amountSale) {
    this.amountSale = amountSale;
  }

  public CardsDataTransferObject getCard() {
    return card;
  }

  public void setCard(CardsDataTransferObject card) {
    this.card = card;
  }

  @Override
  public String toString() {
    return "BankResource [amountSale=" + amountSale + ", card=" + card + "]";
  }

}
