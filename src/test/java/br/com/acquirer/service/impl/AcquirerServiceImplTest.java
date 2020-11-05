package br.com.acquirer.service.impl;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import br.com.acquirer.ConstantsTests;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.dto.AcquirerDataTransferObject;
import br.com.acquirer.provider.AcquirerEntityProvider;
import br.com.acquirer.service.AcquirerService;
import br.com.acquirer.service.component.AcquirerCompoment;

public class AcquirerServiceImplTest implements ConstantsTests {

  private AcquirerService service;
  private AcquirerRepository acquirerRepository;
  private EstablishmentRepository establishmentRepository;
  private AcquirerCompoment component;
  private RestTemplate restTemplate;

  @BeforeEach
  void setUp() {
    this.acquirerRepository = spy(AcquirerRepository.class);
    this.establishmentRepository = spy(EstablishmentRepository.class);
    this.component = spy(AcquirerCompoment.class);
    this.restTemplate = spy(RestTemplate.class);
    this.service = new AcquirerServiceImpl(this.acquirerRepository, this.establishmentRepository,
        this.component, this.restTemplate);
  }

  @ParameterizedTest
  @ArgumentsSource(AcquirerEntityProvider.class)
  void shouldSaveAcquirer(Acquirer acquirer) {
    AcquirerDataTransferObject acquirerDTO =
        new AcquirerDataTransferObject(CIELO.name(), CNPJ_CIELO);
    BDDMockito.given(this.acquirerRepository.saveAndFlush(acquirer)).willReturn(acquirer);

    this.service.save(acquirerDTO);

    BDDMockito.verify(this.acquirerRepository, times(1)).saveAndFlush(Mockito.any());
  }

}
