package com.db.coursework.api;

import com.db.coursework.api.dto.TrainingDTO;
import com.db.coursework.api.dto.TrainingResponse;
import com.db.coursework.services.CreateTrainingService;
import com.db.coursework.services.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("trainings")
@AllArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;
    private final CreateTrainingService createTrainingService;

    @GetMapping
    public ResponseEntity<List<TrainingResponse>> showTrainings() {
        return ResponseEntity.ok(trainingService.getAll());
    }

    @GetMapping("{clientToken}")
    public ResponseEntity<List<TrainingResponse>> showClientTrainings(@PathVariable String clientToken) {
        return ResponseEntity.ok(trainingService.getClientTrainings(clientToken));
    }

    @PostMapping
    public void addTraining(@RequestBody TrainingDTO trainingDTO) {
        createTrainingService.createTraining(trainingDTO);
    }
}
