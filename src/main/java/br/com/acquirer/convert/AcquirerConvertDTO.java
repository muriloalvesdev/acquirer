package br.com.acquirer.convert;

import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.utils.AcquirerName;
import br.com.acquirer.dto.AcquirerDataTransferObject;

public final class AcquirerConvertDTO {

  public static final Acquirer convert(AcquirerDataTransferObject acquirerDTO) {
    return new Acquirer(AcquirerName.getAndValidateAcquirerName(acquirerDTO.getName()),
        acquirerDTO.getCnpj());
  }
}
