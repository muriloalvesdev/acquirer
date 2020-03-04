package br.com.acquirer.service.acquirer;

import java.util.Optional;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.acquirer.convert.AcquirerConvertDTO;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.resources.AcquirerDataTransferObject;
import br.com.acquirer.resources.InfoTransactionResource;
import br.com.acquirer.resources.RequestResource;
import br.com.acquirer.resources.SummarySaleResource;
import br.com.acquirer.resources.http.request.TransactionRequest;
import br.com.acquirer.service.exception.EstablishmentNotFoundException;
import br.com.acquirer.service.exception.RequestErrorException;

@Service
public class AcquirerServiceImpl implements AcquirerService {
  private static final Logger LOG = Logger.getLogger(AcquirerServiceImpl.class);

  @Autowired
  private AcquirerRepository acquirerRepository;

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private AcquirerCompoment component;

  @Autowired
  private RestTemplate restTemplate;

  @Value("${uri.holder}")
  private String uriHolder;

  @Value("${uri.transaction}")
  private String uriTransaction;

  @Override
  public void save(AcquirerDataTransferObject acquirerDTO) {
    Acquirer acquirer = AcquirerConvertDTO.convert(acquirerDTO);
    acquirerRepository.save(acquirer);
  }

  @Override
  public AcquirerDataTransferObject findByCnpj(String cnpj) {
    Optional<Acquirer> optionalAcquirer = acquirerRepository.findByCnpj(cnpj);
    AcquirerDataTransferObject acquirerDTO = null;
    if (optionalAcquirer.isPresent()) {
      Acquirer acquirer = optionalAcquirer.get();
      acquirerDTO =
          new AcquirerDataTransferObject(acquirer.getAcquirerName().name(), acquirer.getCnpj());
    }
    return acquirerDTO;
  }

  @Override
  public void sendRequestToModules(RequestResource request) {

    TransactionRequest transactionRequest =
        createTransactionRequest(request.getTransaction(), request);

    Optional<Establishment> establishmentOptional =
        establishmentRepository.findByMerchantCode(Long.parseLong(request.getMerchantCode()));
    try {
      checkEstablishmentExist(request.getMerchantCode(), establishmentOptional);

      HttpStatus statusCode =
          component.sendRequest(restTemplate, request.getHolder(), uriHolder).getStatusCode();
      if (statusCode == HttpStatus.OK) {
        component.sendRequest(restTemplate, transactionRequest, uriTransaction);
      } else {
        throw new RequestErrorException(
            "request to holder module failed, status: " + statusCode.value());
      }

    } catch (Exception e) {
      LOG.error(
          "Error sending request to modules or establishment not exist, error:  " + e.getMessage());
    }
  }

  private TransactionRequest createTransactionRequest(InfoTransactionResource transactionResource,
      RequestResource request) {
    SummarySaleResource summarySaleResource = transactionResource.getSummarySale();
    return new TransactionRequest(request.getMerchantCode(), request.getTypeTransaction(),
        request.getCountInstallments(), request.getMaskedCreditCardNumber(),
        request.getCapturedAt(), request.getPaymentDate(), summarySaleResource,
        request.getHolder().getName());
  }

  private void checkEstablishmentExist(String merchantCode,
      Optional<Establishment> establishmentOptional) throws EstablishmentNotFoundException {
    if (!establishmentOptional.isPresent()) {
      throw new EstablishmentNotFoundException(
          "Establishment not found, merchantCode informed [ " + merchantCode + " ]");
    }
  }
}
