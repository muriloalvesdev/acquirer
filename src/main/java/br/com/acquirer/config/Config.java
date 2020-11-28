package br.com.acquirer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.model.Establishment;
import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.repository.EstablishmentRepository;
import br.com.acquirer.domain.utils.AcquirerName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Configuration
public class Config {

  private AcquirerRepository acquirerRepository;
  private EstablishmentRepository establishmentRepository;
  
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public void persistAcquirers() {
    if (!this.acquirerRepository.findByAcquirerName(AcquirerName.CIELO).isPresent()
        && !this.acquirerRepository.findByAcquirerName(AcquirerName.REDE).isPresent()) {
      this.acquirerRepository.saveAndFlush(
          Acquirer.newBuilder().acquirerName(AcquirerName.CIELO).cnpj("01027058000191").build());
      this.acquirerRepository.saveAndFlush(
          Acquirer.newBuilder().acquirerName(AcquirerName.REDE).cnpj("01425787000104").build());
    }
  }

  @Bean
  public void persistEstablishment() {
    if (!this.establishmentRepository.findByMerchantCode(Long.parseLong("12345678")).isPresent()
        && !this.establishmentRepository.findByMerchantCode(Long.parseLong("12345679"))
            .isPresent()) {
      this.establishmentRepository.saveAndFlush(Establishment.newBuilder()
          .name("Panificadora do Murilo Alves").merchantCode(Long.parseLong("12345678"))
          .acquirer(this.acquirerRepository.findByAcquirerName(AcquirerName.CIELO).get())
          .MDR(Double.parseDouble("0.01")).build());

      this.establishmentRepository.saveAndFlush(Establishment.newBuilder()
          .name("Açougue do Murilo Alves").merchantCode(Long.parseLong("12345679"))
          .acquirer(this.acquirerRepository.findByAcquirerName(AcquirerName.REDE).get())
          .MDR(Double.parseDouble("0.01")).build());
    }
  }

}
