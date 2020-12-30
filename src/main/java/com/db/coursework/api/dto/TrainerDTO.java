package com.db.coursework.api.dto;

import com.db.coursework.entities.enums.SportsCategory;
import lombok.Data;

@Data
public class TrainerDTO {
    private String name;
    private int salary;
    private SportsCategory sportCategory;
    private int trainingPrice;
}
