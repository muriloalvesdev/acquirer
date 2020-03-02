package br.com.acquirer.resources.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acquirer.resources.SummarySaleResource;

public class TransactionRequest {

  @JsonProperty("merchant_code")
  private String merchantCode;

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

  @JsonProperty("summary_sale")
  private SummarySaleResource summarySale;

  @JsonProperty("holder_name")
  private String holder;

  public TransactionRequest(String merchantCode, String typeTransaction, String countInstallments,
      String maskedCreditCardNumber, String capturedAt, String paymentDate,
      SummarySaleResource summarySale, String holder) {
    this.merchantCode = merchantCode;
    this.typeTransaction = typeTransaction;
    this.countInstallments = countInstallments;
    this.maskedCreditCardNumber = maskedCreditCardNumber;
    this.capturedAt = capturedAt;
    this.paymentDate = paymentDate;
    this.summarySale = summarySale;
    this.holder = holder;
  }



  @Override
  public String toString() {
    return "TransactionRequest [merchantCode=" + merchantCode + ", typeTransaction="
        + typeTransaction + ", countInstallments=" + countInstallments + ", maskedCreditCardNumber="
        + maskedCreditCardNumber + ", capturedAt=" + capturedAt + ", paymentDate=" + paymentDate
        + ", summarySale=" + summarySale + "]";
  }

}
