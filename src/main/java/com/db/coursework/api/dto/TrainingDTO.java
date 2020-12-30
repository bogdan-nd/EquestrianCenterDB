package com.db.coursework.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainingDTO {
    private int trainerId;
    private int horseId;
    private String clientToken;
    private String startTime;
}
