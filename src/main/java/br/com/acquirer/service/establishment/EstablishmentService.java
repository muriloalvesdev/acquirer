package br.com.acquirer.service.establishment;

import java.security.InvalidParameterException;
import java.util.Optional;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import br.com.acquirer.convert.EstablishmentConvertDTO;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.dto.EstablishmentDataTransferObject;

@Service
public class EstablishmentService {

  private static final Logger LOG = Logger.getLogger(EstablishmentService.class);

  private EstablishmentRepository establishmentRepository;

  public EstablishmentService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  public EstablishmentDataTransferObject findByMerchantCode(String merchantCode) {
    Optional<Establishment> establishmentOptional =
        establishmentRepository.findByMerchantCode(Long.parseLong(merchantCode));

    try {
      checkEstablishmentExist(merchantCode, establishmentOptional);
    } catch (Exception e) {
      LOG.error(e.getMessage(), e);
    }
    Establishment establishment = establishmentOptional.get();
    return EstablishmentConvertDTO.converToDTO(establishment);
  }


  public void checkEstablishmentExist(String merchantCode,
      Optional<Establishment> establishmentOptional) {
    if (!establishmentOptional.isPresent()) {
      throw new InvalidParameterException(
          "MerchantCode informed [ " + merchantCode + " ] not found!");
    }
  }
}
