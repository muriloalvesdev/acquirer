package br.com.acquirer.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.service.AcquirerService;
import br.com.acquirer.service.component.AcquirerCompoment;

public class AcquirerServiceImplTest {

  private AcquirerService service;
  private AcquirerRepository acquirerRepository;
  private EstablishmentRepository establishmentRepository;
  private AcquirerCompoment component;
  private RestTemplate restTemplate;

  @BeforeEach
  void setUp() {
    this.acquirerRepository = mock(AcquirerRepository.class);
    this.establishmentRepository = mock(EstablishmentRepository.class);
    this.component = spy(AcquirerCompoment.class);
    this.restTemplate = mock(RestTemplate.class);
    this.service = new AcquirerServiceImpl(this.acquirerRepository, this.establishmentRepository,
        this.component, this.restTemplate);
  }

  @Test
  void shouldTestRequestToModules() {



  }

}
