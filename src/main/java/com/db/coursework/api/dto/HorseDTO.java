package com.db.coursework.api.dto;

import com.db.coursework.entities.enums.Gender;
import com.db.coursework.entities.enums.HorsemanStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class HorseDTO {
    private String name;
    private int ownerId;
    private HorsemanStatus horsemanStatus;
    private int price;
    private Gender gender;
}
