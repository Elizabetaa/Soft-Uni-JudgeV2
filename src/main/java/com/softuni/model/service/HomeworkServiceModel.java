package com.softuni.model.service;

import com.softuni.model.entity.Exercise;
import com.softuni.model.entity.User;

import java.time.LocalDateTime;

public class HomeworkServiceModel {
    private LocalDateTime addedOn;
    private String gitAddress;
    private User author;
    private Exercise exercise;

    public HomeworkServiceModel() {
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public HomeworkServiceModel setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkServiceModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public HomeworkServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public HomeworkServiceModel setExercise(Exercise exercise) {
        this.exercise = exercise;
        return this;
    }
}
