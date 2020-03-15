package br.com.acquirer.convert;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.utils.AcquirerName;
import br.com.acquirer.dto.EstablishmentDataTransferObject;

@SpringBootTest
@ActiveProfiles("test")
public class EstablishmentConvertDTOTest {

  @Test
  public void shouldConvertAndReturnEstablishmentEntity() {
    EstablishmentDataTransferObject establishmentDTO = new EstablishmentDataTransferObject(
        "Padaria do mumu", "2345765", AcquirerName.CIELO.name(), "2.10");

    EstablishmentConvertDTO.convert(establishmentDTO,
        new Acquirer(AcquirerName.CIELO, "01027058000191"));
  }

}
