package br.com.acquirer.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acquirer.domain.model.Acquirer;
import br.com.acquirer.domain.utils.AcquirerName;

@Repository
public interface AcquirerRepository extends JpaRepository<Acquirer, UUID> {
  Optional<Acquirer> findByAcquirerName(AcquirerName acquirerName);

  Optional<Acquirer> findByCnpj(String cnpj);
}
