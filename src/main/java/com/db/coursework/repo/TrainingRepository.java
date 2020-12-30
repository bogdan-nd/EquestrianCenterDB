package com.db.coursework.repo;

import com.db.coursework.api.dto.TrainingResponse;
import com.db.coursework.entities.Horse;
import com.db.coursework.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    @Query(value = "SELECT * FROM training WHERE training.client_id = :clientToken ORDER BY start_time", nativeQuery = true)
    List<Training> getClientTrainings(@Param("clientToken") String clientToken);
}
