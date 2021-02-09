package com.softuni.service.impl;

import com.softuni.model.binding.HomeworkAddBindingModel;
import com.softuni.model.entity.Exercise;
import com.softuni.model.entity.Homework;
import com.softuni.model.entity.User;
import com.softuni.model.service.UserServiceModel;
import com.softuni.repository.HomeworkRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.ExerciseService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final UserService userService;
    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;

    public HomeworkServiceImpl(UserService userService, HomeworkRepository homeworkRepository, ExerciseService exerciseRepository, CurrentUser currentUser) {
        this.userService = userService;
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void addHomework(HomeworkAddBindingModel homeworkAddBindingModel) {
        Homework homework = new Homework()
                .setAddedOn(LocalDateTime.now())
                .setExercise(exerciseService.findByName(homeworkAddBindingModel.getExercise()))
                .setGitAddress(homeworkAddBindingModel.getGitAddress())
                .setAuthor(userService.findById(currentUser.getId()));

        this.homeworkRepository.save(homework);
    }


}
