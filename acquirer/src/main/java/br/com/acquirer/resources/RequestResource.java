package br.com.acquirer.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResource {

  @JsonProperty("holder")
  private HolderResource holder;

  @JsonProperty("merchant_code")
  private String merchantCode;

  @JsonProperty("info_transaction_resource")
  private InfoTransactionResource transaction;

  @JsonProperty("type_transaction")
  private String typeTransaction;

  @JsonProperty("count_installments")
  private String countInstallments;

  @JsonProperty("masked_credit_card_number")
  private String maskedCreditCardNumber;

  @JsonProperty("captured_at")
  private String capturedAt;

  @JsonProperty("payment_date")
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
