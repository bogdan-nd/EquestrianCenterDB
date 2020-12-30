package com.db.coursework.api.dto;

import com.db.coursework.entities.enums.HorsemanStatus;
import com.db.coursework.entities.enums.SportsCategory;
import lombok.Data;


@Data
public class ClientDTO {
    private String name;
    private SportsCategory sportsCategory;
    private HorsemanStatus horsemanStatus;
    private String clientToken;
}
