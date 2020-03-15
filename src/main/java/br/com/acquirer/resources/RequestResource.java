package br.com.acquirer.resources;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResource {

  @JsonProperty("holder")
  @NotNull(message = "holder is required")
  private HolderResource holder;

  @JsonProperty("merchant_code")
  @NotNull(message = "merchant_code is required")
  private String merchantCode;

  @JsonProperty("info_transaction_resource")
  @NotNull(message = "info_transaction_resource is required")
  private InfoTransactionResource transaction;

  @JsonProperty("type_transaction")
  @NotNull(message = "type_transaction is required")
  private String typeTransaction;

  @JsonProperty("count_installments")
  @NotNull(message = "coint_installments is required")
  private String countInstallments;

  @JsonProperty("masked_credit_card_number")
  @NotNull(message = "masked_credit_card_number is required")
  private String maskedCreditCardNumber;

  @JsonProperty("captured_at")
  @NotNull(message = "captured_at is required")
  private String capturedAt;

  @JsonProperty("payment_date")
  @NotNull(message = "payment_date is required")
  private String paymentDate;

  public HolderResource getHolder() {
    return holder;
  }

  public String getCountInstallments() {
    return countInstallments;
  }

  public void setCountInstallments(String countInstallments) {
    this.countInstallments = countInstallments;
  }

  public String getTypeTransaction() {
    return typeTransaction;
  }

  public void setTypeTransaction(String typeTransaction) {
    this.typeTransaction = typeTransaction;
  }

  public void setHolder(HolderResource holder) {
    this.holder = holder;
  }

  public String getMerchantCode() {
    return merchantCode;
  }

  public void setMerchantCode(String merchantCode) {
    this.merchantCode = merchantCode;
  }

  public InfoTransactionResource getTransaction() {
    return transaction;
  }

  public void setTransaction(InfoTransactionResource transaction) {
    this.transaction = transaction;
  }

  public String getMaskedCreditCardNumber() {
    return maskedCreditCardNumber;
  }

  public void setMaskedCreditCardNumber(String maskedCreditCardNumber) {
    this.maskedCreditCardNumber = maskedCreditCardNumber;
  }

  public String getCapturedAt() {
    return capturedAt;
  }

  public void setCapturedAt(String capturedAt) {
    this.capturedAt = capturedAt;
  }

  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  @Override
  public String toString() {
    return "RequestResource [holder=" + holder + ", merchantCode=" + merchantCode + ", transaction="
        + transaction + ", typeTransaction=" + typeTransaction + ", countInstallments="
        + countInstallments + ", maskedCreditCardNumber=" + maskedCreditCardNumber + ", capturedAt="
        + capturedAt + ", paymentDate=" + paymentDate + "]";
  }

}
