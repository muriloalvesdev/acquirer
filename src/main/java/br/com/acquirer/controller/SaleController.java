package br.com.acquirer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acquirer.resources.RequestResource;
import br.com.acquirer.service.AcquirerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RestController
@RequestMapping("api/sale")
public class SaleController {

  private AcquirerService acquirerService;

  @PostMapping("create")
  public ResponseEntity<Void> requestHolder(@Validated @RequestBody RequestResource request) {
    acquirerService.createSale(request);
    return ResponseEntity.ok().build();
  }

}
