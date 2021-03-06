package com.softuni.repository;

import com.softuni.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {

    @Query(" SELECT e.name FROM Exercise AS e " +
            "ORDER BY e.name ")
    List<String> findAllExNames();

    Exercise findByName(String name);
}
