package br.com.acquirer.controller.handler;

import java.security.InvalidParameterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.acquirer.domain.model.ApiException;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

  private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
  private static final String INVALID_FIELDS = "Invalid field(s)";
  private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

  @ExceptionHandler(InvalidParameterException.class)
  public @ResponseBody ResponseEntity<ApiException> handleInvalidParameterException(
      InvalidParameterException ex) {
    return ResponseEntity.status(NOT_FOUND)
        .body(createResponseException(ex.getMessage(), NOT_FOUND));
  }

  @ExceptionHandler(ResponseStatusException.class)
  public @ResponseBody ResponseEntity<ApiException> handleResponseStatusException(
      ResponseStatusException ex) {
    return ResponseEntity.status(ex.getStatus())
        .body(createResponseException(ex.getMessage(), ex.getStatus()));
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return ResponseEntity.status(BAD_REQUEST)
        .body(createResponseException(INVALID_FIELDS, BAD_REQUEST));
  }

  private ApiException createResponseException(String message, HttpStatus status) {
    return new ApiException(message, status.value());
  }
}


