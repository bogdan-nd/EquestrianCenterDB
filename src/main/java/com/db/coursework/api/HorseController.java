package com.db.coursework.api;

import com.db.coursework.api.dto.HorseDTO;
import com.db.coursework.entities.Client;
import com.db.coursework.entities.Horse;
import com.db.coursework.entities.enums.HorsemanStatus;
import com.db.coursework.services.ClientService;
import com.db.coursework.services.HorseService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("horses")
@AllArgsConstructor
public class HorseController {
    private final HorseService horseService;

    @GetMapping
    public ResponseEntity<List<Horse>> getHorses() {
        return ResponseEntity.ok(horseService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Horse> getHorseById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(horseService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Horse> addHorse(@RequestBody HorseDTO horseDTO) {
        Horse newHorse = new Horse(horseDTO.getName(),
                horseDTO.getHorsemanStatus(), horseDTO.getPrice(), horseDTO.getGender());

        return ResponseEntity.ok(horseService.saveHorse(newHorse));
    }

    @PostMapping("{horseId}/recover")
    public ResponseEntity<String> recoverHorse(@PathVariable int horseId) {
        try {
            horseService.recoverHorse(horseId);
            return ResponseEntity.ok(String.format("Horse with %s id was recovered", horseId));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
