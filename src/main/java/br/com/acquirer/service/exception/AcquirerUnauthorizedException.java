package br.com.acquirer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AcquirerUnauthorizedException extends Exception {

  private static final long serialVersionUID = -15952085821644395L;

  public AcquirerUnauthorizedException(String message) {
    super(message);
  }

}

