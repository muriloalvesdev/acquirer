package br.com.acquirer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.domain.utils.AcquirerName;

@Configuration
public class Config {

  @Autowired
  private AcquirerRepository acquirerRepository;

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public void persistAcquirers() {
    acquirerRepository.deleteAll();
    acquirerRepository.saveAndFlush(new Acquirer(AcquirerName.CIELO, "01027058000191"));
    acquirerRepository.saveAndFlush(new Acquirer(AcquirerName.REDE, " 01425787000104"));
  }

  @Bean
  public void persistEstablishment() {
    establishmentRepository.deleteAll();
    establishmentRepository.saveAndFlush(new Establishment("Panificadora do Murilo Alves",
        Long.parseLong("12345678"), acquirerRepository.findByAcquirerName(AcquirerName.CIELO).get(),
        Double.parseDouble("0.01")));

    establishmentRepository.saveAndFlush(new Establishment("Açougue do Murilo Alves",
        Long.parseLong("12345679"), acquirerRepository.findByAcquirerName(AcquirerName.REDE).get(),
        Double.parseDouble("0.01")));
  }

}
