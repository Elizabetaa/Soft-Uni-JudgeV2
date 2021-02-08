package com.softuni.service;

import com.softuni.model.entity.Exercise;
import com.softuni.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> getAllExerciseNames();

    Exercise findByName(String name);

}
