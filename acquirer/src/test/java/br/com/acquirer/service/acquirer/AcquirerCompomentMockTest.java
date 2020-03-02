package br.com.acquirer.service.acquirer;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import br.com.acquirer.resources.RequestResource;

@SpringBootTest
@ActiveProfiles("test")
public class AcquirerCompomentMockTest {

    @Mock
    private ResponseEntity<Object> responseEntity;

    @Test
    public void shouldSendRequestMock() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        RequestResource request = mock(
                RequestResource.class);
        String uri = "uri_for_simulation";

        AcquirerCompoment acquirerCompoment = mock(AcquirerCompoment.class);

        BDDMockito.given(
                acquirerCompoment.sendRequest(restTemplate, request, uri))
                .willReturn(responseEntity);

        acquirerCompoment.sendRequest(restTemplate, request, uri);

        BDDMockito.verify(acquirerCompoment).sendRequest(restTemplate, request,
                uri);
    }

}
