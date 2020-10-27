package br.com.acquirer.resources;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
}
