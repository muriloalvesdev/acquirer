package br.com.acquirer.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoTransactionResource {

  @JsonProperty("summary_sale")
  private SummarySaleResource summarySale;

  public SummarySaleResource getSummarySale() {
    return summarySale;
  }

  public void setSummarySale(SummarySaleResource summarySale) {
    this.summarySale = summarySale;
  }

}
