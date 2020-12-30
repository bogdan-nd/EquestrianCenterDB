package com.db.coursework.entities;

import com.db.coursework.entities.enums.Gender;
import com.db.coursework.entities.enums.HorsemanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Horse {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private HorsemanStatus horsemanStatus;
    private Gender gender;
    private boolean isIll;
    private int price;

    public Horse(String name,  HorsemanStatus horsemanStatus, int price, Gender gender) {
        this.name = name;
        this.horsemanStatus = horsemanStatus;
        this.gender = gender;
        this.isIll = false;
        this.price = price;
    }

    public void getRecovered() {
        this.isIll = false;
    }
}
