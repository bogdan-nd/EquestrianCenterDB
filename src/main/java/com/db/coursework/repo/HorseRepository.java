package com.db.coursework.repo;

import com.db.coursework.entities.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface HorseRepository extends JpaRepository<Horse, Integer> {
    @Query(value = "select * from horse where horseman_status = :status", nativeQuery = true)
    List<Horse> getSuitableHorses(@Param("status") int status);

}
