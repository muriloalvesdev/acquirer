package br.com.acquirer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AcquirerNameNotFoundException extends Exception {

  private static final long serialVersionUID = 4648127604293358226L;

  public AcquirerNameNotFoundException(String message) {
    super(message);
  }

}
