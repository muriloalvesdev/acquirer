package br.com.acquirer.service.establishment;

import org.springframework.stereotype.Service;
import br.com.acquirer.convert.EstablishmentConvertDTO;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.dto.EstablishmentDataTransferObject;
import br.com.acquirer.exception.EstablishmentNotFoundException;

@Service
public class EstablishmentService {

  private EstablishmentRepository establishmentRepository;

  EstablishmentService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }
  public EstablishmentDataTransferObject findByMerchantCode(String merchantCode) {
    return this.establishmentRepository.findByMerchantCode(Long.parseLong(merchantCode))
        .map(EstablishmentConvertDTO::converToDTO)
        .orElseThrow(() -> new EstablishmentNotFoundException("merchant code", merchantCode));
  }
}
