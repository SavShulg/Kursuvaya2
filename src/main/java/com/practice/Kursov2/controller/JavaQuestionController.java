package com.practice.Kursov2.controller;

import com.practice.Kursov2.model.Question;
import com.practice.Kursov2.service.QuestionServise;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/java")
@RestController
public class JavaQuestionController {
    private final QuestionServise servise;
    public JavaQuestionController(@Qualifier("java") QuestionServise servise){
        this.servise = servise;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return servise.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question,@RequestParam String answer) {
        return servise.remove(new Question(question,answer));
    }
    @GetMapping("/remove")
    public Collection<Question> getAll() {
        return servise.getAll();
    }
}
