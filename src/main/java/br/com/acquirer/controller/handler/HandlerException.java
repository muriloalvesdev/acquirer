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
import br.com.acquirer.domain.model.RequestExceptionError;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidParameterException.class)
  public @ResponseBody ResponseEntity<RequestExceptionError> handleInvalidParameterException(
      InvalidParameterException ex) {

    RequestExceptionError exceptionError =
        new RequestExceptionError(ex.getMessage(), HttpStatus.NOT_FOUND.value());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionError);
  }

  @ExceptionHandler(ResponseStatusException.class)
  public @ResponseBody ResponseEntity<RequestExceptionError> handleResponseStatusException(
      ResponseStatusException ex) {
    RequestExceptionError exceptionError =
        new RequestExceptionError(ex.getMessage(), ex.getStatus().value());
    return ResponseEntity.status(ex.getStatus()).body(exceptionError);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    String defaultMessage = "Invalid field(s)";

    RequestExceptionError error =
        new RequestExceptionError(defaultMessage, HttpStatus.BAD_REQUEST.value());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }


}


