package br.com.acquirer.domain.model;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sale",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"number_summary_sale"})})
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @Column(name = "net_amount")
  private BigDecimal netAmount;

  @Column(name = "gross_amount")
  private BigDecimal grossAmount;

  @Column(name = "merchant_discount_rate")
  private Double merchantDiscountRate;

  @Column(name = "number_summary_sale")
  private Long numberSummarySale;

  @SuppressWarnings("unused")
  private Sale() {}

  public Sale(BigDecimal netAmount, BigDecimal grossAmount, Double merchantDiscountRate,
      Long numberSummarySale) {
    this.netAmount = netAmount;
    this.grossAmount = grossAmount;
    this.merchantDiscountRate = merchantDiscountRate;
    this.numberSummarySale = numberSummarySale;
  }

  public BigDecimal getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(BigDecimal netAmount) {
    this.netAmount = netAmount;
  }

  public BigDecimal getGrossAmount() {
    return grossAmount;
  }

  public void setGrossAmount(BigDecimal grossAmount) {
    this.grossAmount = grossAmount;
  }

  public Double getMerchantDiscountRate() {
    return merchantDiscountRate;
  }

  public void setMerchantDiscountRate(Double merchantDiscountRate) {
    this.merchantDiscountRate = merchantDiscountRate;
  }

  public Long getNumberSummarySale() {
    return numberSummarySale;
  }

  public void setNumberSummarySale(Long numberSummarySale) {
    this.numberSummarySale = numberSummarySale;
  }

  public UUID getUuid() {
    return uuid;
  }

  @Override
  public String toString() {
    return "Sale [uuid=" + uuid + ", netAmount=" + netAmount + ", grossAmount=" + grossAmount
        + ", merchantDiscountRate=" + merchantDiscountRate + ", numberSummarySale="
        + numberSummarySale + "]";
  }

}
