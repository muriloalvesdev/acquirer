package br.com.acquirer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acquirer.resources.RequestResource;
import br.com.acquirer.service.acquirer.AcquirerService;

@RestController
@RequestMapping("api/sale")
public class SaleController {

  @Autowired
  private AcquirerService acquirerService;

  @PostMapping("create")
  public ResponseEntity<Void> requestHolder(@RequestBody RequestResource request) {
    acquirerService.sendRequestToModules(request);
    return ResponseEntity.ok().build();
  }

}
