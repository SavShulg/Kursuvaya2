package com.practice.Kursov2.controller;

import com.practice.Kursov2.model.Question;
import com.practice.Kursov2.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    // http:localhost:8888/exam/5
    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        service.getQuestions(amount);
        return null;
    }
}
