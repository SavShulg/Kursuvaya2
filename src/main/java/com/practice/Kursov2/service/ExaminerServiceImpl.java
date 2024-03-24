package com.practice.Kursov2.service;

import com.practice.Kursov2.exeptions.NotEnoughQuestionException;
import com.practice.Kursov2.model.Question;
import jdk.internal.org.objectweb.asm.tree.analysis.SourceValue;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final ExaminerService questionService;

    public ExaminerServiceImpl(ExaminerService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allQuestions = questionService.getAll();
        if (!(amount <= allQuestions.size)) {
            throw new NotEnoughQuestionException();
        }

        if (amount == allQuestions.size) {
            return (Collection<Question>) allQuestions;
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }

    @Override
    public SourceValue getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
