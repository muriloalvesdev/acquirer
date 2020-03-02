package br.com.acquirer.domain.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.acquirer.service.exception.AcquirerNameNotFoundException;

@SpringBootTest
@ActiveProfiles("test")
public class AcquirerNameTest {

    @Test
    public void shouldReturnAcquirerNameCielo()
            throws AcquirerNameNotFoundException {
        AcquirerName acquirerName = AcquirerName
                .getAndValidateAcquirerName("CIELO");
        assertEquals(AcquirerName.CIELO, acquirerName);
    }

    @Test
    public void shouldReturnAcquirerNameRede()
            throws AcquirerNameNotFoundException {
        AcquirerName acquirerName = AcquirerName
                .getAndValidateAcquirerName("REDE");
        assertEquals(AcquirerName.REDE, acquirerName);
    }

    @Test(expected = AcquirerNameNotFoundException.class)
    public void shouldReturnAcquirerNameNotFoundException()
            throws AcquirerNameNotFoundException {
        AcquirerName.getAndValidateAcquirerName("Acquirer");
    }
}
