package br.com.acquirer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class EstablishmentNotFoundException extends Exception {

  private static final long serialVersionUID = 8145395271536744254L;

  public EstablishmentNotFoundException(String message) {
    super(message);
  }

}
