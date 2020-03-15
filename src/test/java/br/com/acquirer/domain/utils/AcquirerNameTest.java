package br.com.acquirer.domain.utils;

import static org.junit.Assert.assertEquals;
import java.security.InvalidParameterException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AcquirerNameTest {

  @Test
  public void shouldReturnAcquirerNameCielo() {
    AcquirerName acquirerName = AcquirerName.getAndValidateAcquirerName("CIELO");
    assertEquals(AcquirerName.CIELO, acquirerName);
  }

  @Test
  public void shouldReturnAcquirerNameRede() {
    AcquirerName acquirerName = AcquirerName.getAndValidateAcquirerName("REDE");
    assertEquals(AcquirerName.REDE, acquirerName);
  }

  @Test(expected = InvalidParameterException.class)
  public void shouldReturnAcquirerNameNotFoundException() {
    AcquirerName.getAndValidateAcquirerName("Acquirer");
  }
}
