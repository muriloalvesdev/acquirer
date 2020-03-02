package br.com.acquirer.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acquirer.domain.model.Establishment;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {
  Optional<Establishment> findByMerchantCode(Long merchantCode);
}
