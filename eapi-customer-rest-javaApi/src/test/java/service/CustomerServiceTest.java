package service;

import com.mongodb.MongoException;
import com.wba.api.customerest.constant.EapiErrorEnum;
import com.wba.api.customerest.dto.PatientDto;
import com.wba.api.customerest.dto.PaymentDto;
import com.wba.api.customerest.dto.ShippingAddressDto;
import com.wba.api.customerest.model.PatientModel;
import com.wba.api.customerest.repository.PatientRepository;
import com.wba.api.customerest.service.CustomerServiceImpl;
import gherkin.deps.com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/15/2021
 */

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    PatientRepository patientRepository;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    PatientModel patientModel =new PatientModel();
    PatientDto patientDto;

    @Before
    public void setUp() throws Exception {

        patientModel.setPatientId("001");
        patientModel.setAddressLine1("Address001");
        patientModel.setCreditCard("CR001");
        patientModel.setExpiryMonth(1L);
        patientModel.setLastFourDigits(1);

        ModelMapper modelMapper = new ModelMapper(); // building patient model using model mapper helper class
        patientDto = modelMapper.map(patientModel, PatientDto.class);

        PaymentDto paymentDto = modelMapper.map(patientModel, PaymentDto.class);
        ShippingAddressDto shippingAddressDto = modelMapper.map(patientModel, ShippingAddressDto.class);

        patientDto.setCustomerShippingAddress(shippingAddressDto);
        patientDto.getProfilePaymentDetails().add(paymentDto);
    }

    @Test
    public void getPatientById_WhenIdexsist(){

        when(patientRepository.findByPatientId("001")).thenReturn(patientModel);
        assertEquals(customerService.getPatientById("001"),patientDto);
    }

    @Test
    public void getPatientById_WhenIdNotexsist(){

        expectedEx.expect(ResponseStatusException.class);
        expectedEx.expectMessage(EapiErrorEnum.ERRROR404.getMessage());
        customerService.getPatientById("001").getPatientId();

    }

    @Test
    public void getPatientById_WhenGettingProcesingException(){

        JsonObject dummyResponse=new JsonObject();
        when(patientRepository.findByPatientId("001")).thenThrow(NullPointerException.class);

        expectedEx.expect(ResponseStatusException.class);
        expectedEx.expectMessage(EapiErrorEnum.ERRROR500.getMessage());
        customerService.getPatientById("001").getPatientId();

    }

    @Test
    public void getPatientById_WhenDBdown(){

        when(patientRepository.findByPatientId("001")).thenThrow(MongoException.class);

        expectedEx.expect(ResponseStatusException.class);
        expectedEx.expectMessage(EapiErrorEnum.ERRROR503.getMessage());
        customerService.getPatientById("001").getPatientId();

    }
}
