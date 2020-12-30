package com.db.coursework.services;

import com.db.coursework.entities.Vet;
import com.db.coursework.repo.VetRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VetService{
    private final VetRepository repository;

    @Transactional
    public List<Vet> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Vet saveVet(Vet vet) {
        return repository.save(vet);
    }

    @Transactional
    public Vet getById(int id) throws NotFoundException {
        Optional<Vet> vet = repository.findById(id);
        if(vet.isPresent())
            return vet.get();
        else
            throw new NotFoundException(String.format("Vet with %s id doesn`t exist",id));
    }
}
