package br.com.acquirer.convert;

import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.dto.EstablishmentDataTransferObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EstablishmentConvertDTO {

  public static EstablishmentDataTransferObject converToDTO(Establishment establishment) {
    return new EstablishmentDataTransferObject(establishment.getName(),
        establishment.getMerchantCode().toString());
  }

}
