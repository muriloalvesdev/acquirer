package br.com.acquirer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestErrorException extends RuntimeException {

  private static final long serialVersionUID = -1640574366323491314L;

  public RequestErrorException(String message) {
    super(message);
  }

}
