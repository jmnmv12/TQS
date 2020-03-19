package com.tqsLab5.CarInformationSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Resource
    @Qualifier("CarRepository")
    private CarRepository carRepository;

    @Test
    void whenFindByName_thenReturnCar() {
        Car ford = new Car("mustang", "Ford");
        entityManager.persistAndFlush(ford);

        Car found = carRepository.findByName(ford.getName());
        assertThat((found.getName())).isEqualTo(ford.getName());


    }

    @Test
    void whenInvalidName_thenReturnNull() {

        Car found = carRepository.findByName("ABC");
        assertThat(found).isNull();


    }

}