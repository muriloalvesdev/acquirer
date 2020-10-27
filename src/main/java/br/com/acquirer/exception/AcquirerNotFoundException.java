package br.com.acquirer.exception;

public class AcquirerNotFoundException extends RuntimeException {
  public AcquirerNotFoundException(String key, String value) {
    super("Acquirer not found with %s [ %s ]".formatted(key, value));
  }
}
