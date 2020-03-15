package br.com.acquirer.convert;

import org.jboss.logging.Logger;

import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.utils.AcquirerName;
import br.com.acquirer.dto.AcquirerDataTransferObject;

public final class AcquirerConvertDTO {

  private static final Logger LOG = Logger.getLogger(AcquirerConvertDTO.class);

  public static final Acquirer convert(AcquirerDataTransferObject acquirerDTO) {
    Acquirer acquirer = null;
    try {
      acquirer = new Acquirer(AcquirerName.getAndValidateAcquirerName(acquirerDTO.getName()),
          acquirerDTO.getCnpj());
    } catch (Exception e) {
      LOG.error("Error when trying to parse the DTO, message: " + e.getMessage());
    }
    return acquirer;
  }
}
