package com.db.coursework.services;
import com.db.coursework.entities.Horse;
import com.db.coursework.entities.enums.HorsemanStatus;
import com.db.coursework.repo.HorseRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HorseService {
    private final HorseRepository repository;

    @Transactional
    public List<Horse> findAll() {
        return repository.findAll();
    }

    @Transactional
    public List<Horse> findSuitable(HorsemanStatus status) throws NotFoundException {
        List<Horse> suitableHorses =  repository.getSuitableHorses(status.ordinal());
        if (suitableHorses.size() ==0)
            throw new NotFoundException("There are any suitable horses");
        return suitableHorses;

    }

    @Transactional
    public Horse saveHorse(Horse horse) {
        return repository.save(horse);
    }

    @Transactional
    public Horse getById(int id) throws NotFoundException {
        Optional<Horse> horse =  repository.findById(id);
        if (horse.isPresent())
            return horse.get();
        else
            throw new NotFoundException(String.format("Horse with %s id does not exist",id));
    }


    @Transactional
    public void recoverHorse(int id) throws NotFoundException {
        Horse horse = getById(id);
        horse.getRecovered();
        saveHorse(horse);
    }
}
