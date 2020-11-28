package br.com.acquirer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acquirer.dto.EstablishmentDataTransferObject;
import br.com.acquirer.service.establishment.EstablishmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RestController
@RequestMapping("/api/establishment")
public class EstablishmentController {

  private EstablishmentService service;

  @GetMapping("find/{merchantcode}")
  public ResponseEntity<EstablishmentDataTransferObject> findByMerchantCode(
      @PathVariable(name = "merchantcode", required = true) String merchantCode) {
    return ResponseEntity.ok(this.service.findByMerchantCode(merchantCode));
  }

}
