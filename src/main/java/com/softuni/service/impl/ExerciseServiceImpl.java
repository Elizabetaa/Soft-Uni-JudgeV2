package com.softuni.service.impl;

import com.softuni.model.entity.Exercise;
import com.softuni.model.service.ExerciseServiceModel;
import com.softuni.repository.ExerciseRepository;
import com.softuni.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ModelMapper modelMapper;
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ModelMapper modelMapper, ExerciseRepository exerciseRepository) {
        this.modelMapper = modelMapper;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        Exercise exercise = this.modelMapper.map(exerciseServiceModel,Exercise.class);
        this.exerciseRepository.save(exercise);
    }

    @Override
    public List<String> getAllExerciseNames() {
       return  this.exerciseRepository.findAllExNames();
    }

    @Override
    public Exercise findByName(String name) {
        return this.exerciseRepository.findByName(name);
    }
}
