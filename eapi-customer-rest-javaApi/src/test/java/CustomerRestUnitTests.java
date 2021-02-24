import com.wba.api.customerest.controller.CustomerRestController;
import com.wba.api.customerest.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(
        classes = {
                CustomerRestController.class,
                com.wba.api.customerest.service.CustomerServiceImpl.class
        }, loader = AnnotationConfigContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
public class CustomerRestUnitTests {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestUnitTests.class);

    @InjectMocks
    CustomerRestController customerRestController;

    @Mock
    CustomerService customerService;

    @Test
    public void getPatientById_scucessscenario() {

        /*logger.info("Testing getPatientById API");

        PatientDto expectedResponse = new PatientDto();
        expectedResponse.setPatientId("001");

        when(customerService.getPatientById("001")).thenReturn(expectedResponse);

        PatientDto actualResponse = customerRestController.getPatientById("001");
        assertEquals(expectedResponse, actualResponse);*/

    }

}
