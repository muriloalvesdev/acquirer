package br.com.acquirer.service.acquirer;

import br.com.acquirer.dto.AcquirerDataTransferObject;
import br.com.acquirer.resources.RequestResource;

public interface AcquirerService {
  void save(AcquirerDataTransferObject acquirerDTO);

  void sendRequestToModules(RequestResource request);

  AcquirerDataTransferObject findByCnpj(String cnpj);
}
