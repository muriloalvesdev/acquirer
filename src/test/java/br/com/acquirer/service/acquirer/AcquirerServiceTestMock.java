package br.com.acquirer.service.acquirer;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import br.com.acquirer.resources.RequestResource;

@SpringBootTest
@ActiveProfiles("test")
public class AcquirerServiceTestMock {

    @Test
    public void shouldTestRequestToModules() {

        RequestResource request = mock(
                RequestResource.class);
        AcquirerService service = mock(AcquirerService.class);

        BDDMockito.doNothing().when(service).createSale(request);
        service.createSale(request);
        BDDMockito.verify(service).createSale(request);
    }

}
