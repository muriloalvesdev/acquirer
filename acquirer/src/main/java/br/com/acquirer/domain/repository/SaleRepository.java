package br.com.acquirer.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.acquirer.domain.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

}
