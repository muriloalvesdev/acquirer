package br.com.acquirer.service.acquirer;

import java.security.InvalidParameterException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import br.com.acquirer.convert.AcquirerConvertDTO;
import br.com.acquirer.convert.CreateTransactionRequest;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.dto.AcquirerDataTransferObject;
import br.com.acquirer.resources.RequestResource;
import br.com.acquirer.resources.http.request.TransactionRequest;
import br.com.acquirer.service.establishment.EstablishmentService;

@Service
public class AcquirerServiceImpl implements AcquirerService {

  private AcquirerRepository acquirerRepository;
  private EstablishmentRepository establishmentRepository;
  private AcquirerCompoment component;
  private RestTemplate restTemplate;
  private EstablishmentService establishmentService;

  @Value("${uri.holder}")
  private String uriHolder;

  @Value("${uri.transaction}")
  private String uriTransaction;

  public AcquirerServiceImpl(AcquirerRepository acquirerRepository,
      EstablishmentRepository establishmentRepository, AcquirerCompoment component,
      RestTemplate restTemplate, EstablishmentService establishmentService) {
    this.acquirerRepository = acquirerRepository;
    this.establishmentRepository = establishmentRepository;
    this.component = component;
    this.restTemplate = restTemplate;
    this.establishmentService = establishmentService;
  }

  @Override
  public void save(AcquirerDataTransferObject acquirerDTO) {
    Acquirer acquirer = AcquirerConvertDTO.convert(acquirerDTO);
    acquirerRepository.saveAndFlush(acquirer);
  }

  @Override
  public AcquirerDataTransferObject findByCnpj(String cnpj) {
    Optional<Acquirer> optionalAcquirer = acquirerRepository.findByCnpj(cnpj);
    AcquirerDataTransferObject acquirerDataTransferObject = null;

    checkAcquirerInformedExist(cnpj, optionalAcquirer);
    Acquirer acquirer = optionalAcquirer.get();

    acquirerDataTransferObject =
        new AcquirerDataTransferObject(acquirer.getAcquirerName().name(), acquirer.getCnpj());

    return acquirerDataTransferObject;
  }

  @Override
  public void createSale(RequestResource request) {

    TransactionRequest transactionRequest =
        CreateTransactionRequest.createTransactionRequest(request.getTransaction(), request);

    Optional<Establishment> establishmentOptional =
        establishmentRepository.findByMerchantCode(Long.parseLong(request.getMerchantCode()));

    establishmentService.checkEstablishmentExist(request.getMerchantCode(), establishmentOptional);

    HttpStatus statusResponseHolder = sendRequestToHolder(request);

    sendRequestToTransactions(transactionRequest, statusResponseHolder);

  }

  private void sendRequestToTransactions(TransactionRequest transactionRequest,
      HttpStatus statusCode) {
    if (statusCode == HttpStatus.OK) {
      component.sendRequest(restTemplate, transactionRequest, uriTransaction);
    } else {
      throw new ResponseStatusException(statusCode, "Request to module Holder failed!");
    }
  }

  private HttpStatus sendRequestToHolder(RequestResource request) {
    return component.sendRequest(restTemplate, request.getHolder(), uriHolder).getStatusCode();
  }

  private void checkAcquirerInformedExist(String cnpj, Optional<Acquirer> optionalAcquirer) {
    if (!optionalAcquirer.isPresent()) {
      throw new InvalidParameterException("CNPJ informed [" + cnpj + "] NOT FOUND!");
    }
  }

}
