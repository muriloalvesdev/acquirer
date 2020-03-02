package br.com.acquirer.convert;

import br.com.acquirer.domain.model.Sale;
import br.com.acquirer.resources.SummarySaleResource;

public final class SaleConvert {

  private SaleConvert() {}

  public static final Sale convert(SummarySaleResource summarySaleDTO) {
    return new Sale(summarySaleDTO.getNetAmountSale(), summarySaleDTO.getGrossAmountSale(),
        summarySaleDTO.getMerchantDiscountRate(), summarySaleDTO.getNumberSummarySale());
  }
}
