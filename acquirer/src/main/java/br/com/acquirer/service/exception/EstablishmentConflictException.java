package br.com.acquirer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EstablishmentConflictException extends RuntimeException {

  private static final long serialVersionUID = -1980826759191653011L;

  public EstablishmentConflictException(String message) {
    super(message);
  }

}
