package br.com.acquirer.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import br.com.acquirer.convert.AcquirerConvertDTO;
import br.com.acquirer.convert.TransactionsUtil;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.dto.AcquirerDataTransferObject;
import br.com.acquirer.exception.AcquirerNotFoundException;
import br.com.acquirer.resources.RequestResource;
import br.com.acquirer.resources.http.request.TransactionRequest;
import br.com.acquirer.service.AcquirerService;
import br.com.acquirer.service.component.AcquirerCompoment;

@Service
public class AcquirerServiceImpl implements AcquirerService<AcquirerDataTransferObject, RequestResource> {

  private static final String REQUEST_HOLDER_FAILED = "Request to module Holder failed!";

  private AcquirerRepository acquirerRepository;
  private EstablishmentRepository establishmentRepository;
  private AcquirerCompoment component;
  private RestTemplate restTemplate;

  @Value("${uri.holder}")
  private String uriHolder;

  @Value("${uri.transaction}")
  private String uriTransaction;

  AcquirerServiceImpl(AcquirerRepository acquirerRepository,
      EstablishmentRepository establishmentRepository, AcquirerCompoment component,
      RestTemplate restTemplate) {
    this.acquirerRepository = acquirerRepository;
    this.establishmentRepository = establishmentRepository;
    this.component = component;
    this.restTemplate = restTemplate;
  }

  @Override
  public void save(AcquirerDataTransferObject acquirerDTO) {
    Acquirer acquirer = AcquirerConvertDTO.convert(acquirerDTO);
    this.acquirerRepository.saveAndFlush(acquirer);
  }

  @Override
  public AcquirerDataTransferObject find(String cnpj) {
    return this.acquirerRepository.findByCnpj(cnpj).map(AcquirerConvertDTO::convert)
        .orElseThrow(() -> new AcquirerNotFoundException("cnpj", cnpj));
  }

  @Override
  public void createSale(RequestResource request) {
    TransactionRequest transactionRequest =
        TransactionsUtil.createTransactionRequest(request.getTransaction(), request);
    this.establishmentRepository.findByMerchantCode(Long.parseLong(request.getMerchantCode()))
        .ifPresent(establishment -> {
          ResponseEntity<Object> responseEntity = sendRequestToHolder(request);
          sendRequestToTransactions(transactionRequest, responseEntity);
        });
  }

  private void sendRequestToTransactions(TransactionRequest transactionRequest,
      ResponseEntity<Object> responseEntity) {
    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      this.component.sendRequest(this.restTemplate, transactionRequest, this.uriTransaction);
    } else {
      throw new ResponseStatusException(responseEntity.getStatusCode(), REQUEST_HOLDER_FAILED);
    }
  }

  private ResponseEntity<Object> sendRequestToHolder(RequestResource request) {
    return this.component.sendRequest(this.restTemplate, request.getHolder(), this.uriHolder);
  }
}
