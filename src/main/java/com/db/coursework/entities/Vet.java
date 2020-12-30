package com.db.coursework.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public final class Vet {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int salary;
    private int consultationPrice;
    private int recoveredHorsesNumber;

    public Vet(String name, int salary, int consultationPrice) {
        this.name = name;
        this.salary = salary;
        this.consultationPrice = consultationPrice;
        this.recoveredHorsesNumber = 0;
    }
}
