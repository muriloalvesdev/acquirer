package br.com.acquirer.convert;

import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.resources.EstablishmentDataTransferObject;

public final class EstablishmentConvertDTO {

  public static Establishment convert(EstablishmentDataTransferObject establishmentDTO,
      Acquirer acquirer) {

    return new Establishment(establishmentDTO.getName(),
        Long.parseLong(establishmentDTO.getMerchantCode()), acquirer,
        Double.parseDouble(establishmentDTO.getMDR()));
  }

}
