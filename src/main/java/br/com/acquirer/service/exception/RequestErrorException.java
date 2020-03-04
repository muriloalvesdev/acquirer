package br.com.acquirer.service.exception;

public class RequestErrorException extends RuntimeException {

  private static final long serialVersionUID = -1640574366323491314L;

  public RequestErrorException(String message) {
    super(message);
  }

}
