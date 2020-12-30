package com.db.coursework.services;


import com.db.coursework.entities.Trainer;
import com.db.coursework.entities.enums.SportsCategory;
import com.db.coursework.repo.TrainerRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TrainerService {
    private final TrainerRepository repository;

    @Transactional
    public List<Trainer> getAll() {
        return repository.findAll();
    }

    @Transactional
    public List<Trainer> getSuitable(SportsCategory category) throws NotFoundException{
        List<Trainer> suitableTrainers =  repository.getSuitableTrainers(category.ordinal());

        if(suitableTrainers.size() == 0)
                throw new NotFoundException("There are any suitable trainers");

        return suitableTrainers;
    }

    @Transactional
    public Trainer saveTrainer(Trainer trainer) {
        return repository.save(trainer);
    }

    @Transactional
    public Trainer getById(int id) throws NotFoundException {
        Optional<Trainer> trainer = repository.findById(id);
        if(trainer.isPresent())
            return trainer.get();
        else
            throw new NotFoundException(String.format("Trainer with %s id doesn`t exist",id));
    }

}
