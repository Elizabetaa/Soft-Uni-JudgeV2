package com.softuni.web;

import com.softuni.model.binding.HomeworkAddBindingModel;
import com.softuni.service.ExerciseService;
import com.softuni.service.HomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;

    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/add")
    public String add(Model model){
            model.addAttribute("names", this.exerciseService.getAllExerciseNames());
        if (!model.containsAttribute("homeworkAddBindingModel")){
            model.addAttribute(new HomeworkAddBindingModel());
        }
        return "homework-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid HomeworkAddBindingModel homeworkAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("ork.springframework.validation.BindingResult.homeworkAddBindingModel", bindingResult);
            return "redirect:add";
        }
        this.homeworkService.addHomework(homeworkAddBindingModel);


        return "redirect:/";
    }

    @GetMapping("/check")
    public String check(){
        return "homework-check";
    }

}
