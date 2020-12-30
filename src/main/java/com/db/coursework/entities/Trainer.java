package com.db.coursework.entities;

import com.db.coursework.entities.enums.SportsCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public final class Trainer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int salary;
    private SportsCategory sportCategory;
    private int trainingPrice;

    public Trainer(String name, int salary, SportsCategory sportCategory, int trainingPrice) {
        this.name = name;
        this.salary = salary;
        this.sportCategory = sportCategory;
        this.trainingPrice = trainingPrice;
    }
}
