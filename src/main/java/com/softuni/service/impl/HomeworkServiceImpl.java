package com.softuni.service.impl;

import com.softuni.model.binding.HomeworkAddBindingModel;
import com.softuni.model.entity.Exercise;
import com.softuni.model.entity.Homework;
import com.softuni.model.entity.User;
import com.softuni.repository.ExerciseRepository;
import com.softuni.repository.HomeworkRepository;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.HomeworkService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final UserRepository userRepository;
    private final HomeworkRepository homeworkRepository;
    private final ExerciseRepository exerciseRepository;
    private final CurrentUser currentUser;

    public HomeworkServiceImpl(UserRepository userRepository, HomeworkRepository homeworkRepository, ExerciseRepository exerciseRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.homeworkRepository = homeworkRepository;
        this.exerciseRepository = exerciseRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void addHomework(HomeworkAddBindingModel homeworkAddBindingModel) {
        Exercise ex = this.exerciseRepository.findByName(homeworkAddBindingModel.getExercise());
        User user = this.userRepository.findByUsername(currentUser.getUsername());

        Homework homework = new Homework()
                .setAddedOn(LocalDateTime.now())
                .setExercise(ex)
                .setGitAddress(homeworkAddBindingModel.getGitAddress())
                .setAuthor(user);

        this.homeworkRepository.save(homework);
    }


}
