package br.com.acquirer.service;

public interface AcquirerService <D, R> {
  void save(D acquirerDTO);

  void createSale(R request);

  D find(String cnpj);
}
