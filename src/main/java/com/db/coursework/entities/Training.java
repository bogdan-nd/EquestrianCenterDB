package com.db.coursework.entities;

import com.db.coursework.api.dto.TrainingResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "horse_id")
    private Horse horse;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private String startTime;
    private int duration;

    public Training(Trainer trainer, Horse horse, Client client, String startTime) {
        this.trainer = trainer;
        this.horse = horse;
        this.client = client;
        this.startTime = startTime;
        this.duration = 90;
    }

    public TrainingResponse toTrainingResponse(){
         TrainingResponse response = new TrainingResponse();
         if(startTime != null)
            response.setDate(startTime.toString());
         response.setTrainingId(id);
         response.setHorseName(horse.getName());
         response.setTrainerName(trainer.getName());
         return response;
    }
}
