package controller;

import com.wba.api.customerest.constant.EapiErrorEnum;
import com.wba.api.customerest.constant.WalgErrorEnum;
import com.wba.api.customerest.controller.CustomerRestController;
import com.wba.api.customerest.dto.PatientDto;
import com.wba.api.customerest.exception.ControllerAdvisor;
import com.wba.api.customerest.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/16/2021
 */

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerRestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CustomerRestController customerRestController;

    @Mock
    CustomerService customerService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerRestController)
        .setControllerAdvice(new ControllerAdvisor())
                .build();
    }

    @Test
    public void getPatienById_ReturnSuccessResult() throws Exception {

        PatientDto expectedResponse = new PatientDto();
        expectedResponse.setPatientId("001");
        when(customerService.getPatientById("001")).thenReturn(expectedResponse);

        mockMvc.perform(post("/v1/pharmacy/patient/findBy?patientId=001").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void getPatienById_StatusCode400WhenargumentMismatch() throws Exception {

        mockMvc.perform(post("/v1/pharmacy/patient/findBy").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().json("{'messages':[{'code':'"+WalgErrorEnum.WAG_E_INVALID_REQUEST_1001+"','message':'"+EapiErrorEnum.ERRROR400.getMessage()+"','type':'ERROR'}]}"));
    }

    @Test
    public void getPatienById_StatusCode404WhenNodataFound() throws Exception {

        when(customerService.getPatientById("001")).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, EapiErrorEnum.ERRROR404.getMessage()));

        mockMvc.perform(post("/v1/pharmacy/patient/findBy?patientId=001").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(content().json("{'messages':[{'code':'"+WalgErrorEnum.WAG_E_SEARCH_1000+"','message':'"+EapiErrorEnum.ERRROR404.getMessage()+"','type':'ERROR'}]}"));

    }

    @Test
    public void getPatienById_StatusCode405WhenInvalidMethod() throws Exception {

        mockMvc.perform(get("/v1/pharmacy/patient/findBy?patientId=002").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
                .andExpect(content().json("{'messages':[{'code':'"+WalgErrorEnum.WAG_E_INVALID_METHOD_1001+"','message':'"+EapiErrorEnum.ERRROR405.getMessage()+"','type':'ERROR'}]}"));

    }

    @Test
    public void getPatienById_StatusCode500WhenInternalserver() throws Exception {

        when(customerService.getPatientById("001")).thenThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, EapiErrorEnum.ERRROR500.getMessage()));

        mockMvc.perform(post("/v1/pharmacy/patient/findBy?patientId=001").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .andExpect(content().json("{'messages':[{'code':'"+WalgErrorEnum.WAG_E_SVC_ERROR_1000+"','message':'"+EapiErrorEnum.ERRROR500.getMessage()+"','type':'ERROR'}]}"));

    }
}
