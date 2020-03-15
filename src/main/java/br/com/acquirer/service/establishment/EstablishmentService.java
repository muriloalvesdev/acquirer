package br.com.acquirer.service.establishment;

import java.security.InvalidParameterException;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.acquirer.convert.EstablishmentConvertDTO;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.dto.EstablishmentDataTransferObject;

@Service
public class EstablishmentService {

  private EstablishmentRepository establishmentRepository;

  public EstablishmentService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  public EstablishmentDataTransferObject findByMerchantCode(String merchantCode) {

    Optional<Establishment> establishmentOptional =
        establishmentRepository.findByMerchantCode(Long.parseLong(merchantCode));
    checkEstablishmentExist(merchantCode, establishmentOptional);
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
