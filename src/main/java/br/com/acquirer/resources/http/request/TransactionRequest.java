package br.com.acquirer.resources.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acquirer.resources.SummarySaleResource;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

}
