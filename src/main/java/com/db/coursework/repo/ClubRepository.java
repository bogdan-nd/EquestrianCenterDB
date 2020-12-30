package com.db.coursework.repo;

import com.db.coursework.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, Integer> {
}
