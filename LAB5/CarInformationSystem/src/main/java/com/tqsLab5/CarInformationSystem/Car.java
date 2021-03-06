package com.tqsLab5.CarInformationSystem;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car")
public class Car {

    public Car() {
    }

    public Car (String name, String maker){
        this.name=name;
        this.maker=maker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 3, max = 20)
    private String maker;
}
