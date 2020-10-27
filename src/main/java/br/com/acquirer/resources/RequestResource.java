package br.com.acquirer.resources;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
}
