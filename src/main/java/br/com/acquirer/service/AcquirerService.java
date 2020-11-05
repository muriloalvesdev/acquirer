package br.com.acquirer.service;

import br.com.acquirer.dto.AcquirerDataTransferObject;
import br.com.acquirer.resources.RequestResource;

public interface AcquirerService {
  void save(AcquirerDataTransferObject acquirerDTO);

  void createSale(RequestResource request);

  AcquirerDataTransferObject find(String cnpj);
}
