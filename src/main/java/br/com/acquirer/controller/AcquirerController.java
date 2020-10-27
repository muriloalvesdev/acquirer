package br.com.acquirer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acquirer.dto.AcquirerDataTransferObject;
import br.com.acquirer.service.AcquirerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RestController
@RequestMapping("api/acquirer")
public class AcquirerController {

  private AcquirerService acquirerService;

  @GetMapping("find/{cnpj}")
  public ResponseEntity<AcquirerDataTransferObject> findByCnpj(
      @PathVariable(value = "cnpj", required = true) String cnpj) {
    return ResponseEntity.ok(acquirerService.findByCnpj(cnpj));
  }

}
