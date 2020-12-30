package com.db.coursework.services;

import com.db.coursework.api.dto.TrainingResponse;
import com.db.coursework.entities.Training;
import com.db.coursework.repo.TrainingRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingService {
    private final TrainingRepository repository;

    @Transactional
    public List<TrainingResponse> getAll() {
        List<Training> trainings = repository.findAll();
        return toTrainingResponse(trainings);
    }

    @Transactional
    public List<TrainingResponse> getClientTrainings(String clientToken) {
        List<Training> trainings = repository.getClientTrainings(clientToken);
        return toTrainingResponse(trainings);
    }

    private List<TrainingResponse> toTrainingResponse(List<Training> trainings){
        List<TrainingResponse> trainingResponses = new ArrayList<>();

        for (Training training : trainings) {
            trainingResponses.add(training.toTrainingResponse());
        }

        return trainingResponses;
    }

    @Transactional
    public Training saveTraining(Training training) {
        return repository.save(training);
    }

    @Transactional
    public Training getById(int id) throws NotFoundException {
        Optional<Training> training = repository.findById(id);
        if (training.isPresent())
            return training.get();
        else
            throw new NotFoundException(String.format("Training with %s id does not exist", id));
    }
}
