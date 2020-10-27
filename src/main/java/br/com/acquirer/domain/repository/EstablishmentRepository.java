package br.com.acquirer.domain.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.acquirer.domain.model.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {
  Optional<Establishment> findByMerchantCode(Long merchantCode);
}
