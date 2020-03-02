package br.com.acquirer.service.acquirer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.acquirer.domain.repository.AcquirerRepository;
import br.com.acquirer.domain.utils.AcquirerName;
import br.com.acquirer.resources.AcquirerDataTransferObject;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AcquirerServiceTest {

    @Autowired
    private AcquirerService service;

    @Autowired
    private AcquirerRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @After
    public void after() {
        repository.deleteAll();
    }

    @Test
    public void shouldTestSaveAcquirer() {
        AcquirerDataTransferObject acquirerDTO = new AcquirerDataTransferObject(
                "CIELO", "01027058000191");
        service.save(acquirerDTO);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldTestSaveAcquirerAndReturnException() {
        AcquirerDataTransferObject acquirerDTO = new AcquirerDataTransferObject(
                "CIELO", "01027058000191");
        service.save(acquirerDTO);
        service.save(acquirerDTO);
    }

    @Test
    public void shouldFindAcquirerByCnpj() {
        AcquirerDataTransferObject acquirerDTO = new AcquirerDataTransferObject(
                "REDE", "01425787000104");
        service.save(acquirerDTO);

        AcquirerDataTransferObject acquirerDTOByCnpj = service
                .findByCnpj("01425787000104");

        assertEquals(AcquirerName.REDE.name(), acquirerDTOByCnpj.getName());
        assertEquals("01425787000104", acquirerDTOByCnpj.getCnpj());

    }

}
