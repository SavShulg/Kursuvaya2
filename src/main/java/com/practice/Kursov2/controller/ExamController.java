package com.practice.Kursov2.controller;

import com.practice.Kursov2.model.Question;
import com.practice.Kursov2.service.ExaminerServise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping
@RestController
public class ExamController {
    private final ExaminerServise service;

    public ExamController(ExaminerServise service) {
        this.service = service;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return service.getQuestion(amount);

    }
}
