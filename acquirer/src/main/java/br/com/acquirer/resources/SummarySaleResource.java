package br.com.acquirer.resources;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SummarySaleResource {

  @JsonProperty("net_amount_sale")
  private BigDecimal netAmountSale;

  @JsonProperty("gross_amount_sale")
  private BigDecimal grossAmountSale;

  @JsonProperty("number_of_installments")
  private Integer numberOfInstallments;

  @JsonProperty("merchant_discount_rate")
  private Double merchantDiscountRate;

  @JsonProperty("number_summary_sale")
  private Long numberSummarySale;

  public SummarySaleResource(BigDecimal netAmountSale, BigDecimal grossAmountSale,
      Integer numberOfInstallments, Double merchantDiscountRate, Long numberSummarySale) {
    this.netAmountSale = netAmountSale;
    this.grossAmountSale = grossAmountSale;
    this.numberOfInstallments = numberOfInstallments;
    this.merchantDiscountRate = merchantDiscountRate;
    this.numberSummarySale = numberSummarySale;
  }

  public BigDecimal getNetAmountSale() {
    return netAmountSale;
  }

  public BigDecimal getGrossAmountSale() {
    return grossAmountSale;
  }

  public Integer getNumberOfInstallments() {
    return numberOfInstallments;
  }

  public Double getMerchantDiscountRate() {
    return merchantDiscountRate;
  }

  public Long getNumberSummarySale() {
    return numberSummarySale;
  }

  @Override
  public String toString() {
    return "SummarySaleDataTransferObject [netAmountSale=" + netAmountSale + ", grossAmountSale="
        + grossAmountSale + ", numberOfInstallments=" + numberOfInstallments
        + ", merchantDiscountRate=" + merchantDiscountRate + ", numberSummarySale="
        + numberSummarySale + "]";
  }

}
