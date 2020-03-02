package br.com.acquirer.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.acquirer.convert.AcquirerConvertDTO;
import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.utils.AcquirerName;
import br.com.acquirer.resources.AcquirerDataTransferObject;
import br.com.acquirer.service.exception.AcquirerNameNotFoundException;

@SpringBootTest
@ActiveProfiles("test")
public class AcquirerConvertDTOTest {

    @Test
    public void shouldReturnAcquirerEntityByAcquirerCielo()
            throws AcquirerNameNotFoundException {
        AcquirerDataTransferObject acquirerDTO = new AcquirerDataTransferObject(
                "CIELO", "49253216000158");
        Acquirer acquirerEntity = AcquirerConvertDTO.convert(acquirerDTO);
        assertEquals(AcquirerName.CIELO, acquirerEntity.getAcquirerName());
        assertEquals("49253216000158", acquirerEntity.getCnpj());
    }

    @Test
    public void shouldReturnAcquirerEntityByAcquirerRede()
            throws AcquirerNameNotFoundException {
        AcquirerDataTransferObject acquirerDTO = new AcquirerDataTransferObject(
                "REDE", "49253216000158");
        Acquirer acquirerEntity = AcquirerConvertDTO.convert(acquirerDTO);
        assertEquals(AcquirerName.REDE, acquirerEntity.getAcquirerName());
        assertEquals("49253216000158", acquirerEntity.getCnpj());
    }
}
