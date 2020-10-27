package br.com.acquirer.domain.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class AcquirerNameTest {

  @Test
  void shouldReturnAcquirerNameCielo() {
    AcquirerName acquirerName = AcquirerName.getAndValidateAcquirerName("CIELO");
    assertEquals(AcquirerName.CIELO, acquirerName);
  }

  @Test
  void shouldReturnAcquirerNameRede() {
    AcquirerName acquirerName = AcquirerName.getAndValidateAcquirerName("REDE");
    assertEquals(AcquirerName.REDE, acquirerName);
  }

  @Test
  void shouldReturnAcquirerNameNotFoundException() {
    Exception exception = assertThrows(InvalidParameterException.class, () -> {
      AcquirerName.getAndValidateAcquirerName("anything");
    });
    
    assertTrue(exception instanceof InvalidParameterException);
    assertEquals("Acquirer informed [ anything ] not found!", exception.getMessage());
  }
}
