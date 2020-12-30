package com.db.coursework.api.dto;

import lombok.Data;

@Data
public class TrainingResponse {
    private int trainingId;
    private String date;
    private String horseName;
    private String trainerName;
}
