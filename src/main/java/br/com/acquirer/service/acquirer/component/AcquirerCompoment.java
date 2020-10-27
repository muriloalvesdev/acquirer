package br.com.acquirer.service.acquirer.component;

import java.util.Arrays;

import org.jboss.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AcquirerCompoment {

  private static final Logger LOG = Logger.getLogger(AcquirerCompoment.class);

  public ResponseEntity<Object> sendRequest(RestTemplate restTemplate, Object objectDTO,
      String uri) {
    LOG.info("Sending message to URI [ " + uri + " ]");
    HttpHeaders headers = createHttpHeaders();
    HttpEntity<Object> entity = createHttpEntity(objectDTO, headers);
    return restTemplate.exchange(uri, HttpMethod.POST, entity, Object.class);
  }

  private HttpHeaders createHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    return headers;
  }

  private HttpEntity<Object> createHttpEntity(Object objectDTO, HttpHeaders headers) {
    return new HttpEntity<Object>(objectDTO, headers);
  }

}
