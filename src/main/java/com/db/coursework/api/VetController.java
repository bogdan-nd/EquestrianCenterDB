package com.db.coursework.api;


import com.db.coursework.api.dto.VetDTO;
import com.db.coursework.entities.Vet;
import com.db.coursework.services.VetService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("vets")
@AllArgsConstructor
public class VetController {
    private final VetService vetService;

    @GetMapping
    public ResponseEntity<List<Vet>> showVets() {
        return ResponseEntity.ok(vetService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Vet> showVetById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(vetService.getById(id));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Vet> addVet(@RequestBody VetDTO vetDTO) {
        Vet newVet = new Vet(vetDTO.getName(), vetDTO.getSalary(), vetDTO.getConsultationPrice());

        return ResponseEntity.ok(vetService.saveVet(newVet));
    }
}