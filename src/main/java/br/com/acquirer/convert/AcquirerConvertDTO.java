package br.com.acquirer.convert;

import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.utils.AcquirerName;
import br.com.acquirer.dto.AcquirerDataTransferObject;

public final class AcquirerConvertDTO {

  public static final Acquirer convert(AcquirerDataTransferObject acquirerDTO) {
    return Acquirer.newBuilder()
        .acquirerName(AcquirerName.getAndValidateAcquirerName(acquirerDTO.getName()))
        .cnpj(acquirerDTO.getCnpj()).build();
  }

  public static final AcquirerDataTransferObject convert(Acquirer acquirer) {
    return new AcquirerDataTransferObject(acquirer.getAcquirerName().name(), acquirer.getCnpj());
  }
}
