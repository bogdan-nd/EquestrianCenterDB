package com.db.coursework.api;


import com.db.coursework.api.dto.TrainerDTO;
import com.db.coursework.entities.Trainer;
import com.db.coursework.entities.enums.SportsCategory;
import com.db.coursework.services.TrainerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("trainers")
@AllArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Trainer>> showTrainers() {
        return ResponseEntity.ok(trainerService.getAll());
    }

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@RequestBody TrainerDTO trainerDTO) {
        Trainer newTrainer = new Trainer(trainerDTO.getName(), trainerDTO.getSalary(),
               trainerDTO.getSportCategory(), trainerDTO.getTrainingPrice());

        return ResponseEntity.ok(trainerService.saveTrainer(newTrainer));
    }

}
