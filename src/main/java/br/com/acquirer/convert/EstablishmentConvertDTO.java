package br.com.acquirer.convert;

import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.dto.EstablishmentDataTransferObject;

public final class EstablishmentConvertDTO {

  public static Establishment convert(EstablishmentDataTransferObject establishmentDTO,
      Acquirer acquirer) {

    return new Establishment(establishmentDTO.getName(),
        Long.parseLong(establishmentDTO.getMerchantCode()), acquirer,
        Double.parseDouble(establishmentDTO.getMDR()));
  }

  public static EstablishmentDataTransferObject converToDTO(Establishment establishment) {
    return new EstablishmentDataTransferObject(establishment.getName(),
        establishment.getMerchantCode().toString(),
        establishment.getAcquirer().getAcquirerName().name(), establishment.getMDR().toString());
  }

}
