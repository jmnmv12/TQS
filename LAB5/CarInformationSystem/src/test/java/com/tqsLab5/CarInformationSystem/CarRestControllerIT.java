package com.tqsLab5.CarInformationSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import com.tqsLab5.CarInformationSystem.CarInformationSystemApplication;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = CarInformationSystemApplication.class)
@AutoConfigureMockMvc
// @TestPropertySource(locations = "application-integrationtest.properties")
@AutoConfigureTestDatabase
public class CarRestControllerIT {

    @Autowired
    private MockMvc mvc; // It has direct access to our api, so in integration tests is more correct to use TestRestTemplate

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestRestTemplate restClient; // External REST client

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    } // Erase all in the end because we are using a memory db only for tests


    @Test
    public void givenCar_whenGetCar_thenStatus200() throws Exception {
        Car ford = new Car("mustang", "Ford");
        repository.saveAndFlush(ford);

        /*mvc.perform(get("/api/cars/mustang").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(ford.getName())))
                .andExpect(jsonPath("$.maker", is(ford.getMaker())));*/

        // Another option is to use a real Http rest client and not a MockMvc

        ResponseEntity<Car> entity = restClient.getForEntity("/api/cars/mustang", Car.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().getName()).isEqualTo("mustang");
    }


}
