package br.com.acquirer.convert;

import br.com.acquirer.resources.InfoTransactionResource;
import br.com.acquirer.resources.RequestResource;
import br.com.acquirer.resources.SummarySaleResource;
import br.com.acquirer.resources.http.request.TransactionRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TransactionsUtil {

  public static final TransactionRequest createTransactionRequest(
      InfoTransactionResource transactionResource, RequestResource request) {
    SummarySaleResource summarySaleResource = transactionResource.getSummarySale();

    return new TransactionRequest(request.getMerchantCode(), request.getTypeTransaction(),
        request.getCountInstallments(), request.getMaskedCreditCardNumber(),
        request.getCapturedAt(), request.getPaymentDate(), summarySaleResource,
        request.getHolder().getName());
  }
}
