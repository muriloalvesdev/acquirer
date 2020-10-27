package br.com.acquirer.exception;

public class EstablishmentNotFoundException extends RuntimeException {

  public EstablishmentNotFoundException(String key, String value) {
    super("Establishment not found with $s [ %s ]".formatted(key, value));
  }
}
