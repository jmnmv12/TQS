package com.tqsLab5.CarInformationSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;

    @Test
    public void givenCar_whenGetCars_thenReturnJsonArray() throws Exception {
        Car ford = new Car("mustang","Ford");
        Car tesla = new Car("modelY","Tesla");
        Car renault = new Car("clio","Renault");

        given(service.getCarDetails("modelY")).willReturn(tesla);

        mvc.perform(get("/api/cars/modelY").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(tesla.getId()))).andExpect(jsonPath("$.name", is(tesla.getName()))).andExpect(jsonPath("$.maker", is(tesla.getMaker())));

        verify(service, VerificationModeFactory.times(1)).getCarDetails("modelY");
        reset(service);

    }
}