package com.db.coursework.repo;

import com.db.coursework.entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VetRepository extends JpaRepository<Vet, Integer> {
}